import java.util.ArrayList;
import java.util.Map;

public class AttendeeSystem {
    // Controller class (gets input from user)
    AttendeeManager am;
    EventScheduler es;

    // can attendee create an account
    public boolean canCreateAccount(String username){
        return this.am.canCreateAccount(username);
    }

    // create attendee account
    public void createAccount(String username, String password){
        this.am.createAccount(username, password);
    }

    // can attendee add a contact
    public boolean canAddContact(String username, String contact){
        return this.am.canAddToContactList(username, contact);
    }

    // add a contact
    public void addContact(String username, String contact){
        this.am.addToContactList(username, contact);
    }

    // get the event map
    private Map<String, Event> getEventMap(){
        return this.es.getIdToEvent();
    }

    // get attendee Schedule
    public ArrayList<Event> getSchedule(String username){
        ArrayList<String> idSchedule =  this.am.getSchedule(username);
        Map<String, Event> eventMap = getEventMap();
        ArrayList<Event> fullSchedule = new ArrayList<>();

        for (String i: idSchedule){
            if (eventMap.containsKey(i)){
                fullSchedule.add(eventMap.get(i));
            }
        }
        return fullSchedule;
    }


}
