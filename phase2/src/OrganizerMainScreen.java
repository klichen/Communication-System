import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLOutput;

public class OrganizerMainScreen {
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    OrganizerSystem os;
    SpeakerManager sm;
    VipManager vm;
    String username;

    /**
     * Create an OrganizerMainScreen object and sets its variables username, am, es, om, and sm to the ones passed in
     * the constructor.
     * @param username String representing a Person's username.
     * @param am AttendeeManager object
     * @param es EventScheduler object
     * @param om OrganizerManager object
     * @param sm SpeakerManager object
     * @param vm VipManager object
     */
    public OrganizerMainScreen(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                               SpeakerManager sm, VipManager vm){
        this.username = username;
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
        this.os = new OrganizerSystem(am, es, om, sm, vm);
    }

    /**
     * Prints the available actions to the screen, and takes in inputs accordingly.
     */
    public void run() {
        boolean logOut = false;
        while (!logOut) {

            System.out.println("Hello " + username + ".");
            System.out.println("To do an action, please press the corresponding number:");
            System.out.println("1 - Schedule an event (enter room into system)");
            System.out.println("2 - Create Speaker account");
            System.out.println("3 - Create Attendee account");
            System.out.println("4 - Create VIP account");
            System.out.println("5 - Create Organizer account");
            System.out.println("6 - Cancel an event");
            System.out.println("7 - Send message");
            System.out.println("8 - Read messages received");
            System.out.println("9 - Log out");

            String response = os.readString();

            switch (response) {
                case "1":
                    // Schedule an event (enter room into system)
                    System.out.println("Please enter the room number of your event: ");
                    String roomNum = os.readString();
                    System.out.println("Please enter the id of your event: ");
                    String eventId = os.readString();
                    System.out.println("Please enter the hour (military time) your event starts at: ");
                    int time = os.readInt();
                    System.out.println("Please enter the number of Speakers that will be at this event: ");
                    int numSpeaker = os.readInt();
                    List<String> speakers = new ArrayList<>();
                    if(numSpeaker != 0){
                        while(numSpeaker > 0){
                            System.out.println("Please enter the username of Speaker " + numSpeaker + " of this " +
                                    "event:");
                            String eventSpeaker = os.readString();
                            speakers.add(eventSpeaker);
                            numSpeaker -= 1;
                        }
                    }
                    System.out.println("Please enter whether the event is VIP only or not ('true'/'false' input " +
                            "needed)");
                    boolean isVip = os.readBoolean();
                    System.out.println("Please enter the duration of this event: ");
                    int duration = os.readInt();
                    System.out.println("Please enter the maximum number of people allowed in this event: ");
                    int maxPeople = os.readInt();
                    boolean eventCreated = os.createEvent(roomNum, eventId, time, speakers, isVip, duration, maxPeople);
                    if (eventCreated) {
                        System.out.println("Your Event was created successfully.");
                    } else {
                        System.out.println("This Event can not be created.");
                    }
                    break;
                case "2":
                    // Create speaker account
                    System.out.println("Please username of the Speaker account: ");
                    String speakerUsername = os.readString();
                    System.out.println("Please enter the password of the Speaker account: ");
                    String speakerPass = os.readString();

                    boolean speakerCreated = os.createSpeaker(speakerUsername, speakerPass);
                    if (speakerCreated) {
                        System.out.println("The Speaker account was created successfully.");
                    } else {
                        System.out.println("This Speaker account can not be created.");
                    }
                    break;
                case "3":
                    // Create Attendee account
                    System.out.println("Please username of the Attendee account: ");
                    String attendeeUsername = os.readString();
                    System.out.println("Please enter the password of the Attendee account: ");
                    String attendeePass = os.readString();

                    boolean attendeeCreated = os.createAttendee(attendeeUsername, attendeePass);
                    if (attendeeCreated) {
                        System.out.println("The Attendee account was created successfully.");
                    } else {
                        System.out.println("This Attendee account can not be created.");
                    }
                    break;
                case "4":
                    // Create VIP account
                    System.out.println("Please username of the VIP account: ");
                    String vipUsername = os.readString();
                    System.out.println("Please enter the password of the VIP account: ");
                    String vipPass = os.readString();

                    boolean vipCreated = os.createVip(vipUsername, vipPass);
                    if (vipCreated) {
                        System.out.println("The VIP account was created successfully.");
                    } else {
                        System.out.println("This VIP account can not be created.");
                    }
                    break;
                case "5":
                    // Create Organizer account
                    System.out.println("Please username of the Organizer account: ");
                    String organizerUsername = os.readString();
                    System.out.println("Please enter the password of the Organizer account: ");
                    String organizerPass = os.readString();

                    boolean organizerCreated = os.createOrganizer(organizerUsername, organizerPass);
                    if (organizerCreated) {
                        System.out.println("The Organizer account was created successfully.");
                    } else {
                        System.out.println("This Organizer account can not be created.");
                    }
                    break;
                case "6":
                    // Cancel an event
                    System.out.println("Please enter the id of your event: ");
                    String eventId2 = os.readString();

                    boolean eventCancelled = os.cancelEvent(eventId2);
                    if (eventCancelled) {
                        System.out.println("The Event was cancelled successfully.");
                    } else {
                        System.out.println("The Event could not be cancelled.");
                    }
                    break;
                case "7":
                    // Send message
                    OrganizerMessageScreen oMsg = new OrganizerMessageScreen(username, am, om, sm, vm);
                    oMsg.run();
                    break;
                case "8":
                    // Read messages received
                    ReadMessageScreen messageScreen = new ReadMessageScreen(am, om, sm, vm, username);
                    messageScreen.run();
                    break;

                case "9":
                    // Log out
                    logOut = true;
            }
        }
    }
}
