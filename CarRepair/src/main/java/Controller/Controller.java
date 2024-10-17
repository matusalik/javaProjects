package Controller;
import Model.JobList;
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
                    jobList.addJob(view.addJob());
                    break;
                case "deljob":
                    if(jobList.delJob(view.delJob()))
                        view.succesfullJobDeletionMessage();
                    else
                        view.unsuccesfullJobDeletionMessage();
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
