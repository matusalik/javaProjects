package Model;
public class Owner {
    String name;
    String surname;
    
    public Owner(String sentName, String sentSurname){
        name = sentName;
        surname = sentSurname;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
