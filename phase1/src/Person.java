import java.util.ArrayList;
import java.util.List;

public class Person {
    private String username;
    private String password;
    //private ArrayList<Person> contactList;
    private ArrayList<String> messageStorage;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
        //this.contactList = new ArrayList<>();
        this.messageStorage = new ArrayList<>();
    }

    // returns the Person's username
    public String getUsername(){
        return this.username;
    }

    // returns the list of people the Person can message
    //public ArrayList<Person> getContactList(){
        //return this.contactList;
    //}

    // adds a person to Person's contact list
    //public void addToContactList(Person contact) {
        //this.contactList.add(contact);
    //}

    // returns messages that has been sent to Person
    public String getStoredMessages(){
        String delim = " ,";
        return String.join(delim, this.messageStorage);
    }

    // adds a message that was sent to Person to their storage
    public void addToMessageStorage(Message newMessage){
        String messageContent = newMessage.getMessage();
        Person messageSender = newMessage.getSender();
        this.messageStorage.add(("Sender: " + messageSender + " Message Contents: " + messageContent));
    }


}

