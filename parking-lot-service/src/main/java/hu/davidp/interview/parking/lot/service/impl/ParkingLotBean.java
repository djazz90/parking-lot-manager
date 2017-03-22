package hu.davidp.interview.parking.lot.service.impl;

import hu.davidp.interview.parking.lot.service.api.service.ParkingLotService;
import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import hu.davidp.interview.parking.lot.service.data.WebAppData;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * EJB representation of {@link ParkingLotService}
 *
 * @author pintyo
 */
@Stateless(mappedName = "ParkingLotService")
@Local(ParkingLotService.class)
public class ParkingLotBean implements ParkingLotService {

    @Override
    public List<ParkingLot> findAll() {
        return WebAppData.getParkingLots();
    }

}
