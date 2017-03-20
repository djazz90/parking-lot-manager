package hu.davidp.interview.parking.lot.service.api.exception;

/**
 *
 * @author pintyo
 */
public class CarIsAlreadyInAParkingLotException extends Exception {

    /**
     * Creates a new instance of <code>CarIsAlreadyInAParkingLotException</code> without detail message.
     */
    public CarIsAlreadyInAParkingLotException() {
        //intentionally left blank
    }

    /**
     * Constructs an instance of <code>CarIsAlreadyInAParkingLotException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CarIsAlreadyInAParkingLotException(final String msg) {
        super(msg);
    }
}
