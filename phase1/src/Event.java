package src;

public class Event {
    private int person;
    private int time;
    private int speaker_id;
    public Event(int _id, int time, int speaker){
        this.person = _id;
        this.time = time;
        this.speaker_id = speaker;
    }
    // getter for time
    public int getTime() {
        return this.time;
    }
    // getter for speaker_id
    public int getSpeaker_id() {
        return this.speaker_id;
    }
}
