import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        loadAndSave las = new loadAndSave();
        LoadAndSaveObjects laso = new LoadAndSaveObjects();
        SpeakerManager speakerManager = new SpeakerManager();
        AttendeeManager attendeeManager = new AttendeeManager();
        OrganizerManager organizerManager = new OrganizerManager();
        EventScheduler scheduler = new EventScheduler();

        //las.loadAll(scheduler, speakerManager, attendeeManager, organizerManager);
        laso.loadAll(scheduler, speakerManager, attendeeManager, organizerManager);

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.run(attendeeManager, organizerManager, speakerManager, scheduler);


        //las.saveAll(scheduler, speakerManager, attendeeManager, organizerManager);
        laso.saveAll(scheduler, speakerManager, attendeeManager, organizerManager);
    }
}
