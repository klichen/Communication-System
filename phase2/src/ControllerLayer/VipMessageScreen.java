package ControllerLayer;

import UseCases.AttendeeManager;
import UseCases.OrganizerManager;
import UseCases.SpeakerManager;
import UseCases.VipManager;
import java.util.List;

public class VipMessageScreen {
    private final AttendeeManager am;
    private final OrganizerManager om;
    private final SpeakerManager sm;
    private final VipManager vm;
    private final String username;

    /**
     * Creates instance of AttendeeMessageScreen, the presenter class for the messaging hub of an attendee user.
     *
     * @param am Instance of AttendeeManager with loaded information
     * @param om Instance of OrganizerManager with loaded information
     * @param sm Instance of SpeakerManager with loaded information
     * @param vm Instance of VipManager with loaded information
     * @param username String of the username of current user logged in
     */
    public VipMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, VipManager vm,
                            String username){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
        this.username = username;
    }

    /**
     * Outputs the options that the current user can perform
     *
     */
    public void run() {
        MessageSystem messageSystem = new MessageSystem(am, om, sm, vm, username);
        System.out.println("This is your contact list:");

        //need method from vip manager
        List<String> contacts = vm.getContactList(username);
        for (String contact: contacts){
            System.out.println(contact);
        }

        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Send a message to someone in your contact list");
        System.out.println("2 - See and respond to your messages");
        System.out.println("3 - Exit");

        String choice = messageSystem.userInput();

        switch(choice){
            case "1": {
                boolean sent = false;
                System.out.println("Enter the username of the person you want to message");
                String receiver = messageSystem.userInput();

                System.out.println("Enter the message");
                String message = messageSystem.userInput();

                sent = messageSystem.createMessage(message, receiver);
                if(sent){
                    System.out.println("Message sent!");
                }
                else{
                    System.out.println("An error occurred. Message not sent.");
                }
                break;
            }
            case "2":{
                ReadMessageScreen currMessages = new ReadMessageScreen(am, om, sm, vm, username);
                currMessages.run();
                break;
            }
            case "3":{
                break;
            }

        }
    }
}

