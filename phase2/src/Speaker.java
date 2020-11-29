import java.util.ArrayList;
import java.util.List;

public class Speaker extends Person {
    private List<String> contactList;
    private List<String> schedule;

    /**
     * Creates a Speaker object that inherits from Person
     * @param username The Speaker's username as a String
     * @param password The Speaker's password as a String
     */
    public Speaker(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<>();
        this.isSpeaker = true;
        this.isAttendee = false;
        this.isOrganizer = false;
        this.schedule = new ArrayList<>();
    }

    /**
     * returns the usernames of all the people that the Speaker can message
     * @return A List containing each contacts username as a String
     */
    List<String> getContactList() {
        return this.contactList;
    }

    /**
     * returns the ids of all the events that the Speaker is speaking at
     * @return An Arraylist containing the event ids as a String
     */
    public List<String> getSchedule(){
        return this.schedule;
    }

    /**
     * Adds another persons username to Speaker's contactList
     * @param contact The username of the person the Attendee wants to add to their contactList
     */
    public void addToContact(String contact){
        this.contactList.add(contact);
    }
}
