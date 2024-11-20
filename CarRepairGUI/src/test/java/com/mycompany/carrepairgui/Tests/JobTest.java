package com.mycompany.carrepairgui.Tests;
import com.mycompany.carrepairgui.Model.IncorrectDataException;
import com.mycompany.carrepairgui.Model.Job;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class JobTest {
    @Test
    public void jobConstructorTest(){
        try{
            Job testJob = new Job("a", "b", "c", "d", 1);
            assertEquals(testJob.getCar().getMileage(), 1, 0.01, "Milage is correct!");
        }
        catch(IncorrectDataException e){
            fail("Mileage is different than in constructor!");
        }
        try{
            Job testJob = new Job("a", "b", "c", "d", -10);
            fail("Exception should've been thrown, mileage less than 0!");
        }
        catch(IncorrectDataException e){           
        }
        try{
            Job testJob = new Job("", "", "", "", 1);
            fail("Exception should've been thrown, no data can be empty!");
        }
        catch(IncorrectDataException e){            
        }
        try{
            Job testJob = new Job(null, null, null, null, 1);
            fail("Exception should've been thrown, no data can be null!");
        }
        catch(IncorrectDataException e){           
        }
    }
}
