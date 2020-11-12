import java.util.ArrayList;

public class AttendeeManager {

    private Attendee attendee;

    public AttendeeManager(Attendee attendee) {
        this.attendee = attendee;
    }
    // Log in and see a schedule of events for which they can sign up

    // Signup for events
    public void eventSignUp(Event event){
        ArrayList<Event> attendeeSchedule = new ArrayList<Event> (attendee.getSchedule());
        for (Event i: attendeeSchedule) {
            if (i == event) {
                event.updateInEvent(attendee);
                attendee.schedule.add(event);
            }
        }
    }

    // Cancel their enrolment in an event
    public void eventCancelSignUp(Event event){

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
