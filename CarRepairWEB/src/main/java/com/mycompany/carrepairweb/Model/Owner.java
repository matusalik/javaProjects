package com.mycompany.carrepairweb.Model;
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
        if(sentName == null || sentName.equals("") || sentName.equals(" ") || sentName.equals("\n")){
            throw new IncorrectDataException("Name can't be empty!");
        }
        else{
            this.name = sentName;
        }
    }
    public void setSurname(String sentSurname) throws IncorrectDataException{
        if(sentSurname == null || sentSurname.equals("") || sentSurname.equals(" ") || sentSurname.equals("\n")){
            throw new IncorrectDataException("Surname can't be empty!");
        }
        else{
            this.surname = sentSurname;
        }
    }
}
