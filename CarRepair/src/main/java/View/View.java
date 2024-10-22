package View;
import java.util.Scanner;
import Model.JobList;
import Model.Job;
import Model.IncorrectInputTypeException;

public class View {
    /**
     * Method that shows whole job list
     * @param jobList 
     */
    public void showJobs(JobList jobList){
        System.out.println(jobList.toString());
    }
    /**
     * Method that welcomes user 
     */
    public void welcomeMessage(){
        System.out.println("Hello!\nThis is you Job Agenda!\nPlease type in what do you want you want to do.\nIf you dont know any commands, type 'help'.");
    }
    /**
     * Method that takes input from user and returns it in String
     * @return 
     */
    public String commandPrompt(){
        System.out.print("Command: ");
        Scanner in = new Scanner(System.in);
        String res = in.nextLine();
        return res;
    }
    /**
     * Method to inform that user succesfully deleted a job
     */
    public void succesfullJobDeletionMessage(){
        System.out.println("Succesfully deleted a finished job!");
    }
    /**
     * Method to tell user that their command was unknown
     */
    public void unknownCommandMessage(){
        System.out.println("Uknown command! Try again or type 'help'.");
    }
    /**
     * Method printing jobDeletion exception message
     * @param message 
     */
    public void showJobDeletionExceptionMessage(String message){
        System.out.println(message);
    }
    /**
     * Method printing jobAdding exception message
     * @param message 
     */
    public void showIncorrectInputExceptionMessage(String message){
        System.out.println(message);
    }
    /**
     * Method to show user full list of commands available
     */
    public void listOfCommands(){
        System.out.println("exit - quits the program\nhelp - shows the full list of commands\naddjob - lets you add a new job\ndeljob - lets you delete a job you already finished"
                + "\nshowjobs - shows you full list of your jobs");
    }
    /**
     * Method that lets user add new job to his agenda
     * @return
     * @throws IncorrectInputTypeException 
     */
    public Job addJob() throws IncorrectInputTypeException{
        Scanner in = new Scanner(System.in);
        System.out.print("Owner's name: ");
        String name = in.nextLine();
        System.out.print("Owner's surname: ");
        String surname = in.nextLine();
        System.out.print("Car's model: ");
        String model = in.nextLine();
        System.out.print("Car's registration: ");
        String registration = in.nextLine();
        System.out.print("Car's mileage: ");
        String mileage = in.nextLine();
        double dmileage = 0;
        try {
            dmileage = Double.parseDouble(mileage);  
        }catch(NumberFormatException e){
            throw new IncorrectInputTypeException("Incorrect mileage input! Please try again.");
        }
        Job res = new Job(name, surname, model, registration, dmileage);
        System.out.println("Job added succesfully!");
        return res;
    }
    /**
     * Method that lets user delete finished job
     * @return 
     */
    public String delJob(){
        Scanner in = new Scanner(System.in);
        System.out.print("Registration of a car you finished working on: ");
        String registration = in.nextLine();
        return registration;
    }
}
