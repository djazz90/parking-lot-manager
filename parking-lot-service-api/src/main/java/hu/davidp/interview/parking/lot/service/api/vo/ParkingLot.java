package hu.davidp.interview.parking.lot.service.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The object representation of the parking lots that the application manages.
 *
 * @author pintyo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingLot {

    private String name;

}
