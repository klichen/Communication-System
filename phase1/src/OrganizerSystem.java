import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrganizerSystem {
    // Controller class (gets input from user)
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;

    /**
     * Creates an ControllerLayer.OrganizerSystem object and sets its variables am, es, om, and sm to the ones passed in the
     * constructor.
     * @param am UseCases.AttendeeManager object
     * @param es EvenScheduler object
     * @param om UseCases.OrganizerManager object
     * @param sm UseCases.SpeakerManager object
     */
    public OrganizerSystem(AttendeeManager am, EventScheduler es, OrganizerManager om, SpeakerManager sm){
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
    }

    /**
     * Create an Entities.Event object and add it to the schedule of Entities.Speaker with speakerUsername, if the event is valid.
     * @param roomNum String representing the room number of where the event is
     * @param eventId String representing the id of the event
     * @param time int representing the time the event starts
     * @param speakerUsername String representing the username of the speaker
     * @return boolean; true if the Entities.Event was created, false if it was not created.
     */
    public boolean createEvent(String roomNum, String eventId, int time, String speakerUsername){
        boolean eventCreated;
        // Check if Entities.Speaker exists
        if (!sm.getUsernameToSpeaker().containsKey(speakerUsername)) {
            return false;
        } else {
            // The speaker exists
            // Create the event
            eventCreated = es.updateEvents(roomNum, eventId, time, speakerUsername);
            if (eventCreated){
                // Add event to speaker's schedule
                sm.updateSchedule(speakerUsername, eventId);
            }
            return eventCreated;
        }
    }

    /**
     * Create a Entities.Speaker object.
     * @param speakerUsername String representing the Entities.Speaker's username
     * @param password String representing the Entities.Speaker's password
     * @return boolean; true if the Entities.Speaker was created, false if it was not created.
     */
    public boolean createSpeaker(String speakerUsername, String password){
        return sm.createSpeaker(speakerUsername, password);
    }

    /**
     * Create an Entities.Organizer object.
     * @param organizerUsername String representing Entities.Organizer's username
     * @param password String representing Entities.Organizer's password
     * @return boolean; true if Entities.Organizer object was created, false if it was not created
     */
    public boolean createOrganizer(String organizerUsername, String password){
        return om.createOrganizer(organizerUsername, password);
    }

    /**
     * Removes the Entities.Event with eventId from UseCases.EventScheduler, Entities.Speaker's schedule, and all of its Attendees' schedule.
     * @param eventId String representing the id of the event
     * @return boolean; true if event was cancelled, false if it was not cancelled.
     */
    public boolean cancelEvent(String eventId){
        // Remove event from UseCases.EventScheduler
        try {
            String speakerUsername = es.getIdToEvent().get(eventId).getSpeaker();
            List<String> attendeeList = es.getIdToEvent().get(eventId).getInEvent();
            boolean eventCancelled = es.removeEvent(eventId);
            if (eventCancelled) {
                // Remove event from speaker's schedule
                sm.removeFromSchedule(speakerUsername, eventId);
                // Remove event from all attendees' schedule
                for (String attendeeUsername : attendeeList) {
                    am.eventCancel(attendeeUsername, eventId);
                }
            }
            return eventCancelled;
        }
        catch(NullPointerException e){
            return false;
        }
    }

    /**
     * Reads user input and returns it as a String
     * @return String representing user input
     */
    public String readString() {
        Scanner scan = new Scanner(System.in);

        return scan.nextLine();
    }

    /**
     * Reads user input and returns it as an int
     * @return int representing user input
     */
    public int readInt() {
        Scanner scan = new Scanner(System.in);
        String strInput = scan.nextLine();

        return Integer.parseInt(strInput);
    }
}

