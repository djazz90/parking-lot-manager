package hu.davidp.interview.parking.lot.service.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;
}