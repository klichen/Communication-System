import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AttendeeSystem {
    // Controller class (gets input from user)
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;

    public AttendeeSystem(AttendeeManager am, EventScheduler es, OrganizerManager om, SpeakerManager sm){
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
    }

    // read string and return it
    public String readString(){
        String eventID;
        Scanner scan = new Scanner(System.in);
        eventID = scan.nextLine();


        return eventID;
    }

    // create attendee account
    public void createAccount(String username, String password){
        am.createAttendee(username, password);
    }

    // can attendee add a contact
    public boolean canAddContact(String username, String contact){
        boolean userCheck = false;
        if (am.getUsernameToAttendee().containsKey(username)){
            userCheck = true;
        } else if (om.getUsernameToOrganizer().containsKey(username)){
            userCheck = true;
        } else if (sm.getUsernameToSpeaker().containsKey(username)){
            userCheck = true;
        }
        return userCheck && this.am.canAddToContactList(username, contact);
    }

    // add a contact
    public void addContact(String username, String contact){
        this.am.addToContactList(username, contact);
    }

    // get the event map
    private Map<String, Event> getEventMap(){
        return this.es.getIdToEvent();
    }

    // get attendee Schedule
    public List<Event> getSchedule(String username){
        List<String> idSchedule =  this.am.getSchedule(username);
        Map<String, Event> eventMap = getEventMap();
        List<Event> fullSchedule = new ArrayList<>();

        for (String i: idSchedule){
            if (eventMap.containsKey(i)){
                fullSchedule.add(eventMap.get(i));
            }
        }
        return fullSchedule;
    }

    public List<String> getScheduleIds(String username){
        List<Event> fullSchedule =  getSchedule(username);
        List<String> ScheduleString = new ArrayList<>();

        for (Event i: fullSchedule){
            ScheduleString.add("Event: " + i.getID() + ", Room Number: " + i.getRoomNum() + ", Time: " + i.getTime()
                    + ", Speaker: " + i.getSpeaker());
        }
        return ScheduleString;
    }

    // checks if valid event id
    private boolean validEvent(String eventID) {
        return getEventMap().containsKey(eventID);
    }

    // checks whether this event can be added
    public boolean canAddEvent(String username, String eventID){
        List<String> idSchedule =  this.am.getSchedule(username);
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

    // Add event to attendee schedule
    public void addEvent(String username, String eventID){
        boolean canAdd = canAddEvent(username, eventID);
        Event event = getEventMap().get(eventID);
        String speakerID = event.getSpeaker();
        Speaker eventSpeaker = sm.getUsernameToSpeaker().get(speakerID);
        if(canAdd){
            this.am.eventSignUp(username,eventID);
            this.addContact(username, speakerID);
            event.updateInEvent(username);
            eventSpeaker.addToContact(username);
        }
    }

    // check whether this event enrolment can be cancelled
    public boolean canCancelEnrollment(String username, String eventID){
        List<String> idSchedule =  this.am.getSchedule(username);
        boolean validEvent = validEvent(eventID);
        return (validEvent && idSchedule.contains(eventID));
    }

    // cancel attendee's enrolment in events
    public void cancelEnrollment(String username, String eventID){
        boolean canCancel = canCancelEnrollment(username, eventID);
        Event event = getEventMap().get(eventID);
        if (canCancel){
            this.am.eventCancel(username, eventID);
            event.removeInEvent(username);
        }
    }


}
