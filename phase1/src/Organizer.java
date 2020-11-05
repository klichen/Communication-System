import java.util.ArrayList;

public class Organizer extends  Person{
    public Organizer(String username, String password) {
        super(username, password);
        // DOES NOT UPDATE WHEN NEW PEOPLE ARE MADE
        ArrayList<String> contactList = Person.getAllPeople();
    }

    @Override
    ArrayList<Person> getContactList() {
        return contactList;
    }

    @Override
    void addToContactList(String contact) {
        this.contactList.add(contact);
    }
}
