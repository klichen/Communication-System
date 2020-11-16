import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Map;

public class PersonManager {
    protected ArrayList<Attendee> allAttendees;
    protected ArrayList<Organizer> allOrganizers;
    protected ArrayList<Speaker> allSpeakers;
    protected Map<String, Attendee> usernameToAttendee;
    protected Map<String, Organizer> usernameToOrganizer;
    protected Map<String, Speaker> usernameToSpeaker;

    // Get Person object with a username
    public Person getPersonObject(String username) {
        if (usernameToAttendee.containsKey(username)) {
            return usernameToAttendee.get(username);
        } else if (usernameToOrganizer.containsKey(username)) {
            return usernameToOrganizer.get(username);
        } else if (usernameToSpeaker.containsKey(username)) {
            return usernameToSpeaker.get(username);
        } else {
            System.out.println("This username does not exist.");
            return null;
        }
    }

    // Create attendee accounts
    public void createAttendee(String username, String password){
        if (!usernameToAttendee.containsKey(username)) {
            Attendee attendee = new Attendee(username, password);
            allAttendees.add(attendee);
            usernameToAttendee.put(username, attendee);
        } else {
            System.out.println("This username already exists.");
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

    // Create organizer accounts
    public void createOrganizer(String username, String password){
        if (!usernameToOrganizer.containsKey(username)) {
            Organizer organizer = new Organizer(username, password);
            allOrganizers.add(organizer);
            usernameToOrganizer.put(username, organizer);
        } else {
            System.out.println("This username already exists.");
        }
    }

    // Get all organizers
    public ArrayList<Organizer> getAllOrganizers(){
        return allOrganizers;
    }

    // Get Map (String -> Organizer)
    public Map<String, Organizer> getUsernameToOrganizer() {
        return usernameToOrganizer;
    }

    // Create speaker accounts
    public void createSpeaker(String username, String password){
        if (!usernameToSpeaker.containsKey(username)) {
            Speaker speaker = new Speaker(username, password);
            allSpeakers.add(speaker);
            usernameToSpeaker.put(username, speaker);
        } else {
            System.out.println("This username already exists.");
        }
    }

    // Get all speakers
    public ArrayList<Speaker> getAllSpeakers(){
        return allSpeakers;
    }

    // Get Map (String -> Speaker)
    public Map<String, Speaker> getUsernameToSpeaker() {
        return usernameToSpeaker;
    }
}
