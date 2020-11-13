import java.util.ArrayList;

public class Attendee extends Person{
    private ArrayList<String> contactList;
    protected ArrayList<Event> schedule;

    public Attendee(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<String>();
        this.isSpeaker = false;
        this.isAttendee = true;
        this.isOrganizer = false;
        this.schedule = new ArrayList<Event>();
    }

    // returns the list of people the Person can message
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    public ArrayList<Event> getSchedule(){
        return this.schedule;
    }

    //public void updateSchedule(Event event){
        //this.schedule.add(event);
    //}
}
