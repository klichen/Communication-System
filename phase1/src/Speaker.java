import java.util.ArrayList;
import java.util.List;

public class Speaker extends Person {
    private List<String> contactList;
    private List<String> schedule;

    public Speaker(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<String>();
        this.isSpeaker = true;
        this.isAttendee = false;
        this.isOrganizer = false;
        this.schedule = new ArrayList<String>();
    }

    // returns the list of people the Person can message
    List<String> getContactList() {
        return this.contactList;
    }

    public List<String> getSchedule(){
        return this.schedule;
    }

    public void addToContact(String contact){
        this.contactList.add(contact);
    }
}
