package hu.davidp.interview.parking.lot.service.api.service;

import hu.davidp.interview.parking.lot.service.api.exception.CarIsAlreadyInAParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import java.util.List;

public interface CarRegistryService {

    List<Car> findAll();

    void addCar(Car car);

    Car findByLicensePlateNumber(String licensePlateNumber) throws CarNotFoundException;

    boolean containsCar(String licensePlateNumber);

    String deleteCar(Car car) throws CarNotFoundException, CarIsAlreadyInAParkingLotException;

}
