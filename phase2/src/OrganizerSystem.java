import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrganizerSystem {
    // Controller class (gets input from user)
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;
    VipManager vm;

    /**
     * Creates an OrganizerSystem object and sets its variables am, es, om, and sm to the ones passed in the
     * constructor.
     * @param am AttendeeManager object
     * @param es EvenScheduler object
     * @param om OrganizerManager object
     * @param sm SpeakerManager object
     */
    public OrganizerSystem(AttendeeManager am, EventScheduler es, OrganizerManager om, SpeakerManager sm, VipManager vm){
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
    }

    /**
     * Create an Event object and add it to the schedule of Speaker with speakerUsername, if the event is valid.
     * @param roomNum String representing the room number of where the event is
     * @param eventId String representing the id of the event
     * @param time int representing the time the event starts
     * @param speakers List of Strings representing the username of the speakers
     * @param isVip boolean; true if the Event is VIP only, false otherwise
     * @return boolean; true if the Event was created, false if it was not created.
     */
    public boolean createEvent(String roomNum, String eventId, int time, List<String> speakers, boolean isVip,
                               int duration, int maxPeople){
        boolean eventCreated;
        // Check if Speakers exists
        if(speakers.size() >=1){
            for (String speakerID: speakers) {
                if (!sm.getUsernameToSpeaker().containsKey(speakerID)) {
                    return false;
                }
            }
        }
        //create event
        eventCreated = es.updateEvents(roomNum, eventId, time, speakers, isVip, duration, maxPeople);
        if (eventCreated){
            // Add event to speaker's schedule
            for(String speakerID: speakers){
                sm.updateSchedule(speakerID, eventId);
            }
        }
        return eventCreated;
        }

    /**
     * Create a Speaker object.
     * @param speakerUsername String representing the Speaker's username
     * @param password String representing the Speaker's password
     * @return boolean; true if the Speaker was created, false if it was not created.
     */
    public boolean createSpeaker(String speakerUsername, String password){
        return sm.createSpeaker(speakerUsername, password);
    }

    /**
     * Create a Attendee object.
     * @param attendeeUsername String representing the Attendee's username
     * @param password String representing the Attendee's password
     * @return boolean; true if the Attendee was created, false if it was not created.
     */
    public boolean createAttendee(String attendeeUsername, String password){
        return am.createAttendee(attendeeUsername, password);
    }

    /**
     * Create a VIP object.
     * @param vipUsername String representing the VIP's username
     * @param password String representing the VIP's password
     * @return boolean; true if the VIP was created, false if it was not created.
     */
    public boolean createVip(String vipUsername, String password){
        return vm.createVip(vipUsername, password);
    }

    /**
     * Create an Organizer object.
     * @param organizerUsername String representing Organizer's username
     * @param password String representing Organizer's password
     * @return boolean; true if Organizer object was created, false if it was not created
     */
    public boolean createOrganizer(String organizerUsername, String password){
        return om.createOrganizer(organizerUsername, password);
    }

    /**
     * Removes the Event with eventId from EventScheduler, Speaker's schedule, and all of its Attendees' schedule.
     * @param eventId String representing the id of the event
     * @return boolean; true if event was cancelled, false if it was not cancelled.
     */
    public boolean cancelEvent(String eventId){
        // Remove event from EventScheduler
        try {
            List<String> speakerIDs = es.getIdToEvent().get(eventId).getSpeaker();
            List<String> attendeeList = es.getIdToEvent().get(eventId).getInEvent();
            boolean eventCancelled = es.removeEvent(eventId);
            if (eventCancelled) {
                // Remove event from speaker's schedule
                for(String speakerID: speakerIDs) {
                    sm.removeFromSchedule(speakerID, eventId);
                }
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

    /**
     * Precondition: The user input is either 'true' or 'false'
     *
     * Reads user input and returns it as a boolean
     * @return boolean representing user input
     */
    public boolean readBoolean() {
        Scanner scan = new Scanner(System.in);
        String strInput = scan.nextLine();

        // if input isn't 'true', Boolean.parseBoolean will return false
        return Boolean.parseBoolean(strInput);
    }

}

