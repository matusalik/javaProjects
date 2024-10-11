package Model;

public class Car {
    private String model;
    private String registration;
    private double mileage;
    
    public Car(String sentModel, String sentRegistration, double sentMileage){
        model = sentModel;
        registration = sentRegistration;
        mileage = sentMileage;
    }
    
    public String getModel() {
        return model;
    }

    public String getRegistration() {
        return registration;
    }

    public double getMileage() {
        return mileage;
    }
}
