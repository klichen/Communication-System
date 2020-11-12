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

    // adds a person's username to Speaker's contact list
    public void addToContactList(String contact) {
        this.contactList.add(contact);
    }

    // remove a person's username from Speaker's contact list
    public void removeFromContactList(String contact){
        this.contactList.remove(contact);
    }

    public ArrayList<Event> getSchedule(){
        return this.schedule;
    }

}
