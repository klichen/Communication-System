import java.util.ArrayList;
import java.util.List;

public class AttendeeText {
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
     * Sends a message to a user
     *
     * Extends a list of Entities.Person to people.
     * @param message The content of the message being sent.
     * @param sender The attendee that is being replied to.
     * @param recipient The user that is replying
     */
    public void sendMessage(String message, String sender, String recipient){
        for (Person user: people){
            if(user.getUsername().equals(recipient)){
                user.addToMessageStorage(message, sender);
            }
        }
    }
}
