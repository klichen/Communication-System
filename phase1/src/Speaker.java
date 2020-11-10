import java.util.ArrayList;

public class Speaker extends Person{
    public Speaker(String username, String password) {
        super(username, password);
        ArrayList<String> contactList = new ArrayList<String>();
        this.isSpeaker = true;
        this.isAttendee = false;
        this.isOrganizer = false;
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

}
