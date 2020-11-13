import java.util.ArrayList;

public class AttendeeText {
    private ArrayList<Person> people;

    public AttendeeText(ArrayList<Person> people){
        this.people = people;
    }
    public void sendMessage(String message, Person currentPerson, Person recipient){
        Message m = new Message(message, currentPerson, recipient);
        recipient.addToMessageStorage(m.getMessage(), m.getSender());
    }
}
