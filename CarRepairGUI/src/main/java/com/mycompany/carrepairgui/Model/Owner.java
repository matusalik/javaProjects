package com.mycompany.carrepairgui.Model;
/**
 * Part of the model
 * Hold info about car's owner
 * @author mateu
 */
public class Owner {
    private String name;
    private String surname;
    
    public Owner(String sentName, String sentSurname){
        name = sentName;
        surname = sentSurname;
    }
    
    /**
     * Return owner's name
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
    public void setName(String sentName){
        name = sentName;
    }
    public void setSurname(String sentSurname){
        surname = sentSurname;
    }
}
