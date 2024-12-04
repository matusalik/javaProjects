package com.mycompany.carrepairgui.Tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.ParameterizedTest;
import com.mycompany.carrepairgui.Model.IncorrectDataException;
import com.mycompany.carrepairgui.Model.JobList;
import com.mycompany.carrepairgui.Model.Job;
public class JobListTest {
    /**
     * Test for testing jobList.addJob with null values
     * @param testJob
     * @throws IncorrectDataException 
     */
    @ParameterizedTest
    @NullSource
    void jobListNullAddJobTest(Job testJob) throws IncorrectDataException{
        JobList testJobList = new JobList();
        try{
            testJobList.addJob(testJob);
            fail("Exception should've been thrown!");
        }
        catch(IncorrectDataException e){       
        }
    }
}
