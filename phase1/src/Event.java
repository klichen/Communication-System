import java.util.List;
public class Event {
    private String id;
    private int time;
    private String speakerUsername;
    private String speakerPassword;
    private String roomNum;
    private List<String> inEvent;

    public Event(String roomNum, String id, int time, String speakerUsername, String speakerPassword){
        this.id = id;
        this.roomNum = roomNum;
        this.time = time;
        this.speakerUsername = speakerUsername;
        this.speakerPassword = speakerPassword;
        inEvent = null; // Contains Persons who signed up for event
    }

    // Returns the Event's id (Unique to each event)
    public String getID(){
        return id;
    }

    // Returns the start time of the event
    public int getTime(){
        return time;
    }

    //Returns the room number
    public String getRoomNum(){ return roomNum; }

    // Returns the username of the speaker of the event
    public String getSpeaker(){
        return speakerUsername;
    }

    // Returns the password of the speaker of the event
    public String getSpeakerPassword(){
        return speakerPassword;
    }

    // Return how many people in certain Event
    public int getCountInEvent(){
        return inEvent.size();
    }

    // Update the people who signed up for an event
    public void updateInEvent(String person){
        if(getCountInEvent() != 2){
            inEvent.add(person);
        }
    }

    // Remove the people who cancelled their enrollment in an event
    public void removeInEvent(String person){
        inEvent.remove(person);
    }

    public List<String> getInEvent(){
        return inEvent;
    }
}
