package hu.davidp.interview.parking.lot.web.managedbeans.view;

import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.service.ParkingLotService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;

@ManagedBean(name = "parkingView")
@ViewScoped
@Data
public class ParkingView {

    private String licensePlateNum;

    @EJB
    private CarRegistryService carRegistryService;

    @EJB
    private ParkingLotService parkingLotService;

    public Car getSelectedCar() throws CarNotFoundException {
        return carRegistryService.findByLicensePlateNumber(licensePlateNum);
    }

    public List<ParkingLot> getAvailableParkingLots() {
        return parkingLotService.findAll();
    }
}
