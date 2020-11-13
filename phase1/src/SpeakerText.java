import java.util.ArrayList;

public class SpeakerText {
    private ArrayList<Person> people;

    public SpeakerText(ArrayList<Person> people){
        this.people = people;
    }

    public void messageAllAttendees(ArrayList<Event> events, String message, Person currentPerson) {
        for (Person user : people){
            if (user.isAttendeeType()) {
                boolean sent = false; //so a message is not sent twice if an attendee is signed up for multiple talks
                for (Event talk: events){
                    if (((Attendee) user).getSchedule().contains(talk) && !sent){
                        Message m = new Message(message, currentPerson, user);
                        user.addToMessageStorage(m.getMessage(), m.getSender());
                        sent = true;
                    }
                }
            }
        }
    }
}
