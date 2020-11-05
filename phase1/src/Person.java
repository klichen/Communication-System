import java.util.ArrayList;

public class Person {
    private String username;
    private String password;
    private ArrayList<Person> contactList;
    private ArrayList<Message> messageStorage;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
        this.contactList = new ArrayList<>();
        this.messageStorage = new ArrayList<>();
    }

    public ArrayList<Person> getContactList(){
        return this.contactList;
    }

    public void addToContactList(Person contact) {
        this.contactList.add(contact);
    }

    public void addToMessageStorage(Message newMessage){
        this.messageStorage.add(newMessage);
    }

}

