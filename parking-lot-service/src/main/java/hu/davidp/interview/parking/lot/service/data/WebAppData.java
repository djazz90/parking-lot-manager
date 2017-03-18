package hu.davidp.interview.parking.lot.service.data;

import hu.davidp.interview.parking.lot.service.api.vo.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public final class WebAppData {

    private static WebAppData data;

    @Getter
    @Setter
    private static List<Car> cars;

    static {
        data = new WebAppData();
        //dummy data initialization
        Car c1 = Car.builder()
                .brand("Suzuki")
                .type("Swift")
                .color("Citromsárga")
                .licensePlateNumber("HUN-001")
                .build();

        Car c2 = Car.builder()
                .brand("Toyota")
                .type("Celica")
                .color("Fekete")
                .licensePlateNumber("HUN-002")
                .build();

        Car c3 = Car.builder()
                .brand("Lada")
                .type("Niva")
                .color("Fehér")
                .licensePlateNumber("HUN-003")
                .build();

        cars = new ArrayList<>(Arrays.asList(c1, c2, c3));

    }

    private WebAppData() {
    }

    public static WebAppData getInstance() {
        return data;
    }

}
