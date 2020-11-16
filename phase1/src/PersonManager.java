import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonManager {
    protected ArrayList<Attendee> allAttendees;
    protected ArrayList<Organizer> allOrganizers;
    protected ArrayList<Speaker> allSpeakers;
    protected ArrayList<Person> allPersons;
    protected Map<String, Attendee> usernameToAttendee;
    protected Map<String, Organizer> usernameToOrganizer;
    protected Map<String, Speaker> usernameToSpeaker;
    protected Map<String, Person> usernameToPerson;

    public PersonManager(){
        allAttendees = new ArrayList<>();
        allOrganizers = new ArrayList<>();
        allSpeakers = new ArrayList<>();
        allPersons = new ArrayList<>();
        usernameToAttendee = new HashMap<>();
        usernameToOrganizer = new HashMap<>();
        usernameToSpeaker = new HashMap<>();
        usernameToPerson = new HashMap<>();
    }

    // Update logins from textfile
    public void updateLogins(String type, String user, String pass) {
        if(!usernameToPerson.containsKey(user)){
            if (type.equalsIgnoreCase("speaker")) {
                createSpeaker(user, pass);
            } else if (type.equalsIgnoreCase("attendee")) {
                createAttendee(user, pass);
            } else if (type.equalsIgnoreCase("organizer")) {
                createOrganizer(user, pass);
            }
        }

    }

    // Get Person object with a username
    public String getPersonType(String username, String password) {
        if (usernameToAttendee.containsKey(username) && usernameToAttendee.get(username).getPassword().equals(password)) {
            return "Attendee";
        } else if (usernameToOrganizer.containsKey(username) && usernameToOrganizer.get(username).getPassword().equals(password)) {
            return "Organizer";
        } else if (usernameToSpeaker.containsKey(username) && usernameToSpeaker.get(username).getPassword().equals(password)) {
            return "Speaker";
        } else {
            //System.out.println("This username does not exist.");
            return null;
        }
    }

    // Create attendee accounts
    public void createAttendee(String username, String password){
        if (!usernameToAttendee.containsKey(username)) {
            Attendee attendee = new Attendee(username, password);
            allAttendees.add(attendee);
            allPersons.add(attendee);
            usernameToAttendee.put(username, attendee);
            usernameToPerson.put(username, attendee);
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
            allPersons.add(organizer);
            usernameToOrganizer.put(username, organizer);
            usernameToPerson.put(username, organizer);
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
            allPersons.add(speaker);
            usernameToSpeaker.put(username, speaker);
            usernameToPerson.put(username, speaker);
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

    public List<List<String>> loginToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        System.out.println(usernameToPerson);
        for (String i : usernameToPerson.keySet()){
            String type = "";
            if(usernameToPerson.get(i).isSpeakerType()){
                type = "speaker";
            }
            else if (usernameToPerson.get(i).isAttendeeType()){
                type = "attendee";
            }
            else if (usernameToPerson.get(i).isOrganizerType()){
                type = "organizer";
            }
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add(type + "," + usernameToPerson.get(i).getUsername()
                    + "," + usernameToPerson.get(i).getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }
}
