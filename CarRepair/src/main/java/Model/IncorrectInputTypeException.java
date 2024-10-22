package Model;
/**
 * Exception made to check if user put correct data to program
 * @author mateu
 */
public class IncorrectInputTypeException extends Exception{
    public IncorrectInputTypeException(String message){
        super(message);
    }
}
