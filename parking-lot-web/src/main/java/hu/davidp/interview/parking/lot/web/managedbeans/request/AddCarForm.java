/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.davidp.interview.parking.lot.web.managedbeans.request;

import hu.davidp.interview.parking.lot.service.api.service.CarRegistryService;
import hu.davidp.interview.parking.lot.service.api.vo.Car;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Data;

/**
 * This backing bean represents the form of car addition to the database. It helps showing the proper messages to the
 * user during success or failure.
 *
 * @author pintyo
 */
@ManagedBean(name = "addCarForm")
@RequestScoped
@Data
public class AddCarForm {

    @EJB
    private CarRegistryService carRegistryService;

    private Car car;

    /**
     * Resets all the fields of the form.
     */
    @PostConstruct
    public void init() {
        car = new Car();
    }

    /**
     * This method is called when the user clicks the submit button when a car is going to be added to the database.
     * <br>The save will fail if the car's license plate number is already in the database and the corresponding error
     * message will be shown. If the save is successful, the message will be delivered to the user.
     */
    public void submit() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (carRegistryService.containsCar(car.getLicensePlateNumber())) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A mentés sikertelen!",
                    String.format("A(z) %s rendszámmal rendelkező autó már szerepel az adatbázisban!", car.getLicensePlateNumber())));
        } else {
            carRegistryService.addCar(car);
            context.addMessage(null, new FacesMessage("A mentés sikeres!", String.format("A(z) %s rendszámmal rendelkező autó mentésre került!",
                    car.getLicensePlateNumber())));
            init();
        }
    }
}
