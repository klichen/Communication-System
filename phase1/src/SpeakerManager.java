import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpeakerManager {
    private ArrayList<Speaker> allSpeakers;
    private Map<String, Speaker> usernameToSpeaker;

    public SpeakerManager(){
        allSpeakers = new ArrayList<>();
        usernameToSpeaker = new HashMap<>();
    }

    // Create speaker accounts
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

    // Get all speakers
    public ArrayList<Speaker> getAllSpeakers(){
        return allSpeakers;
    }

    // Get Map (String -> Speaker)
    public Map<String, Speaker> getUsernameToSpeaker() {
        return usernameToSpeaker;
    }

    // Check login for logging in
    public boolean checkLogin(String username, String password){
        for (Speaker user: allSpeakers){
            return user.getUsername().equals(username) && user.getPassword().equals(password);
        }
        return false;
    }

    // Get schedule
    public ArrayList<String> getSchedule(String speakerUsername){
        return usernameToSpeaker.get(speakerUsername).getSchedule();
    }

    // Add event's id to speaker's schedule
    public void updateSchedule(String speakerUsername, String eventId){
        getSchedule(speakerUsername).add(eventId);
    }

    // adds a person's username to Speaker's contact list
    public void addToContactList(String speakerUsername, String contact) {
        usernameToSpeaker.get(speakerUsername).getContactList().add(contact);
    }

    // remove a person's username from Speaker's contact list
    public void removeFromContactList(String speakerUsername, String contact){
        usernameToSpeaker.get(speakerUsername).getContactList().remove(contact);
    }

    // See if a person is in contacts
    public boolean isContact(String speakerUsername, String personUsername){
        return usernameToSpeaker.get(speakerUsername).getContactList().contains(personUsername);
    }

    // Convert all list of speakers to list of string
    public List<List<String>> loginToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        System.out.println(usernameToSpeaker);
        for (String i : usernameToSpeaker.keySet()){
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add("speaker" + "," + usernameToSpeaker.get(i).getUsername()
                    + "," + usernameToSpeaker.get(i).getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }
}
