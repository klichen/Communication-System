import java.util.ArrayList;
import java.util.List;

public class Person {
    private String username;
    private String password;
    private ArrayList<Person> contactList;
    private ArrayList<String> messageStorage;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
        this.contactList = new ArrayList<>();
        this.messageStorage = new ArrayList<>();
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<Person> getContactList(){
        return this.contactList;
    }

    public void addToContactList(Person contact) {
        this.contactList.add(contact);
    }

    public String getStoredMessages(){
        String delim = " ,";
        return String.join(delim, this.messageStorage);
    }

    public void addToMessageStorage(Message newMessage){
        String messageContent = newMessage.getMessage();
        Person messageSender = newMessage.getSender();
        this.messageStorage.add(("Sender: " + messageSender + " Message Contents: " + messageContent));
    }


}

