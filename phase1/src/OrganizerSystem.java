import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrganizerSystem {
    // Controller class (gets input from user)
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;

    // Checks if

    // Enter rooms (events) into the system
    public boolean createEvent(String roomNum, String eventId, int time, String speakerUsername){
        boolean eventCreated;
        // Create the event
        eventCreated = es.updateEvents(roomNum, eventId, time, speakerUsername);
        if (eventCreated){
            // Add event to speaker's schedule
            sm.updateSchedule(speakerUsername, eventId);
        }
        return eventCreated;
    }

    // Create speaker accounts
    public boolean createSpeaker(String speakerUsername, String password){
        return sm.createSpeaker(speakerUsername, password);
    }

    // Create organizer accounts
    public boolean createOrganizer(String organizerUsername, String password){
        return om.createOrganizer(organizerUsername, password);
    }

    // Cancel event
    public boolean cancelEvent(String eventId){
        // Remove event from EventScheduler
        boolean eventCancelled = es.removeEvent(eventId);
        if (eventCancelled){
            // Remove event from speaker's schedule
            String speakerUsername = es.getIdToEvent().get(eventId).getSpeaker();
            sm.updateSchedule(speakerUsername, eventId);
            // Remove event from all attendees' schedule
            List<String> attendeeList = es.getIdToEvent().get(eventId).getInEvent();
            for (String attendeeUsername: attendeeList){
                am.eventCancel(attendeeUsername, eventId);
            }
        }
        return eventCancelled;
    }
}
