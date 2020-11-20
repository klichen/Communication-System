import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventScheduler {

    private List<String> ListOfEvents;
    private Map<String, Event> idToEvent;

    // Constructor for EventScheduler
    // Contains the main list of events
    /**
     * Creates an EventScheduler object that stores the list of all Events and stores the nap where the item is the
     * name of the Event and the value is the event object corresponding to the name.
     */
    public EventScheduler(){
        ListOfEvents =  new ArrayList<String>();
        idToEvent = new HashMap<>();
    }

    // Updates the main list of events
    /**
     * Updates the list of all Events by creating a new Event object that stores the room number, the name,
     * the time and the speaker's username and then adding it to the list.
     *
     * @param roomNum The room number of where the event is
     * @param id The name of the event
     * @param time The time the event starts
     * @param speakerUsername The username of the speaker
     */
    public boolean updateEvents(String roomNum, String id, int time, String speakerUsername){//}, String speakerPassword){
        if(validEvent(roomNum, id, time, speakerUsername)){
            Event s = new Event(roomNum, id, time, speakerUsername);//, speakerPassword);
            ListOfEvents.add(id);
            idToEvent.put(id, s);
            System.out.println(idToEvent);
            return true;
        }
        return false;
    }

    // Removes an event from list of events and idToEvent
    /**
     * Removes the event object from the list of all events using the name of the event.
     *
     * @param id The name of the event want removed
     */
    public boolean removeEvent(String id){
        if (ListOfEvents.contains(id)){
            ListOfEvents.remove(id);
            idToEvent.remove(id);
            return true;
        }
        return false;
    }

    // Map (ID to Event)
    /**
     * Returns the map where the item is the name of the event and the value corresponded is the event object.
     */
    public Map<String, Event> getIdToEvent(){
        return idToEvent;
    }

    // Checks whether the events being added are valid or not
    /**
     * Returns true if an event object created using room number, name, time and speaker's username has overlapping
     * times with any events in the list of all events, has name not identical with any other and whether the speaker's
     * username can join. Otherwise, returns false.
     *
     * @param roomNum The room number of where the Event is.
     * @param id The name of the Event.
     * @param time The time the Event starts.
     * @param speakerUsername The username of the Speaker.
     */
    public boolean validEvent(String roomNum, String id, int time, String speakerUsername){
        if(time < 9 || time > 16){
            return false;
        }
        for(String i : ListOfEvents){
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
    /**
     * Returns the list of all events.
     */
    public List<String> getEventList(){
        return ListOfEvents;
    }

    // Converts the list of events into a List<List<String>>
    // in order to be saved to txt file
    public List<List<String>> eventToString(SpeakerManager speakerManager){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        for (String i : ListOfEvents){
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add(idToEvent.get(i).getRoomNum() + ","+ i + "," + idToEvent.get(i).getTime() + ","
                    + idToEvent.get(i).getSpeaker() + ","
                    + speakerManager.getUsernameToSpeaker().get(idToEvent.get(i).getSpeaker()).getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }

}
