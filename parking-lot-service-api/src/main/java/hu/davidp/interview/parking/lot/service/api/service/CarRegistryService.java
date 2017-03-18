package hu.davidp.interview.parking.lot.service.api.service;

import hu.davidp.interview.parking.lot.service.api.vo.Car;
import java.util.List;

public interface CarRegistryService {
    List<Car> findAll();
}
