import java.util.ArrayList;

public class AttendeeSystem {
    // Controller class (gets input from user)

    AttendeeManager am;

    public AttendeeSystem(AttendeeManager am){
        this.am = am;
    }

    // can attendee create an account
    public boolean canCreateAccount(String username){
        return this.am.canCreateAccount(username);
    }

    // create attendee account
    public void createAccount(String username, String password){
        this.am.createAccount(username, password);
    }

    // can attendee add a contact
    public boolean canAddContact(String username, String contact){
        return this.am.canAddToContactList(username, contact);
    }

    // add a contact
    public void addContact(String username, String contact){
        this.am.addToContactList(username, contact);
    }

    // get attendee Schedule
    // will change once eventScheduler map is created
    public ArrayList<String> getSchedule(String username){
        return this.am.getSchedule(username);
    }

}
