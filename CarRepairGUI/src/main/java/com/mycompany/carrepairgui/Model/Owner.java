package com.mycompany.carrepairgui.Model;
/**
 * Part of the model
 * Hold info about car's owner
 * @author mateu
 */
public class Owner {
    private String name;
    private String surname;
    
    /**
     * Basic constructor that gets owner data and saves it
     * @param sentName
     * @param sentSurname 
     */
    public Owner(String sentName, String sentSurname){
        name = sentName;
        surname = sentSurname;
    }
    
    /**
     * Returns owner's name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Returns owner's surname
     * @return 
     */
    public String getSurname() {
        return surname;
    }
    
    /**
     * Basic setter, sets Owner's Name
     * @param sentName 
     */
    public void setName(String sentName){
        name = sentName;
    }
    
    /**
     * Basic setter, sets Owner's Surname
     * @param sentSurname 
     */
    public void setSurname(String sentSurname){
        surname = sentSurname;
    }
}
