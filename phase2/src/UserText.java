import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserText {
    private List<Person> people = new ArrayList<>();

    /**
     * Precondition: T is a subtype of Person
     *
     * Extends a list of Person to people.
     * @param list The list of Person to add into people.
     * @param <T> The type of list. It is assumed to be a subtype of Person.
     */
    public <T> void addPeopleToList(List<T> list){
        for(T person: list){
            people.add((Person) person);
        }
    }

    /**
     * Sends a message to a user
     *
     * Extends a list of Person to people.
     * @param message The content of the message being sent.
     * @param sender The attendee that is being replied to.
     * @param recipient The user that is replying
     */
    public void sendSingleMessage(String message, String sender, String recipient){
        for (Person user: people){
            if(user.getUsername().equals(recipient)){
                user.addToMessageStorage(message, sender);
            }
        }
    }

    /**
     * Creates a message object and stores in the every Speaker's message list, and the sender's message list.
     *
     * @param message The String message to be sent.
     * @param currentPerson The sender of the message.
     */
    public void messageAllSpeakers(String message, String currentPerson) {
        for (Person user : people) {
            if (user.isSpeakerType()) {
                user.addToMessageStorage(message, currentPerson);
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
    public void messageAllAttendees(String message, String currentPerson) {
        for (Person user : people) {
            if (user.isAttendeeType()) {
                user.addToMessageStorage(message, currentPerson);
            }
        }
    }

    public void messageAllAttendeesInEvents(List<String> events, String message, String sender) {
        for (Person user : people){
            if (user.isAttendeeType()) {
                boolean sent = false; //so a message is not sent twice if an attendee is signed up for multiple talks
                for (String talk: events){
                    if (((Attendee) user).getSchedule().contains(talk) && !sent){
                        user.addToMessageStorage(message, sender);
                        sent = true;
                    }
                }
            }
        }
    }

    /**
     * Returns the messages sent to the currently logged in user as a string. It takes the form
     * "sender1: message, sender2: message, ..."
     *
     * @return Returns the string of messages sent to the current user.
     */
    public List readMessage(String currPerson) {
        for (Person person : people) {
            if (person.getUsername().equals(currPerson)) {
                return person.getStoredMessagesList();
            }
        }
        return Collections.emptyList();
    }

}
