import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpeakerManager {
    private List<Speaker> allSpeakers;
    private Map<String, Speaker> usernameToSpeaker;

    /**
     * Creates an OrganizerManager object and initializes allSpeakers as an empty ArrayList and
     * usernameToSpeaker as an empty HashMap.
     */
    public SpeakerManager(){
        allSpeakers = new ArrayList<>();
        usernameToSpeaker = new HashMap<>();
    }

    /**
     * Creates a Speaker object, if the username does not already exist.
     * @param username String representing Speaker's username
     * @param password String representing Speaker's password
     * @return boolean; true if Speaker object was created, false if it was not created
     */
    public boolean createSpeaker(String username, String password){
        if (!usernameToSpeaker.containsKey(username)) {
            Speaker speaker = new Speaker(username, password);
            allSpeakers.add(speaker);
            usernameToSpeaker.put(username, speaker);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds Speaker object to List allSpeakers, and Map usernameToSpeaker.
     * @param s Speaker object
     */
    public void updateSpeakerObjects(Speaker s){
        allSpeakers.add(s);
        usernameToSpeaker.put(s.getUsername(), s);
    }

    /**
     * Get the List allSpeakers.
     * @return List allSpeakers
     */
    public List<Speaker> getAllSpeakers(){
        return allSpeakers;
    }

    /**
     * Get the Map usernameToSpeaker.
     * @return Map usernameToSpeaker.
     */
    public Map<String, Speaker> getUsernameToSpeaker() {
        return usernameToSpeaker;
    }

    /**
     * Checks if the username exists and if it's password is correct.
     * @param username String representing Speaker's username
     * @param password String representing Speaker's password
     * @return boolean; true if username exists and it's password is correct, false if otherwise.
     */
    public boolean checkLogin(String username, String password){
        boolean valid = false;
        for (Speaker user: allSpeakers){
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    /**
     * Get the schedule of Speaker with speakerUsername.
     * @param speakerUsername String representing Speaker's username
     * @return List representing the Speaker's schedule.
     */
    public List<String> getSchedule(String speakerUsername){
        return usernameToSpeaker.get(speakerUsername).getSchedule();
    }

    /**
     * Precondition: The Speaker with speakerUsername and the Event with evendId exist
     *
     * Add an Event with eventId to the schedule of Speaker with speakerUsername.
     * @param speakerUsername String representing Speaker's username
     * @param eventId String representing the id of the event
     */
    public void updateSchedule(String speakerUsername, String eventId){
        getSchedule(speakerUsername).add(eventId);
    }

    /**
     * Remove Event with eventId from the schedule of Speaker with speakerUsername.
     * @param speakerUsername String representing Speaker's username
     * @param eventId String representing the id of the event
     */
    public void removeFromSchedule(String speakerUsername, String eventId){
        getSchedule(speakerUsername).remove(eventId);
    }

    /**
     * Add Person with contact username to the contact list of Speaker with speakerUsername.
     * @param speakerUsername String representing Speaker's username
     * @param contact String representing the contact's username
     */
    public void addToContactList(String speakerUsername, String contact) {
        usernameToSpeaker.get(speakerUsername).getContactList().add(contact);
    }

    /**
     * Remove Person with contact username from the contact list of Speaker with speakerUsername.
     * @param speakerUsername String representing Speaker's username
     * @param contact String representing the contact's username
     */
    public void removeFromContactList(String speakerUsername, String contact){
        usernameToSpeaker.get(speakerUsername).getContactList().remove(contact);
    }

    /**
     * Check if Person with personUsername is in the contact list of Speaker with speakerUsername.
     * @param speakerUsername String representing Speaker's username
     * @param personUsername String representing Person's username
     * @return boolean; true if Person with personUsername is a contact, false if they are not.
     */
    public boolean isContact(String speakerUsername, String personUsername){
        return usernameToSpeaker.get(speakerUsername).getContactList().contains(personUsername);
    }
}
