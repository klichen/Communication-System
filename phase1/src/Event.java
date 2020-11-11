
public class Event {
    private int person;
    private int time;
    private Person speaker;
    public Event(int _id, int time, Person speaker){
        this.person = _id;
        this.time = time;
        this.speaker = speaker;
    }
    // getter for time
    public int getTime() {
        return this.time;
    }

    // getter for speaker_id
    public String getSpeaker_id() {
        return this.speaker.getUsername();
    }

    //getter for speaker
    public Person getSpeaker(){
        return this.speaker;
    }
}
