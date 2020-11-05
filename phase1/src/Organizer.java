import java.util.ArrayList;

public class Organizer extends  Person{
    public Organizer(String username, String password) {
        super(username, password);
    }

    @Override
    ArrayList<Person> getContactList() {
        return null;
    }

    @Override
    void addToContactList(Person contact) {

    }
}
