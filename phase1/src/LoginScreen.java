public class LoginScreen {

    public void run(AttendeeManager am, OrganizerManager om, SpeakerManager sm, EventScheduler es){
        System.out.println("Enter username");
        LoginType login = new LoginType();
        login.readUsername();
        System.out.println("Enter password");
        login.readPassword();
        login.checkLogin(am, om, sm, es);
    }
}
