import java.util.ArrayList;
import java.util.Map;

public class AttendeeManager{
    private Map<String, Attendee> usernameToAttendee;
    private ArrayList<Attendee> allAttendees;

    // Create attendee accounts
    public boolean createAttendee(String username, String password){
        if (!usernameToAttendee.containsKey(username)) {
            Attendee attendee = new Attendee(username, password);
            allAttendees.add(attendee);
            usernameToAttendee.put(username, attendee);
            return true;
        } else {
            return false;
        }
    }

    // Get all attendees
    public ArrayList<Attendee> getAllAttendees(){
        return allAttendees;
    }

    // Get Map (String -> Attendee)
    public Map<String, Attendee> getUsernameToAttendee() {
        return usernameToAttendee;
    }


    // returns whether a contact can be added (if contact is already in list)
    // same as checking if they are in your contacts
    public boolean canAddToContactList(String username, String contact){
        ArrayList<String> contactList = usernameToAttendee.get(username).getContactList();
        return !contactList.contains(contact);
    }

    // adds a person's username to Person's contact list
    public void addToContactList(String username, String contact) {
        Attendee attendee = usernameToAttendee.get(username);
        if (canAddToContactList(username, contact)){
            attendee.addToContact(contact);
        }
    }

    // Signup for events
    public void eventSignUp(String username, String eventID){
        Attendee attendee = usernameToAttendee.get(username);
        attendee.schedule.add(eventID);
    }

    // Cancel their enrolment in an event
    public void eventCancel(String username, String eventID){
        Attendee attendee = usernameToAttendee.get(username);
        attendee.schedule.remove(eventID);
    }

    // See schedule of the events for which they signed up
    public ArrayList<String> getSchedule(String username){
        Attendee attendee = usernameToAttendee.get(username);
        return attendee.getSchedule();
    }

}
