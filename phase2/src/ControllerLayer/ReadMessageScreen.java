package ControllerLayer;

import GUI.ListScreenInterface;
import GUI.MessagesScreen;
import UseCases.*;
import ControllerLayer.*;
import java.util.ArrayList;
import java.util.List;

public class ReadMessageScreen{
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private VipManager vm;
    private String username;

    /**
     * The constructor for ReadMessageScreen. It takes 4 parameters.
     *
     * @param am       The AttendeeManager object that contains information from the file.
     * @param om       The OrganizerManager object that contains information from the file.
     * @param sm       The SpeakerManager object that contains information from the file.
     * @param vm       The VipManager object that contains information from the file.
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

        for (Object message : messages) {
            System.out.println(message);
        }

        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Reply to a message");
        System.out.println("2 - Mark messages as unread");
        System.out.println("3 - Delete selected messages");
        System.out.println("4 - Archive selected messages");
        System.out.println("5 - View your sent messages");
        System.out.println("6 - Exit");

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
                System.out.println("Enter \"All\" or the number of the message. When you are done listing, enter \"done\" ");
                List<String> messageNums = messageSystem.readList();

                messageSystem.markUnread(username, messageNums);
                break;
            case "3":
                System.out.println("Enter \"All\" or the number of the message. When you are done listing, enter \"done\" ");
                List<String> messageNumbers = messageSystem.readList();

                messageSystem.deleteMessage(username, messageNumbers, false);
                break;
            case "4":
                System.out.println("Enter \"All\" or the number of the message. When you are done listing, enter \"done\" ");
                List<String> msgNums = messageSystem.readList();

                messageSystem.deleteMessage(username, msgNums, true);
                break;
            case "5":
                System.out.println("Here are the messages you've sent:");
                List<String> sentMsgs = messageSystem.seeSentMessages(username);

                for (Object msg : sentMsgs) {
                    System.out.println(msg);
                }
                break;
            case "6":
                break;
        }
    }
    public void showMessages(){
        MessageSystem messageSystem = new MessageSystem(am, om, sm, vm, username);
        List<String> usernames = new ArrayList<>();
        List<String> sentMsgs = messageSystem.seeSentMessages(username);
        List<String> reverseMsgs = new ArrayList<>();
        for(String msg:sentMsgs){
            int startIndex = msg.indexOf(".");
            int endIndex = msg.indexOf(":");
            usernames.add(0, msg.substring(startIndex + 1, endIndex));
            reverseMsgs.add(0, msg);
        }
        ListScreenInterface messageScreen = new MessagesScreen();
        messageScreen.display(usernames, reverseMsgs);
    }
}

