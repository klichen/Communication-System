import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageSystem {
    private final AttendeeManager am;
    private final OrganizerManager om;
    private final SpeakerManager sm;
    private final VipManager vm;
    private final String username;

    /**
     * Constructor for controller class, reads user input and decides if messaging can be done
     *
     * @param am       Instance of AttendeeManager with loaded information
     * @param om       Instance of OrganizerManager with loaded information
     * @param sm       Instance of SpeakerManager with loaded information
     * @param vm       Instance of VipManager with loaded information
     * @param username String of the username of current user logged in
     */
    public MessageSystem(AttendeeManager am, OrganizerManager om, SpeakerManager sm, VipManager vm, String username) {
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
        this.username = username;
    }


    /**
     * Reads the keyboard input.
     *
     * @return The keyboard input as a string.
     */
    public String userInput() {
        Scanner scan = new Scanner(System.in);
        String m = scan.nextLine();
        return m;
    }

    /**
     * Calls the send message function and only requires a message and a receiver.
     *
     * @param message  The message to be sent.
     * @param receiver The username of the recipient.
     */
    public boolean createMessage(String message, String receiver) {
        if (am.getUsernameToAttendee().containsKey(receiver) ||
                sm.getUsernameToSpeaker().containsKey(receiver) ||
                om.getUsernameToOrganizer().containsKey(receiver) ||
                receiver.equals("All Speakers") ||
                receiver.equals("All Attendees")) {
            this.sendMessage(message, receiver, username);
            return true;
        }
        return false;
    }

    /**
     * Overloaded method: for speaker messaging
     *
     * @param message Content of the message being sent
     * @param talks   the talks that the speaker wants to send messages
     */
    public boolean createMessage(String message, List<String> talks) {
        boolean validTalks = true;

        if (talks.contains("All")) {
            List<String> allTalks = sm.getSchedule(username);
            this.sendMessage(message, allTalks, username);
        } else {
            for (String talk : talks) {
                if (!sm.getSchedule(username).contains(talk)) {
                    validTalks = false;
                }
            }
            if (validTalks) {
                this.sendMessage(message, talks, username);
            }
        }

        return validTalks;
    }

    /**
     * Reads multiple user inputs and adds them to a list
     *
     * @return A list containing each input from user
     */
    public List<String> readList() {
        Scanner scan = new Scanner(System.in);
        String e = "";
        List<String> events = new ArrayList<>();
        while (!e.equals("done")) {
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
     * sender1: message1, sender2: message2, ...
     */
    public List readMessage(String currPerson) {
        List<Attendee> attendees = am.getAllAttendees();
        List<Organizer> organizers = om.getAllOrganizers();
        List<Speaker> speakers = sm.getAllSpeakers();
        List<Vip> vips = vm.getAllVips();

        ReadMessageManager readMessageManager = new ReadMessageManager(currPerson);

        if (am.getUsernameToAttendee().containsKey(currPerson)) {
            readMessageManager.addUsers(attendees);
            return readMessageManager.readMessage();
        } else if (om.getUsernameToOrganizer().containsKey(currPerson)) {
            readMessageManager.addUsers(organizers);
            return readMessageManager.readMessage();
        } else if (sm.getUsernameToSpeaker().containsKey(currPerson)) {
            readMessageManager.addUsers(speakers);
            return readMessageManager.readMessage();
        } else if (vm.getUsernameToVip().containsKey(currPerson)) {
            readMessageManager.addUsers(vips);
            return readMessageManager.readMessage();
        } else {
            throw new NullPointerException();
        }

    }

    /**
     * Sends a message to other other user(s).
     *
     * @param message    The message to be sent.
     * @param receiver   The recipient of the message.
     * @param currPerson The sender of the message.
     */
    private void sendMessage(String message, String receiver, String currPerson) {
        List<Attendee> attendees = am.getAllAttendees();
        List<Speaker> speakers = sm.getAllSpeakers();
        if (om.getUsernameToOrganizer().containsKey(currPerson)) {
            OrganizerText text = new OrganizerText();
            ;
            if (receiver.equals("All Speakers")) {
                text.addPeopleToList(speakers);
                text.messageAllSpeakers(message, currPerson);
            } else if (receiver.equals("All Attendees")) {
                text.addPeopleToList(attendees);
                text.messageAllAttendees(message, currPerson);
            } else {
                text.addPeopleToList(attendees);
                text.addPeopleToList(speakers);
                if (am.getUsernameToAttendee().containsKey(receiver) ||
                        sm.getUsernameToSpeaker().containsKey(receiver)) {
                    text.messageSingleRecipient(message, currPerson, receiver);
                } else {
                    throw new NullPointerException();
                }
            }
        } else if (am.getUsernameToAttendee().containsKey(currPerson)) {
            AttendeeText text = new AttendeeText();
            text.addPeopleToList(attendees);
            text.addPeopleToList(speakers);
            text.sendMessage(message, currPerson, receiver);
        } else if (sm.getUsernameToSpeaker().containsKey(currPerson)) {
            SpeakerText text = new SpeakerText();
            text.addPeopleToList(attendees);
            text.respondAttendee(message, receiver, currPerson);
        }
    }

    private void sendMessage(String message, List<String> talks, String currPerson) {
        List<Attendee> attendees = am.getAllAttendees();
        if (sm.getUsernameToSpeaker().containsKey(currPerson)) {
            SpeakerText st = new SpeakerText();
            st.addPeopleToList(attendees);
            st.messageAllAttendees(talks, message, currPerson);
        }
    }
}
