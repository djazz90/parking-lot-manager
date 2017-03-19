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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Data;

@ManagedBean(name = "addCarForm")
@RequestScoped
@Data
public class AddCarForm {

    @EJB
    private CarRegistryService carRegistryService;

    private Car car;

    @PostConstruct
    public void init() {
        car = new Car();
    }

    public void submit() {
        carRegistryService.addCar(car);
    }
}
