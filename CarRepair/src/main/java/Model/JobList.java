package Model;
import Model.Job;
import Model.JobNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class JobList {
    private List<Job>jobList;
    
    public JobList(){
        jobList = new ArrayList<Job>();
    }
    
    //Basic getter
    public List<Job> getJobList() {
        return jobList;
    } 
    
    //Adds new job to the job list with data based on user's input
    public void addJob(Job sentJob){
        jobList.add(sentJob);
    } 
    
    //Deletes finished job based on car's registration input by user if there's no job with a car with given registration it throws an exception
    public void delJob(String sentRegistration) throws JobNotFoundException{
        for(int i = 0; i < jobList.size(); i++){
            if(jobList.get(i).getCar().getRegistration().equals(sentRegistration)){
                jobList.remove(i);   
                return;
            }
        }
        throw new JobNotFoundException("Job with car's registration: " + sentRegistration + " not found!");
    }
    
    //Overriden method which return job list as a string
    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < jobList.size(); i++){
            res = res + jobList.get(i).toString() + "\n";
        }
        return res;
    }
}
