package Model;
import Model.Car;
import Model.Owner;

public class Job {
    private Owner owner;
    private Car car;
    
    public Job(String name, String surname, String model, String registration, double mileage){
        owner = new Owner(name, surname);
        car = new Car(model, registration, mileage);
    }
    
    public Owner getOwner(){
        return owner;
    }
    
    public Car getCar(){
        return car;
    }
    
    @Override
    public String toString(){
        return owner.getName() + " " + owner.getSurname() + " " + 
                car.getModel() + " " + car.getRegistration() + " " + car.getMileage(); 
    }
}
