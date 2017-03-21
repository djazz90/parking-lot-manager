package hu.davidp.interview.parking.lot.service.impl;

import hu.davidp.interview.parking.lot.service.api.exception.CarIsAlreadyInAParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.exception.ParkingIntervalIsIncorrectException;
import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import hu.davidp.interview.parking.lot.service.data.WebAppData;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(mappedName = "CarRegistryService")
@Local(CarRegistryService.class)
public class CarRegistryBean implements CarRegistryService {

    @Override
    public List<Car> findAll() {
        return WebAppData.getCars();
    }

    @Override
    public void addCar(final Car car) {
        Car newCar = Car.builder()
                .licensePlateNumber(car.getLicensePlateNumber())
                .brand(car.getBrand())
                .type(car.getType())
                .color(car.getColor())
                .build();
        WebAppData.addCar(newCar);
    }

    @Override
    public Car findByLicensePlateNumber(final String licensePlateNumber) throws CarNotFoundException {
        List<Car> cars = WebAppData.getCars().stream()
                .filter(e -> e.getLicensePlateNumber().equals(licensePlateNumber))
                .collect(Collectors.toList());
        if (!cars.isEmpty()) {
            return cars.get(0);
        }
        throw new CarNotFoundException("Nincs autó az adatbázisban a következő rendszámmal: " + licensePlateNumber);

    }

    @Override
    public boolean containsCar(final String licensePlateNumber) {
        try {
            findByLicensePlateNumber(licensePlateNumber);
            return true;
        } catch (CarNotFoundException ex) {
            return false;
        }
    }

    @Override
    public String deleteCar(final Car car) throws CarNotFoundException, CarIsAlreadyInAParkingLotException {
        if (car != null) {
            if (car.getActualParkingLot() != null) {
                throw new CarIsAlreadyInAParkingLotException("Olyan autó nem törölhető, ami parkolóban van!");
            }
            if (WebAppData.getCars().contains(car)) {
                WebAppData.getCars().remove(car);
                return car.getLicensePlateNumber();
            }
        }
        throw new CarNotFoundException("Nincs ilyen autó az adatbázisban!");
    }

    @Override
    public void modifyParkingLotAndDateInterval(final String licensePlateNumber, final ParkingLot parkingLot,
            final Date parkingFrom, final Date parkingTo) throws CarNotFoundException, ParkingIntervalIsIncorrectException {
        if (parkingFrom == null || parkingTo == null) {
            throw new ParkingIntervalIsIncorrectException("A parkolás kezdete vagy vége nincs megadva!");
        }

        if (parkingTo.before(parkingFrom)) {
            throw new ParkingIntervalIsIncorrectException("A parkolás vége hamarabb van, mint annak kezdete!");
        }

        Car actualCar = findByLicensePlateNumber(licensePlateNumber);
        actualCar.setActualParkingLot(parkingLot);
        actualCar.setParkingFrom(parkingFrom);
        actualCar.setParkingTo(parkingTo);
    }

}
