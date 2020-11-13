import java.util.ArrayList;

public class OrganizerManager {
    String organizerUsername;

    public OrganizerManager(String organizerUsername){
        this.organizerUsername = organizerUsername;
    }

    // Enter rooms (events) into the system
    public void createEvent(String id, int time, String speakerUsername){
        Event event = new Event(id, time, speakerUsername);
        // Not sure if this is somehow supposed to use EventScheduler (they are both use case classes so I decided
        // not to). It was not really specified if this means to just make an event or actually schedule one.
    }

    // Create speaker accounts
    public void createSpeaker(String username, String password){
        Speaker speaker = new Speaker(username, password);
    }

}
