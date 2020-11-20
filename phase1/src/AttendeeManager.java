import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendeeManager{
    private Map<String, Attendee> usernameToAttendee;
    private List<Attendee> allAttendees;

    /**
     * Creates an AttendeeManager object that initializes an empty ArrayList that will store all Attendee objects and
     * it initializes an empty Hashmap that will store Attendee usernames as the value and the corresponding Attendee
     * object as the key.
     */
    public AttendeeManager(){
        allAttendees = new ArrayList<>();
        usernameToAttendee = new HashMap<>();
    }

    /**
     * Creates an Attendee account if the username does not already exist
     * @param username The Attendee's username as a String
     * @param password The Attendee's password as a String
     * @return A boolean returning true if the Attendee account was created and false if it was not created
     */
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

    /**
     * Adds an Attendee to allAttendees and to usernameToAttendee
     * @param a The Attendee object to be added to allAttendees and usernameToAttendee
     */
    public void updateAttendeeObjects(Attendee a){
        allAttendees.add(a);
        usernameToAttendee.put(a.getUsername(), a);
    }

    /**
     * Returns the variable allAttendees
     * @return A List of all the Attendees that exist
     */
    public List<Attendee> getAllAttendees(){
        return allAttendees;
    }

    /**
     * Returns the variable usernameToAttendee
     * @return a Map pointing all the usernames of the Attendees to its corresponding Attendee object
     */
    public Map<String, Attendee> getUsernameToAttendee() {
        return usernameToAttendee;
    }

    /**
     * Checks the username and password of the Attendee who logs in to ensure that it is a real account
     * @param username The Attendee's username as a String
     * @param password The Attendee's password as a String
     * @return a boolean returning true if the login information exists and false if it does not
     */
    public boolean checkLogin(String username, String password){
        boolean valid = false;
        for (Attendee user: allAttendees){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                valid = true;
            }
        }
        return valid;
    }

    /**
     * returns the Attendee's list of contacts
     * @param username The Attendee's username as a String
     * @return A List containing Attendee's contacts usernames as Strings
     */
    public List<String> getContactList(String username){
        Attendee attendee = usernameToAttendee.get(username);
        return attendee.getContactList();
    }

    /**
     * Checks whether a contact can be added to Attendee's contact list by checking if they exist and if they are not
     * already on Attendee's contact list
     * @param username The Attendee's username as a String
     * @param contact The potential contact's username as a String
     * @return a boolean that returns true if contact can be added to Attendee contact list and false if contact cannot
     * be added
     */
    public boolean canAddToContactList(String username, String contact){
        List<String> contactList = usernameToAttendee.get(username).getContactList();
        return !contactList.contains(contact);
    }

    /**
     * Adds a contact to Attendee's contact list if the contact satisfies the conditions to be added
     * @param username The Attendee's username as a String
     * @param contact The contact's username as a String
     */
    public void addToContactList(String username, String contact) {
        Attendee attendee = usernameToAttendee.get(username);
        if (canAddToContactList(username, contact)){
            attendee.addToContact(contact);
        }
    }

    /**
     * Adds an event to the Attendee's schedule
     * @param username The Attendee's username as a String
     * @param eventID The ID of the event the Attendee is signing up for
     */
    public void eventSignUp(String username, String eventID){
        Attendee attendee = usernameToAttendee.get(username);
        attendee.addToSchedule(eventID);
    }

    /**
     * Removes an event from the Attendee's schedule
     * @param username The Attendee's username as a String
     * @param eventID The Id of the event the Attendee is signing up for
     */
    public void eventCancel(String username, String eventID){
        Attendee attendee = usernameToAttendee.get(username);
        attendee.removeFromSchedule(eventID);
    }

    /**
     * Returns the schedule of the Attendee
     * @param username The Attendee's username as a String
     * @return A List containing the ids of all the Events Attendee has signed up for as a String
     */
    public List<String> getSchedule(String username){
        Attendee attendee = usernameToAttendee.get(username);
        return attendee.getSchedule();
    }
}
