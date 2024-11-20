package com.mycompany.carrepairgui.Model;
import lombok.*;
@AllArgsConstructor
@Getter
/**
 * Part of the model
 * Hold info about car's owner
 * @author mateu
 */
public class Owner {
    private String name;
    private String surname;
    
    public void setName(String sentName) throws IncorrectDataException{
        if(sentName.equals("") || sentName == null){
            throw new IncorrectDataException("Name can't be empty!");
        }
        else{
            this.name = sentName;
        }
    }
    public void setSurname(String sentSurname) throws IncorrectDataException{
        if(sentSurname.equals("") || sentSurname == null){
            throw new IncorrectDataException("Surname can't be empty!");
        }
        else{
            this.surname = sentSurname;
        }
    }
}
