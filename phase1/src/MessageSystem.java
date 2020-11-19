import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageSystem {
    private final AttendeeManager am;
    private final OrganizerManager om;
    private final SpeakerManager sm;
    private final LoginType loginType;

    public MessageSystem(AttendeeManager am, OrganizerManager om, SpeakerManager sm, LoginType loginType){
        this.am = am;
        this. om = om;
        this. sm = sm;
        this.loginType =loginType;
    }

    public String userInput(){
        Scanner scan = new Scanner(System.in);
        String m = scan.nextLine();
        return m;
    }

    public void createMessage(String message, String receiver){
        this.sendMessage(message, receiver, loginType.getUsername());
    }

    public void createMessage(String message, List<String> talks){
        this.sendMessage(message, talks, loginType.getUsername());
    }

    public List<String> readTalks(){
        Scanner scan = new Scanner(System.in);
        String e = "";
        List<String> events = new ArrayList<>();
        while(!e.equals("done")){
            e = scan.nextLine();
            events.add(e);
        }
        events.remove("done");
        return events;
    }

    public String readMessage(String currPerson) {
        List<Attendee> attendees = am.getAllAttendees();
        List<Organizer> organizers = om.getAllOrganizers();
        List<Speaker> speakers = sm.getAllSpeakers();

        ReadMessageManager readMessageManager = new ReadMessageManager(currPerson);
        try {
            if (am.getUsernameToAttendee().containsKey(currPerson)) {
                readMessageManager.addUsers(attendees);
                return readMessageManager.readMessage();
            } else if (om.getUsernameToOrganizer().containsKey(currPerson)) {
                readMessageManager.addUsers(organizers);
                return readMessageManager.readMessage();
            } else if (sm.getUsernameToSpeaker().containsKey(currPerson)) {
                readMessageManager.addUsers(speakers);
                return readMessageManager.readMessage();
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            return "Current user is invalid";
        }
    }

    private void sendMessage(String message, String receiver, String currPerson){
        List<Attendee> attendees = am.getAllAttendees();
        List<Organizer> organizers = om.getAllOrganizers();
        List<Speaker> speakers = sm.getAllSpeakers();
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
                    if(am.getUsernameToAttendee().containsKey(receiver) ||
                            sm.getUsernameToSpeaker().containsKey(receiver)) {
                        text.messageSingleRecipient(message, currPerson, receiver);
                    }
                    else{
                        throw new NullPointerException();
                    }
                }
            } else if (am.getUsernameToAttendee().containsKey(currPerson)) {
                AttendeeText text = new AttendeeText();
                text.addPeopleToList(attendees);
                text.addPeopleToList(speakers);
                text.sendMessage(message, currPerson, receiver);
            }
        }
        catch (NullPointerException n){
            System.out.println("Invalid User.");
        }
    }

    private void sendMessage(String message, List<String> talks, String currPerson){
        List<Attendee> attendees = am.getAllAttendees();
        List<Organizer> organizers = om.getAllOrganizers();
        List<Speaker> speakers = sm.getAllSpeakers();
        try{
            if (sm.getUsernameToSpeaker().containsKey(currPerson)){
                SpeakerText st = new SpeakerText();
                st.addPeopleToList(attendees);
                st.messageAllAttendees(talks, message, currPerson);
            }
        }
        catch (NullPointerException n){
            System.out.println("Invalid User.");
        }
    }

}
