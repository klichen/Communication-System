import java.util.ArrayList;

public class OrganizerSystem {
    // Controller class (gets input from user)
    String organizerUsername;
    OrganizerManager og;

    public OrganizerSystem(String organizerUsername, OrganizerManager og){
        this.organizerUsername = organizerUsername;
        this.og = new OrganizerManager(organizerUsername);
    }

    // Enter rooms (events) into the system
    public void createEvent(String id, int time, String speakerUsername){
        og.createEvent(id, time, speakerUsername);
    }

    // Create speaker accounts
    public void createSpeaker(String username, String password){
        og.createSpeaker(username, password);
    }
}
