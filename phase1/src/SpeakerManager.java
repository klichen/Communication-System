import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpeakerManager extends PersonManager {
    //  Log in

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
}
