package hu.davidp.interview.parking.lot.web.managedbeans;

import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "carRegistryView")
@ViewScoped
public class CarRegistryView {

    @EJB
    private CarRegistryService carRegistryService;

    public List<Car> listAllCars() {
        return carRegistryService.findAll();
    }
}
