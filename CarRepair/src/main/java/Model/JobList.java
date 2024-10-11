package Model;
import Model.Job;
import java.util.ArrayList;
import java.util.List;

public class JobList {
    private List<Job>jobList;
    
    public JobList(){
        jobList = new ArrayList<Job>();
    }
    
    public List<Job> getJobList() {
        return jobList;
    } 
    
    //Adds new job to the job list with data based on user's input
    public void addJob(Job sentJob){
        jobList.add(sentJob);
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
