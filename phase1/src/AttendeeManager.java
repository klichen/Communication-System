import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendeeManager{
    private Map<String, Attendee> usernameToAttendee;
    private ArrayList<Attendee> allAttendees;

    public AttendeeManager(){
        allAttendees = new ArrayList<>();
        usernameToAttendee = new HashMap<>();
    }

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

    // Check login for logging in
    public boolean checkLogin(String username, String password){
        for (Attendee user: allAttendees){
            return user.getUsername().equals(username) && user.getPassword().equals(password);
        }
        return false;
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

    // Convert all list of attendee to list of string
    public List<List<String>> loginToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        System.out.println(usernameToAttendee);
        for (String i : usernameToAttendee.keySet()){
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add("attendee" + "," + usernameToAttendee.get(i).getUsername()
                    + "," + usernameToAttendee.get(i).getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }

}
