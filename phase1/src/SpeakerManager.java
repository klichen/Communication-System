import java.util.ArrayList;

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

    public void updateContactList(){
        ArrayList<Event> schedule = getSchedule();
        ArrayList<String> contactList = speaker.getContactList();
        for (Event i: schedule){
            attendeeList =
        }
    }
}
