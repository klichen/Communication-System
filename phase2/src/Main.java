import ControllerLayer.LoginType;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        ControllerLayer.loadAndSave las = new ControllerLayer.loadAndSave();
//        ControllerLayer.LoadAndSaveObjects laso = new ControllerLayer.LoadAndSaveObjects();
//        UseCases.SpeakerManager speakerManager = new UseCases.SpeakerManager();
//        UseCases.AttendeeManager attendeeManager = new UseCases.AttendeeManager();
//        UseCases.OrganizerManager organizerManager = new UseCases.OrganizerManager();
//        UseCases.EventScheduler scheduler = new UseCases.EventScheduler();
//        UseCases.VipManager vp = new UseCases.VipManager();

        /*
        * In case allObjects.txt becomes corrupted you can re-download the file OR
        * uncomment out las.loadall... and comment out laso.loadall... and run the
        * program and just press enter until the program finishes. This will remake
        * allObjects.txt
        *
        * Once this is done comment out las.loadall... again and uncomment laso.loadall...
        * The program should work fine now.
        * */
        //las.loadAll(scheduler, speakerManager, attendeeManager, organizerManager, vp);
//        laso.loadAll(scheduler, speakerManager, attendeeManager, organizerManager, vp);

        LoginType loginType = new LoginType();
        loginType.run();

//        ControllerLayer.LoginScreen loginScreen = new ControllerLayer.LoginScreen();
//        loginScreen.run(attendeeManager, organizerManager, speakerManager, scheduler, vp);

//        laso.saveAll(scheduler, speakerManager, attendeeManager, organizerManager, vp);
    }
}
