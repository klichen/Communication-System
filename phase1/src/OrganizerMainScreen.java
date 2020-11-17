import java.sql.SQLOutput;
import java.util.Scanner;

public class OrganizerMainScreen {
    OrganizerSystem os;
    LoginType lt;

    public void run(){
        String username = lt.getUsername();
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello " + username + ".");
        System.out.println("To do an action, please press the corresponding number:");
        System.out.println("1 - Schedule an event (enter room into system)");
        System.out.println("2 - Create speaker account");
        System.out.println("3 - Cancel an event");
        System.out.println("4 - Send message to a specific contact");
        System.out.println("5 - Send message to all Speakers");
        System.out.println("6 - Send message to all Attendees");
        System.out.println("7 - Log out");

        String response = scan.nextLine();
        scan.close();

        switch (response) {
            case "1":
                // Schedule an event (enter room into system)
                System.out.println("Please enter the room number of your event: ");
                String roomNum = scan.nextLine();
                scan.close();

                System.out.println("Please enter the id of your event: ");
                String eventId = scan.nextLine();
                scan.close();

                System.out.println("Please enter the hour (military time) your event starts at: ");
                String timeStr = scan.nextLine();
                int time = Integer.parseInt(timeStr);
                scan.close();

                System.out.println("Please enter the username of the Speaker of this event: ");
                String eventSpeaker = scan.nextLine();
                scan.close();

                boolean eventCreated = os.createEvent(roomNum, eventId, time, eventSpeaker);
                if (eventCreated){
                    System.out.println("Your Event was created successfully.");
                } else {
                    System.out.println("This Event can not be created.");
                }
                break;
            case "2":
                // Create speaker account
                System.out.println("Please username of the Speaker account: ");
                String speakerUsername = scan.nextLine();
                scan.close();

                System.out.println("Please enter the password of the Speaker account: ");
                String speakerPass = scan.nextLine();
                scan.close();

                boolean speakerCreated = os.createSpeaker(speakerUsername, speakerPass);
                if (speakerCreated) {
                    System.out.println("The Speaker account was created successfully.");
                } else {
                    System.out.println("This Speaker account can not be created.");
                }
            case "3":
                // Cancel an event
                System.out.println("Please enter the id of your event: ");
                String eventId2 = scan.nextLine();
                scan.close();

                boolean eventCancelled = os.cancelEvent(eventId2);
                if (eventCancelled){
                    System.out.println("The Event was cancelled successfully.");
                } else {
                    System.out.println("The Event could not be cancelled.");
                }
            case "4":
                // Send message to a specific contact

            case "5":
                // Send message to all Speakers

            case "6":
                // Send message to all Attendees

            case "7":
                // Log out
        }
    }
}
