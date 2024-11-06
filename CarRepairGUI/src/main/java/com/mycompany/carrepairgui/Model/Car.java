package com.mycompany.carrepairgui.Model;
public class Car {
    private String model;
    private String registration;
    private double mileage;
    
    /**
     * Basic contructor that gets Car's data and saves it
     * @param sentModel
     * @param sentRegistration
     * @param sentMileage 
     */
    public Car(String sentModel, String sentRegistration, double sentMileage){
        model = sentModel;
        registration = sentRegistration;
        mileage = sentMileage;
    }
    
    /**
     * Returns car's model
     * @return 
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns car's registration
     * @return 
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * Return car's mileage
     * @return 
     */
    public double getMileage() {
        return mileage;
    }
    
    /**
     * Basic setter, sets Car's model
     * @param sentModel 
     */
    public void setModel(String sentModel){
        model = sentModel;
    }
    
    /**
     * Basic setter, sets Car's registration
     * @param sentRegistration 
     */
    public void setRegistration(String sentRegistration){
        registration = sentRegistration;
    }
    
    /**
     * Basic setter, sets Car's mielage
     * @param sentMileage 
     */
    public void setMileage(double sentMileage){
        mileage = sentMileage;
    }
}

