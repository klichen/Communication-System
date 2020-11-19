import java.util.ArrayList;
import java.util.List;

public class ReadMessageManager<T> {
    private final List<Person> people = new ArrayList<>();
    private final String currPerson;

    public ReadMessageManager(String currPerson){
        this.currPerson = currPerson;
    }

    public void addUsers(List<T> people){
        for(T person: people){
            this.people.add((Person) person);
        }
    }

    public String readMessage(){
        for(Person person: people){
            if(person.getUsername().equals(currPerson)){
                return person.getStoredMessages();
            }
        }
        return "No messages found.";
    }
}
