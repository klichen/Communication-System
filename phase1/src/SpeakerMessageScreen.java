import java.util.ArrayList;

public class SpeakerMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private LoginType loginType;

    public SpeakerMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, LoginType loginType){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.loginType = loginType;
    }

    public void run(){
        MessageSystem messageSystem = new MessageSystem(am, om, sm, loginType);
        ArrayList<String> events = sm.getSchedule(loginType.getUsername());
        System.out.println("This a list of the talk(s) in your schedule");
        for (String talks: events){
            System.out.println(talks);
        }
        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Send a message to all attendees in all your talks or specific talks");
        System.out.println("2 - See and respond to your messages");
        System.out.println("3 - Exit Messages ");

        String choice = messageSystem.userInput();

        switch(choice){
            case "1": {
                System.out.println("Enter \"All\" or the specific talk(s). When you are done listing, enter \"done\"");

                //call messageSystem readTalks
                ArrayList<String> talks = messageSystem.readTalks();

                System.out.println("Enter the message you wish to send:");

                //call messageSystem readMessage
                String message = messageSystem.userInput();
                messageSystem.createMessage(message, talks);
            }
            case "2":{
                ReadMessageScreen currMessages = new ReadMessageScreen(am, om, sm, loginType);
                currMessages.run();
            }
            case "3":{
                //exit to main screen
            }

        }



    }

}