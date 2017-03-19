package hu.davidp.interview.parking.lot.service.impl;

import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import hu.davidp.interview.parking.lot.service.data.WebAppData;
import java.util.List;
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

}
