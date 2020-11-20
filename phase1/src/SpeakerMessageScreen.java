import java.util.ArrayList;
import java.util.List;

public class SpeakerMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private String username;

    /**
     * Creates instance of SpeakerMessageScreen, the presenter class for the messaging hub of a speaker user.
     *
     * @param am Instance of AttendeeManager with loaded information
     * @param om Instance of OrganizerManager with loaded information
     * @param sm Instance of SpeakerManager with loaded information
     * @param username String of the username of current user logged in
     */
    public SpeakerMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, String username){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.username = username;
    }

    /**
     * Outputs the options that the current user can perform
     *
     */
    public void run(){
        MessageSystem messageSystem = new MessageSystem(am, om, sm, username);
        List<String> events = sm.getSchedule(username);

        System.out.println("This a list of the talk(s) in your schedule");
        for (String talks: events){
            System.out.println(talks);
        }
        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Send a message to all attendees in all your talks or specific talks");
        System.out.println("2 - See and respond to your messages");

        String choice = messageSystem.userInput();

        switch(choice){
            case "1":
                System.out.println("Enter \"All\" or the specific talk(s). When you are done listing, enter \"done\"");

                //call messageSystem readTalks
                List<String> talks = messageSystem.readTalks();

                System.out.println("Enter the message you wish to send:");

                //call messageSystem readMessage
                String message = messageSystem.userInput();
                messageSystem.createMessage(message, talks);
                break;
            case "2":
                ReadMessageScreen currMessages = new ReadMessageScreen(am, om, sm, username);
                currMessages.run();
                break;
        }
    }

}