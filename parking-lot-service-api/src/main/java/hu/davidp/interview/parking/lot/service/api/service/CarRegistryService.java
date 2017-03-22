package hu.davidp.interview.parking.lot.service.api.service;

import hu.davidp.interview.parking.lot.service.api.exception.CarIsAlreadyInAParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarIsNotInParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.exception.ParkingIntervalIsIncorrectException;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.util.Date;
import java.util.List;

/**
 * This interface defines which methods should be implemented for the basic car managing functionality of the
 * application.
 *
 * @author pintyo
 */
public interface CarRegistryService {

    /**
     * Returns all cars in the database.
     *
     * @return a list that contains all car objects in the database.
     */
    List<Car> findAll();

    /**
     * Adds a car to the database.
     *
     * @param car the car that should be added.
     */
    void addCar(Car car);

    /**
     * Modifies a car's parking information.
     *
     * @param licensePlateNumber the car's license plate number
     * @param parkingLot the new parking lot
     * @param parkingFrom the date when the parking starts
     * @param parkingTo the date when the parking ends
     * @throws CarNotFoundException when the car is not found in the database
     * @throws ParkingIntervalIsIncorrectException when the end date is before the start date
     */
    void modifyParkingLotAndDateInterval(String licensePlateNumber, ParkingLot parkingLot,
            Date parkingFrom, Date parkingTo) throws CarNotFoundException, ParkingIntervalIsIncorrectException;

    /**
     * Finds a car by its license plate number.
     *
     * @param licensePlateNumber the car's license plate number
     * @return the found car from the database
     * @throws CarNotFoundException when the car is not found in the database
     */
    Car findByLicensePlateNumber(String licensePlateNumber) throws CarNotFoundException;

    /**
     * Determines if the car is in the database or not.
     *
     * @param licensePlateNumber the car's license plate number
     * @return true, if the car is found in the database
     */
    boolean containsCar(String licensePlateNumber);

    /**
     * Deletes a car from the database. Those cars cannot be deleted which are in a parking lot.
     *
     * @param car the car to be deleted
     * @throws CarNotFoundException when the car is not found in the database
     * @throws CarIsAlreadyInAParkingLotException when the car is already in a parking lot
     */
    void deleteCar(Car car) throws CarNotFoundException, CarIsAlreadyInAParkingLotException;

    /**
     * Deletes a car's parking information.
     * <br>Namely:
     * <ul>
     * <li>It's parking lot object</li>
     * <li>The start of the parking</li>
     * <li>The end of the parking</li>
     * </ul>
     *
     * @param car the car thats parking information should be deleted
     * @throws CarNotFoundException when the car is not found in the database
     * @throws CarIsNotInParkingLotException when the car is not in any parking lot
     */
    void deleteParkingLotInformation(Car car) throws CarNotFoundException, CarIsNotInParkingLotException;

}
