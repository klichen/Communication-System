import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventScheduler {

    private List<Event> ListOfEvents;
    private Map<String, Event> idToEvent;

    // Constructor for EventScheduler
    // Contains the main list of events
    public EventScheduler(){
        ListOfEvents =  new ArrayList<Event>();
        idToEvent = new HashMap<>();
    }

    // Updates the main list of events
    public boolean updateEvents(String roomNum, String id, int time, String speakerUsername, String speakerPassword){
        if(validEvent(roomNum, id, time, speakerUsername)){
            Event s = new Event(roomNum, id, time, speakerUsername, speakerPassword);
            ListOfEvents.add(s);
            idToEvent.put(id, s);
            System.out.println(idToEvent);
            return true;
        }
        return false;
    }

    // Map (ID to Event)
    public Map<String, Event> getIdToEvent(){
        return idToEvent;
    }

    // Checks whether the events being added are valid or not
    public boolean validEvent(String roomNum, String id, int time, String speakerUsername){
        if(time < 9 || time > 16){
            return false;
        }
        for(Event i : ListOfEvents){
            // Check for double booking room
            if(time == i.getTime() && roomNum.equals(i.getRoomNum())){
                return false;
            }
            // ID for each event must be unique
            if(id.equals(i.getID())){
                return false;
            }
            // Check for speaker at two places at same time
            if(time == i.getTime() &&
                    speakerUsername.equals(i.getSpeaker())){
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
            tempConvert.add(i.getRoomNum() + ","+ i.getID() + "," + i.getTime() + ","
                    + i.getSpeaker() + ","+ i.getSpeakerPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }

}
