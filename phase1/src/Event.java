import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Event implements Serializable{
    private String id;
    private int time;
    private String speakerUsername;
    //private String speakerPassword;
    private String roomNum;
    private List<String> inEvent;

    /**
     * Creates an Event object that stores the room number, the name, the time, and the
     * speaker's username.
     *
     * @param roomNum the room number of where the event is
     * @param id the name of the event
     * @param time the time the event starts
     * @param speakerUsername the username of the speaker
     */
    public Event(String roomNum, String id, int time, String speakerUsername){//}, String speakerPassword){
        this.id = id;
        this.roomNum = roomNum;
        this.time = time;
        this.speakerUsername = speakerUsername;
        //this.speakerPassword = speakerPassword;
        this.inEvent = new ArrayList<>();
    }

    // Returns the Event's id (Unique to each event)
    /**
     * Returns the name of this event
     */
    public String getID(){
        return id;
    }

    // Returns the start time of the event
    /**
     * Returns the time that this event starts
     */
    public int getTime(){
        return time;
    }

    //Returns the room number
    /**
     * Returns the room number of this event
     */
    public String getRoomNum(){ return roomNum; }

    // Returns the username of the speaker of the event
    /**
     * Returns the speaker's username of this event
     */
    public String getSpeaker(){
        return speakerUsername;
    }

    // Returns the password of the speaker of the event
    /*public String getSpeakerPassword(){
        return speakerPassword;
    }*/

    // Return how many people in certain Event
    /**
     * Returns the number of people in this event.
     */
    public int getCountInEvent(){
        return inEvent.size();
    }

    // Update the people who signed up for an event
    /**
     * Adds another person who's signed up to this event.
     *
     * @param person the person who is signing up for the event but hasn't joined yet
     */
    public void updateInEvent(String person){
        if(getCountInEvent() != 2){
            inEvent.add(person);
        }
    }

    // Remove the people who cancelled their enrollment in an event
    /**
     * Removes a person who's signed up from this event.
     *
     * @param person the person who is no longer in the event but is still signed up
     */
    public void removeInEvent(String person){
        inEvent.remove(person);
    }

    /**
     * Returns the list of people who are signed up to the event.
     */
    public List<String> getInEvent(){
        return inEvent;
    }
}
