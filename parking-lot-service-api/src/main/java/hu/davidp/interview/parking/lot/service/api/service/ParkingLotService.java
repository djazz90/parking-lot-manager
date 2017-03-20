package hu.davidp.interview.parking.lot.service.api.service;

import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.util.List;

public interface ParkingLotService {

    List<ParkingLot> findAll();

}
