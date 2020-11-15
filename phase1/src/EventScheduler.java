import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventScheduler {

    private List<String> ListOfStrings;
    private Map<String, Event> idToEvent;

    // Constructor for EventScheduler
    // Contains the main list of events
    public EventScheduler(){
        ListOfStrings =  new ArrayList<String>();
        idToEvent = new HashMap<>();
    }

    // Updates the main list of events
    public boolean updateEvents(String roomNum, String id, int time, String speakerUsername, String speakerPassword){
        if(validEvent(roomNum, id, time, speakerUsername)){
            Event s = new Event(roomNum, id, time, speakerUsername, speakerPassword);
            ListOfStrings.add(id);
            idToEvent.put(id, s);
            System.out.println(idToEvent);
            return true;
        }
        return false;
    }

    // Removes an event from list of events and idToEvent
    public void removeEvent(String id){
        if (ListOfStrings.contains(id)){
            ListOfStrings.remove(id);
            idToEvent.remove(id);
        }
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
        for(String i : ListOfStrings){
            // Check for double booking room
            if(time == idToEvent.get(i).getTime() && roomNum.equals(idToEvent.get(i).getRoomNum())){
                return false;
            }
            // ID for each event must be unique
            if(id.equals(idToEvent.get(i).getID())){
                return false;
            }
            // Check for speaker at two places at same time
            if(time == idToEvent.get(i).getTime() &&
                    speakerUsername.equals(idToEvent.get(i).getSpeaker())){
                return false;
            }
        }
        return true;
    }

    // Returns the main list of event ids
    public List<String> getEventList(){
        return ListOfStrings;
    }

    // Converts the list of events into a List<List<String>>
    // in order to be saved to txt file
    public List<List<String>> eventToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        for (String i : ListOfStrings){
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add(idToEvent.get(i).getRoomNum() + ","+ i + "," + idToEvent.get(i).getTime() + ","
                    + idToEvent.get(i).getSpeaker() + ","+ idToEvent.get(i).getSpeakerPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }

}
