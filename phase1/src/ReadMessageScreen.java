public class ReadMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private String username;

    public ReadMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, String username){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.username = username;
    }

    /**
     * Prints the texts for the user to see, and takes in inputs accordingly.
     */
    public void run(){
        boolean successful = true;
        MessageSystem messageSystem = new MessageSystem(am, om, sm, username);
        System.out.println("Here are your messages:");
        String messages = messageSystem.readMessage(username);
        System.out.println(messages);

        System.out.println("To reply, Enter the username of the person you wish to respond to:");
        String receiver = messageSystem.userInput();

        System.out.println("Now enter the message you wish to send:");
        String message = messageSystem.userInput();

        successful = messageSystem.createMessage(message, receiver);

        if(successful) {
            System.out.println("Message sent!");
        }
        else{
            System.out.println("Invalid User");
        }
    }
}
