package com.mycompany.carrepairgui.Tests;
import com.mycompany.carrepairgui.Model.IncorrectDataException;
import com.mycompany.carrepairgui.Model.Job;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;
public class JobTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    public void jobStringConstructorTest(String string){
        try{
            Job testJob = new Job(string, string, string, string, 1);
        }
        catch(IncorrectDataException e){
            fail("Exception shouldn't have been thrown!");
        }
    }
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", " ", "\n"})
    public void jobStringEmptyNullConstructorTest(String string){
        try{
            Job testJob = new Job(string, string, string, string, 1);
            fail("Exception should have been thrown!");
        }
        catch(IncorrectDataException e){
        }
    }
    @ParameterizedTest
    @ValueSource(doubles = {1.0, 10.0, 100.0})
    public void jobMileageConstructorTest(double testMileage){
        try{
            Job testJob = new Job("a", "b", "c", "d", testMileage);
        }
        catch(IncorrectDataException e){
            fail("Exception shouldn't have been thrown!");
        }
    }
    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -10.0, -100.0})
    public void jobNegativeMileageConstructorTest(double testMileage){
        try{
            Job testJob = new Job("a", "b", "c", "d", testMileage);
            fail("Exception should have been thrown!");
        }
        catch(IncorrectDataException e){     
        }
    }
}
