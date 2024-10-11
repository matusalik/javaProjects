package com.mycompany.carrepair;
import Model.JobList;
import Controller.Controller;
import View.View;
public class CarRepair {

    public static void main(String[] args) {
        //MODEL
        JobList jobList = new JobList();
        
        //VIEW  
        View view = new View();
        
        //CONTROLLER
        Controller controller = new Controller(jobList, view);
    }
}
