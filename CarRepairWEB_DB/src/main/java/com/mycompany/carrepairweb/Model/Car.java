package com.mycompany.carrepairweb.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
public class Car {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "model", length = 30)
    private String model;
    
    @Column(name = "registration", length = 30)
    private String registration;
    
    @Column(name = "mileage")
    private double mileage;
    
    public Car(String model, String registration, double mileage){
        model = model;
        registration = registration;
        mileage = mileage;
    }
    
    public void setModel(String sentModel) throws IncorrectDataException{
        if(sentModel == null || sentModel.equals("") || sentModel.equals(" ") || sentModel.equals("\n")){
            throw new IncorrectDataException("Model  can't be empty!");
        }
        else{
            this.model  = sentModel;
        }
    }
    
    public void setRegistration(String sentRegistration) throws IncorrectDataException{
        if(sentRegistration == null || sentRegistration.equals("") || sentRegistration.equals(" ") || sentRegistration.equals("\n")){
            throw new IncorrectDataException("Registration  can't be empty!");
        }
        else{
            this.registration  = sentRegistration;
        }
    }
    
    public void setMileage(double sentMileage) throws IncorrectDataException{
        if(sentMileage <  0){
            throw new IncorrectDataException("Mileage can't be less than 0!");
        }
        else{
            this.mileage = sentMileage;
        }
    }
}

