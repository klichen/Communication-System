import java.util.ArrayList;

public class AttendeeManager {

    private Attendee attendee;

    public AttendeeManager(Attendee attendee) {
        this.attendee = attendee;
    }
    // Log in and see a schedule of events for which they can sign up

    // Signup for events
    public void eventSignUp(Event event){

    }

    // Cancel their enrolment in an event
    public void eventCancelSignUp(Event event){

    }

    // See schedule of the events for which they signed up
    public ArrayList<Event> getSchedule(){
        return attendee.getSchedule();
    }

    // Send messages to and receive messages from other Attendees, and message with Speakers
}
