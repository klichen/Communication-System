import java.util.ArrayList;

public class Speaker extends Person{
    public Speaker(String username, String password) {
        super(username, password);
        ArrayList<String> contactList = new ArrayList<String>();
    }

    @Override
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    @Override
    void addToContactList(String contact) {
        this.contactList.add(contact);
    }
}
