package ControllerLayer;

import UseCases.*;

import java.util.List;

public class SpeakerMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private VipManager vm;
    private String username;

    /**
     * Creates instance of ControllerLayer.SpeakerMessageScreen, the presenter class for the messaging hub of a speaker user.
     *
     * @param am       Instance of UseCases.AttendeeManager with loaded information
     * @param om       Instance of UseCases.OrganizerManager with loaded information
     * @param sm       Instance of UseCases.SpeakerManager with loaded information
     * @param vm       Instance of UseCases.VipManager with loaded information
     * @param username String of the username of current user logged in
     */
    public SpeakerMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, VipManager vm,
                                String username) {
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.vm =vm;
        this.username = username;
    }

    /**
     * Outputs the options that the current user can perform
     */
    public void run() {
        MessageSystem messageSystem = new MessageSystem(am, om, sm, vm, username);
        List<String> events = sm.getSchedule(username);

        System.out.println("This a list of the talk(s) in your schedule");
        for (String talks : events) {
            System.out.println(talks);
        }
        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Send a message to all attendees in all your talks or specific talks");
        System.out.println("2 - See and respond to your messages");
        System.out.println("3 - Exit");

        String choice = messageSystem.userInput();

        switch (choice) {
            case "1": {
                boolean sent = false;
                System.out.println("Enter \"All\" or the specific talk(s). When you are done listing, enter \"done\"");

                //call messageSystem readTalks
                List<String> talks = messageSystem.readList();

                System.out.println("Enter the message you wish to send:");

                //call messageSystem readMessage
                String message = messageSystem.userInput();
                sent = messageSystem.createMessage(message, talks);
                if (sent) {
                    System.out.println("Message(s) sent!");
                } else {
                    System.out.println("An error occurred. Message(s) not sent.");
                }
                break;
            }
            case "2": {
                ReadMessageScreen currMessages = new ReadMessageScreen(am, om, sm, vm, username);
                currMessages.run();
                break;
            }
            case "3": {
                break;
            }
        }
    }

}