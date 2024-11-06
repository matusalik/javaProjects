package com.mycompany.carrepairgui.Model;
import com.mycompany.carrepairgui.Model.Car;
import com.mycompany.carrepairgui.Model.Owner;

/**
 * Part of a model that marges owner with his car and makes it an object
 * @author mateu
 */
public class Job {
    private Owner owner;
    private Car car;
    
    /**
     * Basic constructor that gets all job data and saves it
     * @param name
     * @param surname
     * @param model
     * @param registration
     * @param mileage 
     */
    public Job(String name, String surname, String model, String registration, double mileage){
        owner = new Owner(name, surname);
        car = new Car(model, registration, mileage);
    }
    
    /**
     * Basic getter
     * @return Owner
     */
    public Owner getOwner(){
        return owner;
    }
    
    /**
     * Basic getter
     * @return Car
     */
    public Car getCar(){
        return car;
    }
    
    /**
     * Overriden method to convert all job data to string
     * @return Job data as string
     */
    @Override
    public String toString(){
        return owner.getName() + " " + owner.getSurname() + " " + 
                car.getModel() + " " + car.getRegistration() + " " + car.getMileage(); 
    }
}
