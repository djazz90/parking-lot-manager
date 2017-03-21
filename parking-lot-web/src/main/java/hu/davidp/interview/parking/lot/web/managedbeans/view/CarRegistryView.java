package hu.davidp.interview.parking.lot.web.managedbeans.view;

import hu.davidp.interview.parking.lot.service.api.exception.CarIsAlreadyInAParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

    public void removeSelectedCar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            carRegistryService.deleteCar(selectedCar);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "A törlés sikeres!",
                    "Az autó törölve lett az adatbázisból"));
            selectedCar = null;
        } catch (CarNotFoundException | CarIsAlreadyInAParkingLotException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A törlés sikertelen!",
                    ex.getMessage() + " Kérjük válasszon ki egy létező autót!"));
        }
    }

}
