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

    public void run(){
        MessageSystem messageSystem = new MessageSystem(am, om, sm, username);
        System.out.println("Here are your messages:");
        String messages = messageSystem.readMessage(username);
        System.out.println(messages);

        System.out.println("To reply, Enter the username of the person you wish to respond to:");
        String receiver = messageSystem.userInput();

        System.out.println("Now enter the message you wish to send:");
        String message = messageSystem.userInput();

        messageSystem.createMessage(message, receiver);

        System.out.println("Enter anything to return to the main screen.");
        messageSystem.userInput();
    }
}
