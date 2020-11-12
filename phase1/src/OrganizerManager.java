import java.util.ArrayList;

public class OrganizerManager {

    private Organizer organizer;

    public OrganizerManager(Organizer organizer){
        this.organizer = organizer;
    }


    // Create speaker accounts
    public void createSpeaker(String username, String password){
        Speaker speaker = new Speaker(username, password);
    }

}
