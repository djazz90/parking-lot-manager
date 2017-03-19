package hu.davidp.interview.parking.lot.service.api;

/**
 *
 * @author pintyo
 */
public class CarNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>CarNotFoundException</code> without detail message.
     */
    public CarNotFoundException() {
        //intentionally left blank
    }

    /**
     * Constructs an instance of <code>CarNotFoundException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CarNotFoundException(final String msg) {
        super(msg);
    }
}
