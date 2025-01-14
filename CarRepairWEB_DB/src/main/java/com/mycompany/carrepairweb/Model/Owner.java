package com.mycompany.carrepairweb.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name = "owners")
@Getter
@NoArgsConstructor
/**
 * Part of the model
 * Hold info about car's owner
 * @author mateu
 */
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
        
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    public Owner(String name, String surname){
        name = name;
        surname = surname;
    }
    
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
