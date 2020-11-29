public class LoginScreen {

    /**
     * Outputs requests for user to enter username and password. Starts hierarchy of program.
     *
     * @param am Instance of AttendeeManager with loaded information
     * @param om Instance of OrganizerManager with loaded information
     * @param sm Instance of SpeakerManager with loaded information
     * @param es String of the username of current user logged in
     */
    public void run(AttendeeManager am, OrganizerManager om, SpeakerManager sm, EventScheduler es){
        System.out.println("Enter username");
        LoginType login = new LoginType();
        login.readUsername();
        System.out.println("Enter password");
        login.readPassword();
        login.checkLogin(am, om, sm, es);
    }
}
