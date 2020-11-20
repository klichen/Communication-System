import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Attendee extends Person{
    private List<String> contactList;
    private List<String> schedule;


    /**
     * Creates an Attendee object that inherits from Person and initializes the Attendees contactList and schedule as an
     * empty ArrayList, sets variables isSpeaker and isOrganizer to false, while isAttendee is set to true.
     * @param username The Attendee's username as a String
     * @param password The Attendee's password as a String
     */
    public Attendee(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<>();
        this.isSpeaker = false;
        this.isAttendee = true;
        this.isOrganizer = false;
        this.schedule = new ArrayList<>();
    }

    /**
     * returns the usernames of all the people that the Attendee can message
     * @return A List containing each contacts username as a String
     */
    public List<String> getContactList() {
        return this.contactList;
    }

    /**
     * Adds another persons username to Attendee's contactList
     * @param contact The username of the person the Attendee wants to add to their contactList
     */
    public void addToContact(String contact){
        this.contactList.add(contact);
    }

    /**
     * returns the ids of all the events that the Attendee has signed up for
     * @return An Arraylist containing the event ids as a String
     */
    public List<String> getSchedule(){
        return this.schedule;
    }

    /**
     * Adds an event's ID to the Attendees Schedule
     * @param eventID The ID of the event the Attendee is adding to their schedule
     */
    public void addToSchedule(String eventID){
        this.schedule.add(eventID);
    }

    /**
     * Removes an event's ID from the Attendee's Schedule
     * @param eventID The ID of the event the Attendee is removing from their schedule
     */
    public void removeFromSchedule(String eventID){
        this.schedule.remove(eventID);
    }


}
