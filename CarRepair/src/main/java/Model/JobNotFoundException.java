package Model;
/**
 * Exception made to check if car with given registration exists
 * @author mateu
 */
public class JobNotFoundException extends Exception{
    public JobNotFoundException(String message){
        super(message);
    }
}
