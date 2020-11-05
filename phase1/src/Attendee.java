import java.util.ArrayList;

public class Attendee extends Person{
    public Attendee(String username, String password) {
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
