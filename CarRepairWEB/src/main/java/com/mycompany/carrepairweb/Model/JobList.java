package com.mycompany.carrepairweb.Model;
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
        try{
        addJob(new Job("a", "b", "c", "d", 1));
        addJob(new Job("g", "b", "c", "d", 300));
        addJob(new Job("7", "b", "21", "d", 31237));
        }
        catch(IncorrectDataException e){
            
        }
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
    public void addJob(Job sentJob) throws IncorrectDataException{
        if(sentJob  == null){
            throw new IncorrectDataException("Job can't be null!");
        }
        else{
            jobList.add(sentJob);
        }
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
