package com.mycompany.carrepairgui.Model;
import com.mycompany.carrepairgui.Model.Job;
import com.mycompany.carrepairgui.Model.JobNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 * The most important part of the model
 * It's a list of a jobs that need to be finished
 * @author mateu
 */
public class JobList {
    private List<Job>jobList;
    
    /**
     * Constructor that initialize's ArrayList
     */
    public JobList(){
        jobList = new ArrayList<Job>();
    }
    
    /**
     * Returns full job list
     * @return 
     */
    public List<Job> getJobList() {
        return jobList;
    } 
    
    /**
     * Adds new job to the job list with data based on user's input
     * @param sentJob 
     */
    public void addJob(Job sentJob){
        jobList.add(sentJob);
    } 
    
    /**
     * Deletes finished job based on car's registration input by user if there's no job with a car with given registration it throws an exception
     * @param sentRegistration
     * @throws JobNotFoundException 
     */
    public void delJob(String sentRegistration) throws JobNotFoundException{
        for(int i = 0; i < jobList.size(); i++){
            if(jobList.get(i).getCar().getRegistration().equals(sentRegistration)){
                jobList.remove(i);   
                return;
            }
        }
        throw new JobNotFoundException("Job with car's registration: " + sentRegistration + " not found!");
    }
    
    /**
     * Overriden method which return job list as a string
     * @return 
     */
    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < jobList.size(); i++){
            res = res + jobList.get(i).toString() + "\n";
        }
        return res;
    }
}
