import java.util.ArrayList;
import java.util.List;

public abstract class Person<Public> {
    private String username;
    private String password;
    protected ArrayList<Person> contactList;
    private ArrayList<String> messageStorage;

    static ArrayList<String> allPeople;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
        this.messageStorage = new ArrayList<>();
        allPeople.add(this.username);
    }

    // returns the Person's username
    public String getUsername(){
        return this.username;
    }

    // returns the list of people the Person can message
    abstract ArrayList<Person> getContactList();

    // adds a person's username to Person's contact list
    abstract void addToContactList(String contact);

    // returns messages that has been sent to Person
    public String getStoredMessages(){
        String delim = " ,";
        return String.join(delim, this.messageStorage);
    }

    // adds a message that was sent to Person to their storage
    public void addToMessageStorage(String messageContent, Person messageSender){
        this.messageStorage.add(("Sender: " + messageSender + " Message Contents: " + messageContent));
    }

    // returns a list with every person
    public static ArrayList<String> getAllPeople() {
        return allPeople;
    }
}

