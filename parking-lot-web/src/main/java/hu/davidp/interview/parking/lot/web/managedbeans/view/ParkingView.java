package hu.davidp.interview.parking.lot.web.managedbeans.view;

import hu.davidp.interview.parking.lot.service.api.exception.CarNotFoundException;
import hu.davidp.interview.parking.lot.service.api.exception.ParkingIntervalIsIncorrectException;
import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.service.ParkingLotService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import hu.davidp.interview.parking.lot.web.managedbeans.domain.ParkingDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Data;

@ManagedBean(name = "parkingView")
@ViewScoped
@Data
public class ParkingView {

    private String licensePlateNum;
    private Car selectedCar;

    /**
     * This object holds all the tabs data on the parking page.
     */
    //PMD warnings are suppressed, because it just checks the compiled class file, and not the page.
    //PMD states that this should be a local variable, because nothing is using it in this class.
    @SuppressWarnings("PMD")
    private List<ParkingDetails> parkingDetailsList;

    @EJB
    private CarRegistryService carRegistryService;

    @EJB
    private ParkingLotService parkingLotService;

    @PostConstruct
    public void init() {

        parkingDetailsList = new ArrayList<>();
        getAvailableParkingLots().stream()
                .forEach(e -> {
                    parkingDetailsList.add(
                            ParkingDetails.builder()
                                    .parkingLot(e)
                                    .build()
                    );
                });
    }

    public Car getSelectedCar() {
        //This kind of "caching" is needed, because the selected car wouldn't be obtainable in the init method
        //in a regular way. The selected car's license plate number comes from a request parameter, and it is not available
        //just after the construction of the managed bean. Also selected car is used more than one times on the page and its
        //backing bean.
        if (selectedCar == null) {
            try {
                selectedCar = carRegistryService.findByLicensePlateNumber(licensePlateNum);
            } catch (CarNotFoundException ex) {
                Logger.getLogger(ParkingView.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return selectedCar;
    }

    public List<ParkingLot> getAvailableParkingLots() {
        return parkingLotService.findAll();
    }

    public void park(final ParkingDetails parkingDetails) throws CarNotFoundException {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            carRegistryService.modifyParkingLotAndDateInterval(selectedCar.getLicensePlateNumber(),
                    parkingDetails.getParkingLot(), parkingDetails.getParkFrom(), parkingDetails.getParkTo());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "A parkolás sikeres!",
                    "Minden adat mentésre került!");
            context.addMessage(null, message);
            init();
        } catch (ParkingIntervalIsIncorrectException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "A parkolás sikertelen!",
                    ex.getMessage() + " Kérjük helyesen töltse ki a parkolás kezdete és vége mezőket!");
            context.addMessage(null, message);
            Logger.getLogger(ParkingView.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
