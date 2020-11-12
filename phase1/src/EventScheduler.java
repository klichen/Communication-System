import java.util.ArrayList;
import java.util.List;

public class EventScheduler {

    private List<Event> ListOfEvents;

    // Constructor for EventScheduler
    // Contains the main list of events
    public EventScheduler(){
        ListOfEvents =  new ArrayList<Event>();
    }

    // Updates the main list of events
    public void updateEvents(String id, int time, Speaker speaker){
        if(validEvent(id, time, speaker)){
            Event s = new Event(id, time, speaker);
            ListOfEvents.add(s);
        }
    }

    // Checks whether the events being added are valid or not
    public boolean validEvent(String id, int time, Speaker speaker){
        if(time < 9 || time > 16){
            return false;
        }
        for(Event i : ListOfEvents){
            // Check for double booking room
            if(time == i.getTime() && id.equals(i.getID())){
                return false;
            }
            // Check for speaker at two places at same time
            if(time == i.getTime() &&
                    speaker.getUsername().equals(i.getSpeaker().getUsername())){
                return false;
            }
        }
        return true;
    }

    // Returns the main list of events
    public List<Event> getEventList(){
        return ListOfEvents;
    }

    // Converts the list of events into a List<List<String>>
    // in order to be saved to txt file
    public List<List<String>> eventToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        for (Event i : ListOfEvents){
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add(i.getID() + "," + i.getTime() + "," + i.getSpeaker().getUsername()
                    + ","+ i.getSpeaker().getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }

}