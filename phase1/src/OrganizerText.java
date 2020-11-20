import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

public class OrganizerText {
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

    /**
     * Creates a message object and stores it in the recipient's message list, and the sender's message list.
     *
     * @param message The String message to be sent.
     * @param currentPerson The sender of the message.
     * @param recipient The recipient of the message
     */
    public void messageSingleRecipient(String message, String currentPerson, String recipient) {
        for(Person person: people) {
            if (person.getUsername().equals(recipient)) {
                person.addToMessageStorage(message, currentPerson);
                break;
            }
        }
    }
}
