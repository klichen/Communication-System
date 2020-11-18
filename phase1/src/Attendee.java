import java.lang.reflect.Array;
import java.util.ArrayList;

public class Attendee extends Person{
    private ArrayList<String> contactList;
    private ArrayList<String> schedule;


    public Attendee(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<>();
        this.isSpeaker = false;
        this.isAttendee = true;
        this.isOrganizer = false;
        this.schedule = new ArrayList<>();
    }

    // returns the list of people the Person can message
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    public void addToContact(String contact){
        this.contactList.add(contact);
    }

    public ArrayList<String> getSchedule(){
        return this.schedule;
    }

    public void addToSchedule(String eventID){
        this.schedule.add(eventID);
    }

    public void removeFromSchedule(String eventID){
        this.schedule.remove(eventID);
    }


}
