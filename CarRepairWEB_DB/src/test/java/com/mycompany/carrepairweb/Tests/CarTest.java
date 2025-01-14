package com.mycompany.carrepairweb.Tests;
import com.mycompany.carrepairweb.Model.Car;
import com.mycompany.carrepairweb.Model.IncorrectDataException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
public class CarTest {
    /**
     * Test for testing the car setter with proper values
     * @param model
     * @throws IncorrectDataException 
     */
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
    /**
     * Test for testing the car setter with null adn empty values
     * @param model
     * @throws IncorrectDataException 
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", " ", "\n"})
    void carEmptyModelSetterTest(String model) throws IncorrectDataException{
        Car testCar = new Car("t", "t", 0);
        try{
            testCar.setModel(model);
            fail("Exception shoud have been thrown, no data can be empty!");
        }
        catch(IncorrectDataException e){
        }
    }
    /**
     * Test for testing the car setter with proper values
     * @param registration
     * @throws IncorrectDataException 
     */
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
    /**
     * Test for testing the car setter with null adn empty values
     * @param registration
     * @throws IncorrectDataException 
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", " ", "\n"})
    void carEmptyRegistrationSetterTest(String registration) throws IncorrectDataException{
        Car testCar = new Car("t", "t", 0);
        try{
            testCar.setRegistration(registration);
            fail("Exception shoud have been thrown, no data can be empty!");
        }
        catch(IncorrectDataException e){
        }
    }
}