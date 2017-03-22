package hu.davidp.interview.parking.lot.service.api.service;

import hu.davidp.interview.parking.lot.service.api.exception.CarIsAlreadyInAParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarIsNotInParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.exception.ParkingIntervalIsIncorrectException;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.util.Date;
import java.util.List;

public interface CarRegistryService {

    List<Car> findAll();

    void addCar(Car car);

    void modifyParkingLotAndDateInterval(String licensePlateNumber, ParkingLot parkingLot,
            Date parkingFrom, Date parkingTo) throws CarNotFoundException, ParkingIntervalIsIncorrectException;

    Car findByLicensePlateNumber(String licensePlateNumber) throws CarNotFoundException;

    boolean containsCar(String licensePlateNumber);

    void deleteCar(Car car) throws CarNotFoundException, CarIsAlreadyInAParkingLotException;

    void deleteParkingLotInformation(Car car) throws CarNotFoundException, CarIsNotInParkingLotException;

}
