import java.util.ArrayList;
import java.util.List;

public class SpeakerText {
    private List<Person> people = new ArrayList<>();

    public <T> void addPeopleToList(List<T> list){
        for(T person: list){
            people.add((Person) person);
        }
    }

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

    public void respondAttendee(String message, String attendee, String sender){
        for (Person user: people){
            if(user.getUsername().equals(attendee)){
                user.addToMessageStorage(message, sender);
            }
        }
    }
}
