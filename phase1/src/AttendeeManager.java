import java.util.ArrayList;
import java.util.Map;

public class AttendeeManager {
    // Change after so that this is a String for the attendeeUsername
    // private String attendeeUsername;
    private Map<String, Attendee> attendeeMap;

    public AttendeeManager() {
    }

    // returns attendeeMap
    public Map<String, Attendee> getAttendeeMap() {
        return this.attendeeMap;
    }

    // returns whether attendee can create an account (checks if username is already taken)
    public boolean canCreateAccount(String username){
        return !attendeeMap.containsKey(username);
    }

    // Create attendee account
    public void createAccount(String username, String password){
        if(canCreateAccount(username)){
            Attendee attendee = new Attendee(username, password);
            attendeeMap.put(username, attendee);
        }
    }

    // returns whether a contact can be added (if contact is already in list)
    // same as checking if they are in your contacts
    public boolean canAddToContactList(String username, String contact){
        ArrayList<String> contactList = attendeeMap.get(username).getContactList();
        return !contactList.contains(contact);
    }

    // adds a person's username to Person's contact list
    public void addToContactList(String username, String contact) {
        Attendee attendee = attendeeMap.get(username);
        if (canAddToContactList(username, contact)){
            attendee.addToContact(contact);
        }

    }

    // Signup for events
//    public void eventSignUp(Event event){
//        ArrayList<String> attendeeSchedule = new ArrayList<> (this.attendee.getSchedule());
//        ArrayList<Integer> eventTimes = new ArrayList<>(this.attendee.getEventTimes());
//        boolean canAdd = true;
//        if (attendeeSchedule.contains(event.getID())){
//            canAdd = false;
//        }
//
//        for (Integer i: eventTimes){
//            if (event.getTime() == i) {
//                canAdd = false;
//                break;
//            }
//        }
//
//        if (canAdd){
//            event.updateInEvent(this.attendee.getUsername());
//            this.attendee.schedule.add(event.getID());
//        }
//    }
//
//    // Cancel their enrolment in an event
//    public void eventCancel(Event event){
//        ArrayList<String> attendeeSchedule = new ArrayList<> (this.attendee.getSchedule());
//        // Check if they are actually enrolled in the event
//        if (attendeeSchedule.contains(event.getID())){
//            // Remove from list of events
//            event.removeInEvent(this.attendee.getUsername());
//            this.attendee.schedule.remove(event.getID());
//        }
//    }

    // See schedule of the events for which they signed up
    public ArrayList<String> getSchedule(String username){
        Attendee attendee = attendeeMap.get(username);
        return attendee.getSchedule();
    }

}
