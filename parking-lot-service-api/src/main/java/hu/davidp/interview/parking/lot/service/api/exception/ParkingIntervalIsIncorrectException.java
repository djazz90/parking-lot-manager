package hu.davidp.interview.parking.lot.service.api.exception;

/**
 *
 * @author pintyo
 */
public class ParkingIntervalIsIncorrectException extends Exception {

    /**
     * Creates a new instance of <code>ParkingIntervalIsIncorrectException</code> without detail message.
     */
    public ParkingIntervalIsIncorrectException() {
        //intentionally left blank.
    }

    /**
     * Constructs an instance of <code>ParkingIntervalIsIncorrectException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ParkingIntervalIsIncorrectException(final String msg) {
        super(msg);
    }
}
