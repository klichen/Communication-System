import java.util.ArrayList;
import java.util.List;

public class AttendeeText {
    private List<Person> people = new ArrayList<>();

    public <T> void addPeopleToList(List<T> list){
        for(T person: list){
            people.add((Person) person);
        }
    }

    public void sendMessage(String message, String sender, String recipient){
        //Message m = new Message(message, currentPerson.getUsername(), recipient.getUsername());
        //recipient.addToMessageStorage(m.getMessage(), m.getSender());
        for (Person user: people){
            if(user.getUsername().equals(recipient)){
                user.addToMessageStorage(message, sender);
            }
        }
    }
}
