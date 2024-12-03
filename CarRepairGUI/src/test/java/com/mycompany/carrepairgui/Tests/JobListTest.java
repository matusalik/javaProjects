package com.mycompany.carrepairgui.Tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import com.mycompany.carrepairgui.Model.IncorrectDataException;
import com.mycompany.carrepairgui.Model.JobList;
import com.mycompany.carrepairgui.Model.Job;
public class JobListTest {
    @Test
    void jobListNullAddJobTest() throws IncorrectDataException{
        JobList testJobList = new JobList();
        Job testJob = null;
        try{
            testJobList.addJob(testJob);
            fail("Exception should've been thrown!");
        }
        catch(IncorrectDataException e){       
        }
    }
}
