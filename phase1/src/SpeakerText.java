import java.util.ArrayList;
import java.util.List;

public class SpeakerText {
    private List<Person> people = new ArrayList<>();


    /**
     * Precondition: T is a subtype of Entities.Person
     *
     * Extends a list of Entities.Person to people.
     * @param list The list of Entities.Person to add into people.
     * @param <T> The type of list. It is assumed to be a subtype of Entities.Person.
     */
    public <T> void addPeopleToList(List<T> list){
        for(T person: list){
            people.add((Person) person);
        }
    }

    /**
     * Sends a message to all attendees that are signed up in each of "events".
     *
     * Extends a list of Entities.Person to people.
     * @param events A list of strings consisting of event IDs.
     * @param message The content of the message being sent.
     * @param sender The user who sends the message
     */
    public void messageAllAttendees(List<String> events, String message, String sender) {

        for (Person user : people){
            if (user.isAttendeeType()) {
                boolean sent = false; //so a message is not sent twice if an attendee is signed up for multiple talks
                for (String talk: events){
                    if (((Attendee) user).getSchedule().contains(talk) && !sent){
                        //Message m = new Message(message, currentPerson.getUsername(), user.getUsername());
                        user.addToMessageStorage(message, sender);
                        sent = true;
                    }
                }
            }
        }
    }

    /**
     * Sends a message to a user
     *
     * Extends a list of Entities.Person to people.
     * @param message The content of the message being sent.
     * @param attendee The attendee that is being replied to.
     * @param sender The user that is replying
     */
    public void respondAttendee(String message, String attendee, String sender){
        for (Person user: people){
            if(user.getUsername().equals(attendee)){
                user.addToMessageStorage(message, sender);
            }
        }
    }
}
