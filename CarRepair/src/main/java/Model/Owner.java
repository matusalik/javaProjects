package Model;
public class Owner {
    private String name;
    private String surname;
    
    public Owner(String sentName, String sentSurname){
        name = sentName;
        surname = sentSurname;
    }
    
    //Getter returning owner's name
    public String getName() {
        return name;
    }

    //Getter returning owner's surname
    public String getSurname() {
        return surname;
    }
}
