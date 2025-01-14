package com.mycompany.carrepairweb.Tests;
import com.mycompany.carrepairweb.Model.IncorrectDataException;
import com.mycompany.carrepairweb.Model.Owner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
public class OwnerTest {
    @ParameterizedTest
    @ValueSource(strings = {"Adam", "Jan", "Jerzy"})
    void ownerNameSetterTest(String name) throws IncorrectDataException{
        Owner testOwner = new Owner("t", "t");
        try{
            testOwner.setName(name);
            assertTrue(testOwner.getName().equals(name), "Names are equal!");
        }
        catch(IncorrectDataException e){
            fail("Exception shoudn't have been thrown!");
        }
    }
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", " ", "\n"})
    void ownerEmptyNullNameSetterTest(String name) throws IncorrectDataException{
        Owner testOwner = new Owner("t", "t");
        try{
            testOwner.setName(name);
            fail("Exception shoud have been thrown, no data can be empty!");
        }
        catch(IncorrectDataException e){
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"Kowalski", "Brzoza", "Jeden"})
    void ownerSurnameSetterTest(String surname) throws IncorrectDataException{
        Owner testOwner = new Owner("t", "t");
        try{
            testOwner.setName(surname);
            assertTrue(testOwner.getName().equals(surname), "Names are equal!");
        }
        catch(IncorrectDataException e){
            fail("Exception shoudn't have been thrown!");
        }
    }  
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", " ", "\n"})
    void ownerEmptyNullSurnameSetterTest(String surname) throws IncorrectDataException{
        Owner testOwner = new Owner("t", "t");
        try{
            testOwner.setSurname(surname);
            fail("Exception shoud have been thrown, no data can be empty!");
        }
        catch(IncorrectDataException e){
        }
    }
}
