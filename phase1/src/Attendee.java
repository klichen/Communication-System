import java.util.ArrayList;

public class Attendee extends Person {

    public Attendee(String username, String password) {
        super(username, password);
        contactList = new ArrayList<Person>();
    }

    @Override
    ArrayList<Person> getContactList() {
        return this.contactList;
    }

    @Override
    void addToContactList(Person contact) {
        this.contactList.add(contact);
    }
}
