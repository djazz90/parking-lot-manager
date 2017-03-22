package hu.davidp.interview.parking.lot.service.api.exception;

/**
 *
 * @author pintyo
 */
public class CarIsNotInParkingLotException extends Exception {

    /**
     * Creates a new instance of <code>CarIsNotInParkingLotException</code> without detail message.
     */
    public CarIsNotInParkingLotException() {
        //intentionally left blank
    }

    /**
     * Constructs an instance of <code>CarIsNotInParkingLotException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CarIsNotInParkingLotException(final String msg) {
        super(msg);
    }
}
