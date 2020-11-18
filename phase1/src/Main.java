import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        loadAndSave las = new loadAndSave();
        EventScheduler scheduler = new EventScheduler();
        SpeakerManager speakerManager = new SpeakerManager();
        AttendeeManager attendeeManager = new AttendeeManager();
        OrganizerManager organizerManager = new OrganizerManager();

        las.loadAll(scheduler, speakerManager, attendeeManager, organizerManager);

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.run(attendeeManager, organizerManager, speakerManager);


        las.saveAll(scheduler, speakerManager, attendeeManager, organizerManager);
    }
}
