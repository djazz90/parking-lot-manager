package hu.davidp.interview.parking.lot.service.data;

import hu.davidp.interview.parking.lot.service.api.vo.Car;
import hu.davidp.interview.parking.lot.service.api.vo.ParkingLot;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

/**
 * The static list database of the application.
 *
 * @author pintyo
 */
//Prevents build failure. Warnings suppressed, because PMD doesn't recognize the getters and setters provided by lombok.
@SuppressWarnings("PMD")
public final class WebAppData {

    @Getter
    @Setter
    private static List<Car> cars;

    @Getter
    @Setter
    private static List<ParkingLot> parkingLots;

    static {
        //dummy data initialization
        ParkingLot p1 = ParkingLot.builder()
                .name("Plaza parkolóház")
                .build();

        ParkingLot p2 = ParkingLot.builder()
                .name("Hotel parkolóház")
                .build();

        ParkingLot p3 = ParkingLot.builder()
                .name("Utcai parkoló")
                .build();

        parkingLots = new ArrayList<>(Arrays.asList(p1, p2, p3));

        Car c1 = Car.builder()
                .brand("Suzuki")
                .type("Swift")
                .color("Citromsárga")
                .licensePlateNumber("HUN-001")
                .build();

        String str1 = "2016-11-12 11:11";
        String str2 = "2016-11-12 13:11";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm", Locale.ROOT);
        Date from = null;
        Date to = null;
        try {
            from = df.parse(str1);
            to = df.parse(str2);

        } catch (ParseException ex) {
            Logger.getLogger(WebAppData.class.getName()).log(Level.SEVERE, null, ex);
        }

        Car c2 = Car.builder()
                .brand("Toyota")
                .type("Celica")
                .color("Fekete")
                .licensePlateNumber("HUN-002")
                .actualParkingLot(p1)
                .parkingFrom(from)
                .parkingTo(to)
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

}
