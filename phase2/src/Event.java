import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event implements Serializable{
    private String id;
    private int time;
    private List<String> listSpeakerUsername;
    //private String speakerPassword;
    private String roomNum;
    private List<String> inEvent;
    private boolean isVip;
    private int duration;
    private int capacity;

    /**
     * Creates an Event object that stores the room number, the name, the time, the Vip quality, the duration, the
     * capacity and the list of speakers' usernames
     *
     * @param roomNum the room number of where the event is
     * @param id the name of the event
     * @param time the time the event starts
     * @param isVip true if the event is for VIP's only, false otherwise
     * @param duration number of hours this event lasts
     * @param max maximum number of people in the event
     */
    public Event(String roomNum, String id, int time, List<String> lst, boolean isVip, int duration, int max){//}, String speakerPassword){
        this.id = id;
        this.roomNum = roomNum;
        this.time = time;
        this.listSpeakerUsername = lst;
        //this.speakerPassword = speakerPassword;
        this.inEvent = new ArrayList<>();
        this.isVip = isVip;
        this.duration = duration;
        this.capacity = max;
    }

    // Returns the Event's id (Unique to each event)
    /**
     * Returns the name of this event
     *
     * @return the name of the event
     */
    public String getID(){
        return id;
    }

    // Returns the start time of the event
    /**
     * Returns the time that this event starts
     *
     * @return the time of the event
     */
    public int getTime(){
        return time;
    }

    /**
     * Returns the list of speakers' usernames
     *
     * @return the list of speakers' usernames
     */
    public List<String> getSpeaker(){
        return listSpeakerUsername;
    }

    //Returns the room number
    /**
     * Returns the room number of this event
     *
     * @return the room number of the event
     */
    public String getRoomNum(){ return roomNum; }

    // Returns the password of the speaker of the event
    /*public String getSpeakerPassword(){
        return speakerPassword;
    }*/

    // Return how many people in certain Event
    /**
     * Returns the number of people in this event
     *
     * @return the sizeof the list of people in the event
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
        if(getCountInEvent() != 2 && getCountInEvent() <= getCapacity()){
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

    public boolean getIsVip(){return isVip;}

    public int getDuration(){return duration;}

    public int getCapacity(){return capacity;}
}
