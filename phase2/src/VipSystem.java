import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VipSystem {
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;
    VipManager vm;

    /**
     * Constructor for controller that creates VipSystem object
     * @param am Instance of AttendeeManager with loaded information
     * @param es Instance of EventScheduler with loaded information
     * @param om Instance of OrganizerManager with loaded information
     * @param sm Instance of SpeakerManager with loaded information
     */
    public VipSystem(AttendeeManager am, EventScheduler es, OrganizerManager om, SpeakerManager sm, VipManager vm){
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
    }

    /**
     * Reads String input from User
     * @return The String that the User inputted
     */
    public String readString(){
        String str;
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();

        return str;
    }

    /**
     * Checks whether contact can be added to Vips contact list
     * @param username The Vip's username as a String
     * @param contact The potential contact's username as a String
     * @return a boolean that returns true if contact can be added to Vips contact list and false if contact cannot
     * be added
     */
    public boolean canAddContact(String username, String contact){
        boolean userCheck = false;
        if (am.getUsernameToAttendee().containsKey(username)){
            userCheck = true;
        } else if (om.getUsernameToOrganizer().containsKey(username)){
            userCheck = true;
        } else if (sm.getUsernameToSpeaker().containsKey(username)){
            userCheck = true;
        } else if (vm.getUsernameToVip().containsKey(username)){
            userCheck = true;
        }

        return userCheck && this.vm.canAddToContactList(username, contact);
    }

    /**
     * Adds a contact to VIP's contact list
     * @param username The VIP's username as a String
     * @param contact The contact's username as a String
     */
    public void addContact(String username, String contact){
        this.vm.addToContactList(username, contact);
    }

    /**
     * Returns the variable IdToEvent in EventScheduler
     * @return A Map pointing Event IDS to their corresponding Event objects
     */
    private Map<String, Event> getEventMap(){
        return this.es.getIdToEvent();
    }

    /**
     * Returns VIP's schedule using the Event objects
     * @param username The VIP's username as a String
     * @return A List of all the Events the VIP has signed up for
     */
    public List<Event> getSchedule(String username){
        List<String> idSchedule =  this.vm.getSchedule(username);
        Map<String, Event> eventMap = getEventMap();
        List<Event> fullSchedule = new ArrayList<>();

        for (String i: idSchedule){
            if (eventMap.containsKey(i)){
                fullSchedule.add(eventMap.get(i));
            }
        }
        return fullSchedule;
    }

    /**
     * returns VIP's Schedule with all the information about each Event
     * @param username The VIP's username as a String
     * @return A List of Event information as Strings
     */
    public List<String> getScheduleIds(String username){
        List<Event> fullSchedule =  getSchedule(username);
        List<String> ScheduleString = new ArrayList<>();

        for (Event i: fullSchedule){
            ScheduleString.add("[Event: " + i.getID() + ", Room Number: " + i.getRoomNum() + ", Time: " + i.getTime()
                    + ", Speaker: " + i.getSpeaker() + " , VIP Event: "  + i.getIsVip() + "]");
        }
        return ScheduleString;
    }

    /**
     * Checks whether eventID exists
     * @param eventID The ID of the Event as a String
     * @return a boolean that returns true if the EventID exists and false otherwise
     */
    private boolean validEvent(String eventID) {
        return getEventMap().containsKey(eventID);
    }

    /**
     * Checks whether an Event can be added to VIP's schedule
     * @param username The VIP's username as a String
     * @param eventID The ID of the Event as a String
     * @return a boolean that returns true if Event can be added and false otherwise
     */
    public boolean canAddEvent(String username, String eventID){
        List<String> idSchedule =  this.vm.getSchedule(username);
        List<Event> fullSchedule = getSchedule(username);
        boolean canAdd = true;
        int eventTime;
        if (validEvent(eventID)) {
            eventTime = getEventMap().get(eventID).getTime();
        }
        else{
            return false;
        }

        for (Event i: fullSchedule){
            if(i.getTime() != eventTime && !idSchedule.contains(eventID)){
                canAdd = true;
            }
            else{
                canAdd = false;
                break;
            }
        }
        return canAdd;
    }

    /**
     * Adds an event to the VIP's schedule
     * @param username The VIP's username as a String
     * @param eventID The ID of the Event as a String
     */
    public void addEvent(String username, String eventID){
        boolean canAdd = canAddEvent(username, eventID);
        Event event = getEventMap().get(eventID);
        List<String> speakersID = new ArrayList<>(event.getSpeaker());
        List<Speaker> speakers = new ArrayList<>();
        for(String id: speakersID){
            Speaker eventSpeaker = sm.getUsernameToSpeaker().get(id);
            speakers.add(eventSpeaker);
        }
        if(canAdd){
            this.vm.eventSignUp(username,eventID);
            for (String id: speakersID){
                this.addContact(username, id);
            }
            event.updateInEvent(username);
            for(Speaker speaker: speakers){
                speaker.addToContact(username);
            }
        }
    }

    /**
     * Checks whether an Event can be removed from the VIP's Schedule
     * @param username The VIP's username as a String
     * @param eventID The ID of the Event as a String
     * @return a boolean that returns true if the event can be removed from VIP's schedule and false otherwise
     */
    public boolean canCancelEnrollment(String username, String eventID){
        List<String> idSchedule =  this.vm.getSchedule(username);
        boolean validEvent = validEvent(eventID);
        return (validEvent && idSchedule.contains(eventID));
    }

    /**
     * Removes an Event from the VIP's schedule
     * @param username The VIP's username as a String
     * @param eventID The ID of the Event as a String
     */
    public void cancelEnrollment(String username, String eventID){
        boolean canCancel = canCancelEnrollment(username, eventID);
        Event event = getEventMap().get(eventID);
        if (canCancel){
            this.vm.eventCancel(username, eventID);
            event.removeInEvent(username);
        }
    }
}
