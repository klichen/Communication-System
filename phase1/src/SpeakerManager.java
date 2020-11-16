import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpeakerManager extends PersonManager {
    //  Log in

    // Get schedule
    public ArrayList<String> getSchedule(String speakerUsername){
        return usernameToSpeaker.get(speakerUsername).getSchedule();
    }

    // Add event's id to speaker's schedule
    public void updateSchedule(String speakerUsername, String eventId){
        getSchedule(speakerUsername).add(eventId);
    }

    // adds a person's username to Speaker's contact list
    public void addToContactList(String speakerUsername, String contact) {
        usernameToSpeaker.get(speakerUsername).getContactList().add(contact);
    }

    // remove a person's username from Speaker's contact list
    public void removeFromContactList(String speakerUsername, String contact){
        usernameToSpeaker.get(speakerUsername).getContactList().remove(contact);
    }

    // See if a person is in contacts
    public boolean isContact(String speakerUsername, String personUsername){
        return usernameToSpeaker.get(speakerUsername).getContactList().contains(personUsername);
    }

    // add attendees of Event event to contact list
    public void addAttendeesToContactList(String speakerUsername, Event event){
        // EVENT SHOULD NOT BE USED (ONLY THE ID)
        ArrayList<String> contactList = usernameToSpeaker.get(speakerUsername).getContactList();
        List<String> attendeeList = event.getInEvent();

        for (String attendeeUsername: attendeeList){
            if (!(contactList.contains(attendeeUsername))){
                addToContactList(speakerUsername, attendeeUsername);
            }
        }
    }

    // remove attendees of talk from contact list
    // to be used in case of cancellation of an event
//    public void removeAttendeesFromContactList(Event event){
//        List<String> attendeesToGetRid = event.getInEvent();
//        ArrayList<String> attendeesToKeep = getAllAttendees();
//
//        for (String i: attendeesToGetRid){
//            if (!(attendeesToKeep.contains(i))){
//                removeFromContactList(i);
//            }
//        }
//    }
//
//    private ArrayList<String> getAllAttendees() {
//        ArrayList<String> schedule = new ArrayList<>(this.speaker.getSchedule());
//        ArrayList<String> AttendeeList = new ArrayList<>();
//        EventScheduler eventScheduler = new EventScheduler();
//
//
//        for (String i: schedule){
//            for (Person j: i.getInEvent()){
//                AttendeeList.add(j.getUsername());
//            }
//        }
//
//        return AttendeeList;
//    }
}
