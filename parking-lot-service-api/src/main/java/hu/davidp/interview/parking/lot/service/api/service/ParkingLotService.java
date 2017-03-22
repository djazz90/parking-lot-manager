package hu.davidp.interview.parking.lot.service.api.service;

import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.util.List;

/**
 * This interface defines the methods that should be implemented for parking lot management.
 *
 * @author pintyo
 */
public interface ParkingLotService {

    /**
     * Returns all parking lots in the database.
     *
     * @return list that contains all parking lot objects in the database.
     */
    List<ParkingLot> findAll();

}
