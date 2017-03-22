package hu.davidp.interview.parking.lot.web.managedbeans.domain;

import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a helper object that represents all data on a tab on the parking page.
 *
 * @author pintyo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingDetails {

    private ParkingLot parkingLot;
    private Date parkFrom;
    private Date parkTo;
}
