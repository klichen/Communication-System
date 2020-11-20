import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        loadAndSave las = new loadAndSave();
        SpeakerManager speakerManager = new SpeakerManager();
        AttendeeManager attendeeManager = new AttendeeManager();
        OrganizerManager organizerManager = new OrganizerManager();
        EventScheduler scheduler = new EventScheduler();

        las.loadAll(scheduler, speakerManager, attendeeManager, organizerManager);

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.run(attendeeManager, organizerManager, speakerManager, scheduler);


        las.saveAll(scheduler, speakerManager, attendeeManager, organizerManager);
    }
}
