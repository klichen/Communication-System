import java.util.ArrayList;

public class OrganizerManager {

    private Organizer organizer;

    public OrganizerManager(Organizer organizer){
        this.organizer = organizer;
    }

    // Enter rooms (events) into the system
    public void createEvent(String id, int time, Speaker speaker){
        Event event = new Event(id, time, speaker);
        // Not sure if this is somehow supposed to use EventScheduler (they are both use case classes so I decided
        // not to). It was not really specified if this means to just make an event or actually schedule one.
    }

    // Create speaker accounts
    public void createSpeaker(String username, String password){
        Speaker speaker = new Speaker(username, password);
    }

}
