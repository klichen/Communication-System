import java.lang.reflect.Array;
import java.util.ArrayList;

public class Attendee extends Person{
    private ArrayList<String> contactList;
    protected ArrayList<String> schedule;
    protected ArrayList<Integer> eventTimes;

    public Attendee(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<String>();
        this.isSpeaker = false;
        this.isAttendee = true;
        this.isOrganizer = false;
        this.schedule = new ArrayList<String>();
        this.eventTimes = new ArrayList<Integer>();
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

    public ArrayList<Integer> getEventTimes(){
        return this.eventTimes;
    }

    //public void updateSchedule(Event event){
        //this.schedule.add(event);
    //}
}
