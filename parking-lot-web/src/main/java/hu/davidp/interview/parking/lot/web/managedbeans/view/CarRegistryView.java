package hu.davidp.interview.parking.lot.web.managedbeans.view;

import hu.davidp.interview.parking.lot.service.api.exception.CarIsAlreadyInAParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarIsNotInParkingLotException;
import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Data;

/**
 * This is the backing bean of the car management.
 *
 * @author pintyo
 */
@ManagedBean(name = "carRegistryView")
@ViewScoped
@Data
public class CarRegistryView {

    private Car selectedCar;

    @EJB
    private CarRegistryService carRegistryService;

    /**
     * Lists all cars in the database.
     *
     * @return the list with all the cars
     */
    public List<Car> listAllCars() {
        return carRegistryService.findAll();
    }

    /**
     * Removes the currently selected car in the table and the database when the remove car button is clicked. If any
     * error occurs or the save is successful, the user will be prompted.
     *
     */
    public void removeSelectedCar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            carRegistryService.deleteCar(selectedCar);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "A törlés sikeres!",
                    "Az autó törölve lett az adatbázisból!"));
            selectedCar = null;
        } catch (CarNotFoundException | CarIsAlreadyInAParkingLotException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A törlés sikertelen!",
                    ex.getMessage() + " Kérjük válasszon ki egy megfelelő autót!"));
            Logger.getLogger(CarRegistryView.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    /**
     * Removes the car from the parking lot that it is already in. If any error occurs or the save is successful, the
     * user will be prompted.
     *
     */
    public void removeCarFromParkingLot() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            carRegistryService.deleteParkingLotInformation(selectedCar);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "A törlés sikeres!",
                    "Az autó parkoló információi törölve lettek az adatbázisból!"));
            selectedCar = null;
        } catch (CarNotFoundException | CarIsNotInParkingLotException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A törlés sikertelen!",
                    ex.getMessage() + " Kérjük válasszon ki egy megfelelő autót!"));
            Logger.getLogger(CarRegistryView.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
