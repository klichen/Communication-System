import java.util.ArrayList;
import java.util.Map;

public class OrganizerSystem {
    // Controller class (gets input from user)
    SpeakerManager sm;
    EventScheduler es;

    // Enter rooms (events) into the system
    public void createEvent(String id, int time, String speakerUsername){
        es.updateEvents(id, time, speakerUsername);
    }

    // Create speaker accounts
    public void createSpeaker(String username, String password){
        sm.createSpeaker(username, password);
    }

    // Get all speakers
    public ArrayList<Speaker> getAllSpeakers(){
        return sm.getAllSpeakers();
    }

}
