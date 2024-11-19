package com.mycompany.carrepairgui.Model;
import com.mycompany.carrepairgui.Model.Car;
import com.mycompany.carrepairgui.Model.Owner;
import com.mycompany.carrepairgui.Model.JobStatus;
import com.mycompany.carrepairgui.Model.IncorrectDataException;
import static com.mycompany.carrepairgui.Model.JobStatus.PENDING;
import lombok.*;
@Getter
@Setter
/**
 * Part of a model that marges owner with his car and makes it an object
 * @author mateu
 */
public class Job {
    private JobStatus status;
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
    public Job(String name, String surname, String model, String registration, double mileage) throws IncorrectDataException{
        if(mileage <= 0){
            throw new IncorrectDataException("Mileage can not be less than 0!");
        }
        else{
            this.status = PENDING;
            owner = new Owner(name, surname);
            car = new Car(model, registration, mileage);
        }
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
