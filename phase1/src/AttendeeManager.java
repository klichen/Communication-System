import java.util.ArrayList;

public class AttendeeManager {
    // Change after so that this is a String for the attendeeUsername
    private Attendee attendee;

    public AttendeeManager(Attendee attendee) {
        this.attendee = attendee;
    }
    // Log in and see a schedule of events for which they can sign up

    // adds a person's username to Person's contact list
    void addToContactList(String contact) {attendee.getContactList().add(contact);
    }

    // Signup for events
    public void eventSignUp(Event event){
        ArrayList<String> attendeeSchedule = new ArrayList<> (this.attendee.getSchedule());
        ArrayList<Integer> eventTimes = new ArrayList<>(this.attendee.getEventTimes());
        boolean canAdd = true;
        if (attendeeSchedule.contains(event.getID())){
            canAdd = false;
        }

        for (Integer i: eventTimes){
            if (event.getTime() == i) {
                canAdd = false;
                break;
            }
        }

        if (canAdd){
            event.updateInEvent(this.attendee.getUsername());
            this.attendee.schedule.add(event.getID());
        }
    }

    // Cancel their enrolment in an event
    public void eventCancel(Event event){
        ArrayList<Event> attendeeSchedule = new ArrayList<> (this.attendee.getSchedule());
        // Check if they are actually enrolled in the event
        if (attendeeSchedule.contains(event.getID())){
            // Remove from list of events
            event.removeInEvent(this.attendee.getUsername());
            this.attendee.schedule.remove(event.getID());
        }
    }

    // See schedule of the events for which they signed up
    public ArrayList<String> getSchedule(){
        return attendee.getSchedule();
    }

    // See if a person is in contacts
    public boolean isContact(String personUsername){
        ArrayList<String> contactList = new ArrayList<String>(attendee.getContactList());
        for (String i: contactList){
            if (i.equals(personUsername)){
                return true;
            }
        }
        return false;
    }
}
