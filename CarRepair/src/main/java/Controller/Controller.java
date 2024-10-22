package Controller;
import Model.JobList;
import Model.JobNotFoundException;
import Model.IncorrectInputTypeException;
import View.View;

public class Controller {
    private JobList jobList;
    private View view;
    public Controller(JobList sentJobList, View sentView){
        jobList = sentJobList;
        view = sentView;
        Boolean Switch = true;
        view.welcomeMessage();
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
