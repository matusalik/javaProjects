package Controller;
import Model.JobList;
import Model.JobNotFoundException;
import Model.IncorrectInputTypeException;
import View.View;

/**
 * Class made to cotroll the whole program
 * It connects model with view
 * @author mateu
 */
public class Controller {
    private JobList jobList;
    private View view;
    public Controller(JobList sentJobList, View sentView, String[] args){
        jobList = sentJobList;
        view = sentView;
        if(args.length == 0){
            view.noArgsMessage();
            view.welcomeMessage();
        }
        else if(args.length == 2){
            view.welcomeMessage(args[0], args[1]);
        }
        else{
            view.incorrectAmountOfArgsMessage();
            view.welcomeMessage();
        }
        Boolean Switch = true;
        while(Switch){
            switch(view.commandPrompt()){
                case "exit":
                    Switch = false;
                    break;
                case "help":
                    view.listOfCommands();
                    break;
                case "addjob":
                    try{
                        jobList.addJob(view.addJob());
                    }
                    catch(IncorrectInputTypeException e){
                        view.showIncorrectInputExceptionMessage(e.getMessage());
                    }
                    break;
                case "deljob":
                    try{
                        jobList.delJob(view.delJob());
                        view.succesfullJobDeletionMessage();
                    }catch(JobNotFoundException e){
                        view.showJobDeletionExceptionMessage(e.getMessage());
                    }            
                    break; 
                case "showjobs":
                    view.showJobs(jobList);
                    break;
                default:
                    view.unknownCommandMessage();
            }                   
        }
    }
}
