import java.util.ArrayList;
import java.util.List;

public class SpeakerManager {
    // Change after so that this is a String for the speakerUsername
    private Speaker speaker;

    public SpeakerManager(Speaker speaker){
        this.speaker = speaker;
    }
    //  Log in

    // adds a person's username to Speaker's contact list
    public void addToContactList(String contact) {
        speaker.getContactList().add(contact);
    }

    // remove a person's username from Speaker's contact list
    public void removeFromContactList(String contact){
        speaker.getContactList().remove(contact);
    }

    //  see a list of talks that they are giving.
    public ArrayList<Event> getSchedule(){
        return speaker.getSchedule();
    }

    // See if a person is in contacts
    public boolean isContact(String personUsername){
        ArrayList<String> contactList = new ArrayList<>(this.speaker.getContactList());
        // Simpler ? -> return contactList.contains(personUsername);
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
                addToContactList(i.getUsername());
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
                removeFromContactList(i.getUsername());
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
