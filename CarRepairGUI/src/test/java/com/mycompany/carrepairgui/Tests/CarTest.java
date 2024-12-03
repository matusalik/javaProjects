package com.mycompany.carrepairgui.Tests;
import com.mycompany.carrepairgui.Model.Car;
import com.mycompany.carrepairgui.Model.IncorrectDataException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"Honda", "Toyota", "Mercedes"})
    void carModelSetterTest(String model) throws IncorrectDataException{
        Car testCar = new Car("t", "t", 0);
        try{
            testCar.setModel(model);
            assertTrue(testCar.getModel().equals(model), "Models are equal!");
        }
        catch(IncorrectDataException e){
            fail("Exception shouldn't have been thrown!");
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "", ""})
    void carEmptyModelSetterTest(String model) throws IncorrectDataException{
        Car testCar = new Car("t", "t", 0);
        try{
            testCar.setModel(model);
            fail("Exception shoud have been thrown, no data can be empty!");
        }
        catch(IncorrectDataException e){
        }
    }
    @Test
    void carNullModelSetterTest(){
        Car testCar = new Car("t", "t", 1);
        try{
            testCar.setModel(null);
            fail("Exception should've been thrown, model can't be null!");
        }
        catch(IncorrectDataException e){      
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"SZO 123", "SK 7781", "SRB T67J"})
    void carRegistrationSetterTest(String registration) throws IncorrectDataException{
        Car testCar = new Car("t", "t", 0);
        try{
            testCar.setRegistration(registration);
            assertTrue(testCar.getRegistration().equals(registration), "Models are equal!");
        }
        catch(IncorrectDataException e){
            fail("Exception shouldn't have been thrown!");
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "", ""})
    void carEmptyRegistrationSetterTest(String registration) throws IncorrectDataException{
        Car testCar = new Car("t", "t", 0);
        try{
            testCar.setRegistration(registration);
            fail("Exception shoud have been thrown, no data can be empty!");
        }
        catch(IncorrectDataException e){
        }
    }
    @Test
    void carNullRegistrationSetterTest(){
        Car testCar = new Car("t", "t", 1);
        try{
            testCar.setRegistration(null);
            fail("Exception should've been thrown, model can't be null!");
        }
        catch(IncorrectDataException e){      
        }
    }
}