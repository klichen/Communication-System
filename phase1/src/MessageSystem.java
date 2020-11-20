import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageSystem {
    private final AttendeeManager am;
    private final OrganizerManager om;
    private final SpeakerManager sm;
    private final String username;

    public MessageSystem(AttendeeManager am, OrganizerManager om, SpeakerManager sm, String username){
        this.am = am;
        this. om = om;
        this. sm = sm;
        this.username = username;
    }


    /**
     * Reads the keyboard input.
     * @return The keyboard input as a string.
     */
    public String userInput(){
        Scanner scan = new Scanner(System.in);
        String m = scan.nextLine();
        return m;
    }

    /**
     * Calls the send message function and only requires a message and a receiver.
     *
     * @param message The message to be sent.
     * @param receiver The username of the recipient.
     */
    public void createMessage(String message, String receiver){
        this.sendMessage(message, receiver, username);
    }

    /**
     *
     * @param message
     * @param talks
     */
    public void createMessage(String message, List<String> talks){
        this.sendMessage(message, talks, username);
    }

    /**
     *
     * @return
     */
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

    /**
     * Returns all the messages sent to currPerson.
     *
     * @param currPerson The username of the user that is currently logged in.
     * @return A string of the messages sent to currPerson in the form
     *         sender1: message1, sender2: message2, ...
     */
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

    /**
     * Sends a message to other other user(s).
     *
     * @param message The message to be sent.
     * @param receiver The recipient of the message.
     * @param currPerson The sender of the message.
     */
    private void sendMessage(String message, String receiver, String currPerson){
        List<Attendee> attendees = am.getAllAttendees();
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
