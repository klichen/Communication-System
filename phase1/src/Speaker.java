import java.util.ArrayList;

public class Speaker extends Person {
    private ArrayList<String> contactList;
    private ArrayList<String> schedule;

    public Speaker(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<String>();
        this.isSpeaker = true;
        this.isAttendee = false;
        this.isOrganizer = false;
        this.schedule = new ArrayList<String>();
    }

    // returns the list of people the Person can message
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    public ArrayList<String> getSchedule(){
        return this.schedule;
    }

    public void addToContact(String contact){
        this.contactList.add(contact);
    }

}
