import java.util.ArrayList;

public class Speaker extends Person{

    public Speaker(String username, String password) {
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
