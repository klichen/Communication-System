package ControllerLayer;

import UseCases.*;
import ControllerLayer.*;

import java.util.List;

public class ReadMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private VipManager vm;
    private String username;

    /**
     * The constructor for ControllerLayer.ReadMessageScreen. It takes 4 parameters.
     * @param am The UseCases.AttendeeManager object that contains information from the file.
     * @param om The UseCases.OrganizerManager object that contains information from the file.
     * @param sm The UseCases.SpeakerManager object that contains information from the file.
     * @param vm The UseCases.VipManager object that contains information from the file.
     * @param username The username of the logged-in/current user.
     */
    public ReadMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, VipManager vm,
                             String username) {
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
        this.username = username;
    }

    /**
     * Prints the texts for the user to see, and takes in inputs accordingly.
     */
    public void run() {
        boolean successful = true;
        MessageSystem messageSystem = new MessageSystem(am, om, sm, vm, username);
        System.out.println("Here are your messages:");

        List messages = messageSystem.readMessage(username);

        for (Object message: messages) {
            System.out.println(message);
        }

        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Reply to a message");
        System.out.println("2 - Exit");

        String choice = messageSystem.userInput();

        switch (choice) {
            case "1":
                System.out.println("To reply, Enter the username of the person you wish to respond to:");
                String receiver = messageSystem.userInput();

                System.out.println("Now enter the message you wish to send:");
                String message = messageSystem.userInput();

                successful = messageSystem.createMessage(message, receiver);

                if (successful) {
                    System.out.println("Message sent!");
                } else {
                    System.out.println("Invalid User");
                }
                break;
            case "2":
                break;
        }


    }
}
