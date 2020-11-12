import java.util.List;
public class Event {
    private String id;
    private int time;
    private Speaker speaker;
    private List<Object> inEvent;

    public Event(String id, int time, Speaker speaker){
        this.id = id;
        this.time = time;
        this.speaker = speaker;
        inEvent = null; // Contains Persons who signed up for event
    }

    // Returns the Event's id
    public String getID(){
        return id;
    }

    // Returns the start time of the event
    public int getTime(){
        return time;
    }

    // Returns the speaker object of the event
    public Speaker getSpeaker(){
        return speaker;
    }

    // Return how many people in certain Event
    public int getCountInEvent(){
        return inEvent.size();
    }

    // Update the people who signed up for an event
    public void updateInEvent(Object person){
        inEvent.add(person);
    }

    public List<Object> getInEvent(){
        return this.inEvent;
    }
}
