import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        loadAndSave las = new loadAndSave();
        EventScheduler scheduler = new EventScheduler();
        //LoginSystem login = new LoginSystem();
        //PersonManager personManager = new PersonManager();
        SpeakerManager speakerManager = new SpeakerManager();
        AttendeeManager attendeeManager = new AttendeeManager();
        OrganizerManager organizerManager = new OrganizerManager();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean userInputCorrect = true;
        do {
            System.out.println("Enter load/save or done:");
            String input = br.readLine();
            //System.out.println(input);
            if(input.equals("load")){
                las.loadAll(scheduler, speakerManager,
                        attendeeManager, organizerManager);
            }
            else if(input.equals("save")){
                las.saveAll(scheduler, speakerManager,
                        attendeeManager, organizerManager);
            }
            else if (input.equals("done")){
                userInputCorrect = false;
            }
        } while (userInputCorrect);


    }
}
