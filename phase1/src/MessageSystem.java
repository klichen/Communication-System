import java.util.ArrayList;

public class MessageSystem {
    private final ArrayList<Person> users;
    private final ArrayList<Event> events;

    public MessageSystem(ArrayList<Person> users, ArrayList<Event> events){
        this.users = users;
        this.events = events;
    }

    private Person findPerson(ArrayList<Person> people, String name){
        for(Person p:people){
            if (p.getUsername().equals(name)){
                return p;
            }
        }
        return null;
    }

    public void sendMessage(String message, Person sender, String receiver, Person currPerson){
        if(sender.isOrganizerType()){
            OrganizerText text = new OrganizerText(users);
            if(receiver.equals("All Speakers")){
                text.messageAllSpeakers(message, currPerson);
            }
            else if(receiver.equals("All Attendees")) {
                text.messageAllAttendees(message, currPerson);
            }
            else{
                Person recipient = this.findPerson(users, receiver);
                text.messageSingleRecipient(message, currPerson, recipient);
            }
        }
        else if(sender.isAttendeeType()){
            AttendeeText text = new AttendeeText(users);
            Person recipient = this.findPerson(users, receiver);
            text.sendMessage(message, currPerson, recipient); // Assuming AttendeeText is implemented similar to
                                                              // OrganizerText
        }
        else if(sender.isSpeakerType()){
            Speaker speaker = (Speaker) sender;
            SpeakerText text = new SpeakerText(users);
            ArrayList<Event> eventArrayList = new ArrayList<Event>();
            for(String eventName:speaker.getSchedule()){
                for(Event event:events){
                    if(eventName.equals(event.getID())){
                        eventArrayList.add(event);
                    }
                }
            }
            text.messageAllAttendees(eventArrayList, message, currPerson);
        }
    }

}
