import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrganizerSystem {
    // Controller class (gets input from user)
    AttendeeManager am;
    EventScheduler es;
    SpeakerManager sm;

    // Enter rooms (events) into the system
    public void createEvent(String eventId, int time, String speakerUsername){
        // Create the event
        es.updateEvents(eventId, time, speakerUsername);
        // Add event to speaker's schedule
        sm.updateSchedule(speakerUsername, eventId);
    }

    // Create speaker accounts
    public void createSpeaker(String speakerUsername, String password){
        sm.createSpeaker(speakerUsername, password);
    }

    // Get all speakers
    public ArrayList<Speaker> getAllSpeakers(){
        return sm.getAllSpeakers();
    }

    // Cancel event
    public void cancelEvent(String eventId){
        // Remove event from EventScheduler
        es.removeEvent(eventId);
        // Remove event from speaker's schedule
        String speakerUsername = es.getIdToEvent().get(eventId).getSpeaker();
        sm.updateSchedule(speakerUsername, eventId);
        // Remove event from all attendees' schedule
        List<String> attendeeList = es.getIdToEvent().get(eventId).getInEvent();
        for (String attendeeUsername: attendeeList){
            am.eventCancel(attendeeUsername, eventId);
        }
    }
}
