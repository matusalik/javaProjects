package com.mycompany.carrepairgui.Model;
import lombok.*;
@AllArgsConstructor
@Getter
public class Car {
    private String model;
    private String registration;
    private double mileage;
    
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

