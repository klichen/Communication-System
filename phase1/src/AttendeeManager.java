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
        ArrayList<Event> attendeeSchedule = new ArrayList<> (this.attendee.getSchedule());
        boolean canAdd = true;
        if (attendeeSchedule.contains(event)){
            canAdd = false;
        }

        for (Event i: attendeeSchedule){
            if (event.getTime() == i.getTime()) {
                canAdd = false;
                break;
            }
        }

        if (canAdd){
            event.updateInEvent(this.attendee);
            this.attendee.schedule.add(event);
        }
    }

    // Cancel their enrolment in an event
    public void eventCancel(Event event){
        ArrayList<Event> attendeeSchedule = new ArrayList<> (this.attendee.getSchedule());
        // Check if they are actually enrolled in the event
        if (attendeeSchedule.contains(event)){
            // Remove from list of events
            event.removeInEvent(this.attendee);
            this.attendee.schedule.remove(event);
        }
    }

    // See schedule of the events for which they signed up
    public ArrayList<Event> getSchedule(){
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
