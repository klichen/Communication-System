import java.util.ArrayList;

public class OrganizerText {
    private ArrayList<Person> people;

    public OrganizerText(ArrayList<Person> people){
        this.people = people;
    }

    private void messageAll(Person type){

    }
    /**
     * Creates a message object and stores in the every Speaker's message list, and the sender's message list.
     *
     * @param message The String message to be sent.
     * @param currentPerson The sender of the message.
     */
    public void messageAllSpeakers(String message, Person currentPerson) {
        for (Person user : people) {
            if (user.isSpeakerType()) {
                Message m = new Message(message, currentPerson, user);
                user.addToMessageStorage(m.getMessage(), m.getSender());
                // defined in Person Class
            }
        }
    }

    /**
     * Creates a message object and stores in the every Attendee's message list, and the sender's message list.
     *
     * @param message The String message to be sent.
     * @param currentPerson The sender of the message.
     */
    public void messageAllAttendees(String message, Person currentPerson) {
        for (Person user : people) {
            if (user.isAttendeeType()) {
                Message m = new Message(message, currentPerson, user);
                user.addToMessageStorage(m.getMessage(), m.getSender());
            }
        }
    }

    /**
     * Creates a message object and stores it in the recipient's message list, and the sender's message list.
     *
     * @param message The String message to be sent.
     * @param currentPerson The sender of the message.
     * @param recipient The recipient of the message
     */
    public void messageSingleRecipient(String message, Person currentPerson, Person recipient) {
        Message m = new Message(message, currentPerson, recipient);
        recipient.addToMessageStorage(m.getMessage(), m.getSender()); //this method will be the setter method
    }
}
