package com.mycompany.carrepairweb.Model;
import static com.mycompany.carrepairweb.Model.JobStatus.PENDING;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.Random;
import lombok.*;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
/**
 * Part of a model that marges owner with his car and makes it an object
 * @author mateu
 */
public class Job {
    @Id
    private int id;
    
    @Column(name = "model", length = 30)
    private String model;
    
    @Column(name = "registration", length = 30)
    private String registration;
    
    @Column(name = "mileage")
    private double mileage;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "status")
    private JobStatus status;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id", nullable = false) 
//    private Owner owner;
//    
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "car_id", nullable = false)
//    private Car car;
    
    /**
     * Basic constructor that gets all job data and saves it
     * @param name
     * @param surname
     * @param model
     * @param registration
     * @param mileage 
     */
    public Job(String name, String surname, String model, String registration, double mileage) throws IncorrectDataException{
        Random rand = new Random();
        this.id = Math.abs(rand.nextInt() % 1000);
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
            this.name = name;
            this.surname = surname;
            this.model = model;
            this.registration = registration;
            this.mileage = mileage;
//            owner = new Owner(name, surname);
//            car = new Car(model, registration, mileage);
        }
    }  
    
    public Job(int id, String name, String surname, String model, String registration, double mileage, JobStatus status) throws IncorrectDataException{
        this.id = id;
        if(name == null || surname == null || registration == null || model == null || status == null){
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
            this.status = status;
            this.name = name;
            this.surname = surname;
            this.model = model;
            this.registration = registration;
            this.mileage = mileage;
        }
    }
    /**
     * Overriden method to convert all job data to string
     * @return Job data as string
     */
    @Override
    public String toString(){
        return this.name + " " + this.surname + " " + 
                this.model + " " + this.registration + " " + this.mileage; 
    }
}
