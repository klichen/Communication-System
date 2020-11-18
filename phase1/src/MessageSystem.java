import com.sun.org.apache.xpath.internal.operations.Or;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.awt.event.ComponentListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessageSystem {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;

    public MessageSystem(AttendeeManager am, OrganizerManager om, SpeakerManager sm){
        this.am = am;
        this. om = om;
        this. sm = sm;
    }

    public void sendMessage(String message, String receiver, String currPerson){
        ArrayList<Attendee> attendees = am.getAllAttendees();
        ArrayList<Organizer> organizers = om.getAllOrganizers();
        ArrayList<Speaker> speakers = sm.getAllSpeakers();
        try{
            if (om.getUsernameToOrganizer().containsKey(currPerson)) {
                OrganizerText text = new OrganizerText();;
                if (receiver.equals("All Speakers")) {
                    text.addPeopleToList(speakers);
                    text.messageAllSpeakers(message, currPerson);
                } else if (receiver.equals("All Attendees")) {
                    text.addPeopleToList(attendees);
                    text.messageAllAttendees(message, currPerson);
                } else {
                    text.addPeopleToList(attendees);
                    text.addPeopleToList(speakers);
                    text.messageSingleRecipient(message, currPerson, receiver);
                }
            } else if (sender.isAttendeeType()) {
                AttendeeText text = new AttendeeText(users);
                Person recipient = this.findPerson(users, receiver);
                text.sendMessage(message, currPerson, recipient); // Assuming AttendeeText is implemented similar to
                // OrganizerText
            } else if (sender.isSpeakerType()) {
                Speaker speaker = (Speaker) sender;
                SpeakerText text = new SpeakerText(users);
                ArrayList<Event> eventArrayList = new ArrayList<Event>();
                for (String eventName : speaker.getSchedule()) {
                    for (Event event : events) {
                        if (eventName.equals(event.getID())) {
                            eventArrayList.add(event);
                        }
                    }
                }
                text.messageAllAttendees(eventArrayList, message, currPerson);
            }
        }
        catch (NullPointerException n){
            System.out.println("Invalid User.");
        }
    }

}
