package com.mycompany.carrepairgui.Model;
import static com.mycompany.carrepairgui.Model.JobStatus.PENDING;
import static java.lang.constant.ConstantDescs.NULL;
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
        if(name == null || surname == null || registration == null || model == null){
            throw new IncorrectDataException("No data can be null!");
        }
        else if(mileage <= 0){
            throw new IncorrectDataException("Mileage can not be less than 0!");
        }
        else if(name.equals("") || surname.equals("") || model.equals("") || registration.equals("")){
            throw new IncorrectDataException("No data can be empty!");
        }
        else if(name.equals(" ") || surname.equals(" ") || model.equals(" ") || registration.equals(" ")){
            throw new IncorrectDataException("No data can be empty!");
        }
        else if(name.equals("\n") || surname.equals("\n") || model.equals("\n") || registration.equals("\n")){
            throw new IncorrectDataException("No data can be empty!");
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
