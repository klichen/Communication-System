public class OrganizerManager {

    private Organizer organizer;

    public OrganizerManager(Organizer organizer){
        this.organizer = organizer;
    }

    // Log in

    // Enter rooms into the system (events)
    public void addRoomToSystem(){

    }

    // Create speaker accounts
    public void createSpeaker(String username, String password){
        Speaker speaker = new Speaker(username, password);
    }

    // Schedule the speakers
    // need to know how event is set up
    public void scheduleSpeakers(){

    }

    // Returns list of events
}
