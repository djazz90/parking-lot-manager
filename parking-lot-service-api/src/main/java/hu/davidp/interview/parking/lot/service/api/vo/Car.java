package hu.davidp.interview.parking.lot.service.api.vo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The object representation of the cars that the application manages.
 *
 * @author pintyo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;

    /**
     * The parking lot where the car is actually at.
     */
    private ParkingLot actualParkingLot;

    /**
     * The date when the parking started.
     */
    private Date parkingFrom;

    /**
     * The date when the parking ended or will end.
     */
    private Date parkingTo;
}
