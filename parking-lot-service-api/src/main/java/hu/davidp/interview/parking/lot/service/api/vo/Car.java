package hu.davidp.interview.parking.lot.service.api.vo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;
    private ParkingLot actualParkingLot;
    private Date parkingFrom;
    private Date parkingTo;
}
