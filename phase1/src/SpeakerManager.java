import java.util.ArrayList;
import java.util.List;

public class SpeakerManager {

    private Speaker speaker;

    public SpeakerManager(Speaker speaker){
        this.speaker = speaker;
    }
    //  Log in

    //  see a list of talks that they are giving.
    public ArrayList<Event> getSchedule(){
        return speaker.getSchedule();
    }

    //  Message all Attendees who are signed up for a particular event, at once or individually.

    // See if a person is in contacts
    public boolean isContact(String personUsername){
        ArrayList<String> contactList = new ArrayList<>(this.speaker.getContactList());
        for (String i: contactList){
            if (i.equals(personUsername)){
                return true;
            }
        }
        return false;
    }

    // add attendees of all talks to contact list
    public void addAttendeesToContactList(Event event){
        ArrayList<String> contactList = this.speaker.getContactList();
        List<Person> attendeeList = event.getInEvent();

        for (Person i: attendeeList){
            if (!(contactList.contains(i.getUsername()))){
                this.speaker.addToContactList(i.getUsername());
            }
        }
    }

    // remove attendees of talk from contact list
    // to be used in case of cancellation of an event
    public void removeAttendeesFromContactList(Event event){
        List<Person> attendeesToGetRid = event.getInEvent();
        ArrayList<String> attendeesToKeep = getAllAttendees();

        for (Person i: attendeesToGetRid){
            if (!(attendeesToKeep.contains(i.getUsername()))){
                this.speaker.removeFromContactList(i.getUsername());
            }
        }
    }

    private ArrayList<String> getAllAttendees() {
        ArrayList<Event> schedule = new ArrayList<>(this.speaker.getSchedule());
        ArrayList<String> AttendeeList = new ArrayList<>();

        for (Event i: schedule){
            for (Person j: i.getInEvent()){
                AttendeeList.add(j.getUsername());
            }
        }

        return AttendeeList;
    }
}
