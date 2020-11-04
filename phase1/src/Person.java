import java.util.ArrayList;

public class Person {
    private String username;
    private String password;
    private ArrayList<Person> contactList;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
        this.contactList = new ArrayList<>();
    }

    public Person getTypePerson(){
        return this;
    }

    public ArrayList<Person> getContactList(){
        return this.contactList;
    }

    public void setContactList(ArrayList<Person> contactList) {
        this.contactList = contactList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

