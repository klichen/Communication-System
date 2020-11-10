import java.util.ArrayList;

public class Speaker extends Person {

    private ArrayList<Event> schedule;

    public Speaker(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<String>();
        this.isSpeaker = true;
        this.isAttendee = false;
        this.isOrganizer = false;
        this.schedule = new ArrayList<Event>();
    }

    @Override
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    @Override
    void addToContactList(String contact) {
        this.contactList.add(contact);
    }

    @Override
    boolean isSpeakerType() {
        return this.isSpeaker;
    }

    @Override
    boolean isAttendeeType() {
        return this.isAttendee;
    }

    @Override
    boolean isOrganizerType() {
        return this.isOrganizer;
    }

    public ArrayList<Event> getSchedule(){
        return this.schedule;
    }

}
