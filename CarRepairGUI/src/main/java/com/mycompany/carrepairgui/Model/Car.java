package com.mycompany.carrepairgui.Model;
import com.mycompany.carrepairgui.Model.IncorrectDataException;
import lombok.*;
@AllArgsConstructor
@Getter
@Setter
public class Car {
    private String model;
    private String registration;
    private double mileage;
}

