package com.mycompany.carrepairweb.Model;
import java.util.ArrayList;
import java.util.List;
/**
 * The most important part of the model
 * It's a list of a jobs that need to be finished
 * @author mateu
 */
public class JobList implements DataSource{
    private List<Job>jobList;
    
    /**
     * Constructor that initializes ArrayList
     */
    public JobList(){
        jobList = new ArrayList<Job>();
        try{
        addJob(new Job("Mateusz", "Salik", "HONDA CIVIC", "SZO 6G60", 190000.45));
        addJob(new Job("Zuzanna", "Krzysztofik", "OPEL CORSA", "KR COSTAM", 51000.54));
        addJob(new Job("Kamil", "Krupa", "MITSUBISHI LANCER", "SK COSTAM", 2137.420));
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

    /**
     * Function returning jobList array used by DataSource
     * @return 
     */
    @Override
    public List<Job> getJobs() {
        return jobList;
    }

    /**
     * Function used for persisting an object used by DataSource
     * @param object 
     */
    @Override
    public void persistObject(Object object) {
        if(object instanceof Job job) jobList.add(job);
    }

    /**
     * Function updating jobList used by DataSource
     * @param job
     * @return 
     */
    @Override
    public boolean update(Job job) {
        for(int i = 0; i < jobList.size(); ++i){
            if(jobList.get(i).getId() == job.getId()){
                jobList.set(i, job);
                return true;
            }
        }
        return false;
    }

    /**
     * Function deleting job from jobList based on id, used by DataSource
     * @param id
     * @return 
     */
    @Override
    public boolean delete(int id) {
        return jobList.removeIf(i -> i.getId() == id);
    }
}
