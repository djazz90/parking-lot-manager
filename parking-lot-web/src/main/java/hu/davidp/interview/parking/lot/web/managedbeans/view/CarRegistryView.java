package hu.davidp.interview.parking.lot.web.managedbeans.view;

import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;

@ManagedBean(name = "carRegistryView")
@ViewScoped
@Data
public class CarRegistryView {

    private Car selectedCar;

    @EJB
    private CarRegistryService carRegistryService;

    public List<Car> listAllCars() {
        return carRegistryService.findAll();
    }

}
