package hu.davidp.interview.parking.lot.web.managedbeans.domain;

import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingDetails {

    private ParkingLot parkingLot;
    private Date parkFrom;
    private Date parkTo;
    private String name;
}
