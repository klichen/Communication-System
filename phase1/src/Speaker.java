import java.util.ArrayList;

public class Speaker extends Person {
    private ArrayList<String> contactList;
    private ArrayList<Event> schedule;

    public Speaker(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<String>();
        this.isSpeaker = true;
        this.isAttendee = false;
        this.isOrganizer = false;
        this.schedule = new ArrayList<Event>();
    }

    // returns the list of people the Person can message
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    // adds a person's username to Person's contact list
    void addToContactList(String contact) {
        this.contactList.add(contact);
    }

    public ArrayList<Event> getSchedule(){
        return this.schedule;
    }

}
