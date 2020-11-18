import java.util.ArrayList;

public class AttendeeText {
    private ArrayList<Person> people;

    public <T> void addPeopleToList(ArrayList<T> list){
        for(T person: list){
            people.add((Person) person);
        }
    }

//    public AttendeeText(ArrayList<Person> people){
//        this.people = people;
//    }
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
