import java.util.List;
public class Event {
    private String id;
    private int time;
    private String speakerUsername;
    private List<Person> inEvent;

    public Event(String id, int time, String speakerUsername){
        this.id = id;
        this.time = time;
        this.speakerUsername = speakerUsername;
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

    // Returns the username of the speaker of the event
    public String getSpeaker(){
        return speakerUsername;
    }

    // Return how many people in certain Event
    public int getCountInEvent(){
        return inEvent.size();
    }

    // Update the people who signed up for an event
    public void updateInEvent(Person person){
        inEvent.add(person);
    }

    // Remove the people who cancelled their enrollment in an event
    public void removeInEvent(Person person){
        inEvent.remove(person);
    }

    public List<Person> getInEvent(){
        return this.inEvent;
    }
}
