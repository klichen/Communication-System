import java.sql.SQLOutput;
import java.util.Scanner;

public class AttendeeMainScreen {
    AttendeeSystem as;
    LoginType lt;
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;

    public AttendeeMainScreen(LoginType lt, AttendeeManager am, EventScheduler es, OrganizerManager om,
                              SpeakerManager sm){
        this.as = new AttendeeSystem(am, es, om, sm);
        this.lt = lt;
        this.am = am;
        this.om = om;
        this.sm = sm;
    }

    public void run(){
        String username = lt.getUsername();
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello " + username + ".");
        System.out.println("To do an action, please press the corresponding number:");
        System.out.println("1 - View your Schedule");
        System.out.println("2 - Register for an event");
        System.out.println("3 - Cancel your registration in an event");
        System.out.println("4 - Add a contact to your contact list");
        System.out.println("5 - Send a message to a contact");
        System.out.println("6 - View previous messages");
        System.out.println("7 - Log out");

        String response = scan.nextLine();
        scan.close();

        // returns schedule of user
        switch (response) {
            case "1":
                System.out.println(this.as.getSchedule(username));

                break;
            // if applicable adds an event to the users schedule, otherwise tells them they cannot
            case "2": {
                System.out.println("Please enter the id of the event you would like to register for: ");
                String eventID = this.as.readString();

                // adds the event
                if (this.as.canAddEvent(username, eventID)) {
                    this.as.addEvent(username, eventID);
                    System.out.println("You have successfully registered for event " + eventID);
                }
                // tells them event cannot be added
                else {
                    System.out.println("Sorry this action cannot be done.");
                }

                break;
            }
            // if applicable removes an event from the users schedule, otherwise tells them they cannot
            case "3": {
                System.out.println("Please enter the id of the event you would like to unregister for: ");
                String eventID = this.as.readString();

                // cancels the event
                if (this.as.canCancelEnrollment(username, eventID)) {
                    this.as.cancelEnrollment(username, eventID);
                    System.out.println("You have successfully cancelled your enrollment in event " + eventID);
                }
                // tells them event cannot be cancelled
                else {
                    System.out.println("Sorry this action cannot be done.");
                }

                break;
            }
            // adds a contact to contact list
            case "4": {
                System.out.println("Please enter the username of the contact you would like to add: ");
                String contactID = this.as.readString();
                
                // adds contact
                if(this.as.canAddContact(username, contactID)){
                    this.as.addContact(username, contactID);
                    System.out.println("You have successfully added a contact to your contact list.");
                }
                // tells them contact cannot be added
                else{
                    System.out.println("Sorry this action cannot be done.");
                }

                break;
            }
            // Sends a message to a contact
            case "5":{
                // AttendeeMessageScreen messageScreen = new AttendeeMessageScreen();
                // messageScreen.run();

                break;
            }
            // View previous messages
            case "6":{
                ReadMessageScreen messageScreen = new ReadMessageScreen(am, om, sm, lt);
                messageScreen.run();

                break;
            }
            // Log off
            case "7":{
                lt.logOut();
                //pass screen back to login screen
                break;
            }

        }



    }
}
