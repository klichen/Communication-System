import java.util.ArrayList;
import java.util.List;

public class SpeakerSystem {
    // Controller class (gets input from user)
    EventScheduler es;
    SpeakerManager sm;

    // Get list of talks they are giving (schedule)
    public ArrayList<String> getSchedule(String speakerUsername){
        return sm.getSchedule(speakerUsername);
    }

    // This should happen under AttendeeSystem/Manager when they sign up for an event, not here
//    public void addAttendeesToContactList(String speakerUsername, String eventId){
//        ArrayList<String> contactList = sm.getUsernameToSpeaker().get(speakerUsername).getContactList();
//        List<String> attendeeList = es.getIdToEvent().get(eventId).getInEvent();
//
//        for (String attendeeUsername: attendeeList){
//            if (!(contactList.contains(attendeeUsername))){
//               sm.addToContactList(speakerUsername, attendeeUsername);
//            }
//        }
//    }
}
