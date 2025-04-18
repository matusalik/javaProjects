package Model;

/**
 * Part of the model
 * Holds info about car
 * @author mateu
 */
public class Car {
    private String model;
    private String registration;
    private double mileage;
    
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
}
