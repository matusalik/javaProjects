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
    
    //Getter returning car's model
    public String getModel() {
        return model;
    }

    //Getter returning car's registration
    public String getRegistration() {
        return registration;
    }

    //Getter returning car's mileage
    public double getMileage() {
        return mileage;
    }
}
