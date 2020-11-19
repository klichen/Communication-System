import java.io.*;
import java.util.*;

public class loadAndSave{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //private EventScheduler scheduler = new EventScheduler();
    //private LoginSystem login = new LoginSystem();

    // Load events from text file
    public void loadAll(EventScheduler scheduler, SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) {
        List<List<String>> arrEvents = new ArrayList<List<String>>();
        List<List<String>> arrLogins = new ArrayList<List<String>>();
        BufferedReader inputReader;
        //System.out.println("Enter file name to load from (.txt):");
        //String input = br.readLine();
        try {
            inputReader = new BufferedReader(new FileReader(new File("phase1/src/data.txt")));

            String line;
            // Load events
            line = inputReader.readLine();
            if(line.equalsIgnoreCase("Events")){
                while ((line = inputReader.readLine()) != null){
                    if(!line.isEmpty()){
                        ArrayList<String> tempEvents = new ArrayList<String>();
                        tempEvents.add(line);
                        arrEvents.add(tempEvents);
                    }
                    else{
                        break;
                    }
                }
            }
            // Load logins
            line = inputReader.readLine();
            if(line.equalsIgnoreCase("Logins")){
                while ((line = inputReader.readLine()) != null){
                    if(!line.isEmpty()){
                        ArrayList<String> tempLogins = new ArrayList<String>();
                        tempLogins.add(line);
                        arrLogins.add(tempLogins);
                    }
                    else{
                        break;
                    }
                }
            }
            inputReader.close();
            System.out.println("--Successfully Loaded File--");
        } catch (IOException e) {
            System.out.println("--Invalid file--");
        }
        for(List<String> i : arrEvents){
            for (String l : i){
                String[] splitText = l.split(",");
                boolean update = scheduler.updateEvents(splitText[0], splitText[1], Integer.valueOf(splitText[2]),
                        splitText[3]);//, splitText[4]);
                if(update){
                    speakerManager.createSpeaker(splitText[3], splitText[4]);
                }
            }
        }
        for(List<String> i : arrLogins){
            for (String l : i){
                String[] splitText = l.split(",");
                if(splitText[0].equalsIgnoreCase("speaker")){
                    if(!attendeeManager.getUsernameToAttendee().containsKey(splitText[1]) &&
                            !organizerManager.getUsernameToOrganizer().containsKey(splitText[1])){
                        speakerManager.createSpeaker(splitText[1], splitText[2]);
                    }
                }
                else if (splitText[0].equalsIgnoreCase("attendee")){
                    if(!speakerManager.getUsernameToSpeaker().containsKey(splitText[1]) &&
                            !organizerManager.getUsernameToOrganizer().containsKey(splitText[1])){
                        attendeeManager.createAttendee(splitText[1], splitText[2]);
                    }

                }
                else if (splitText[0].equalsIgnoreCase("organizer")){
                    if(!attendeeManager.getUsernameToAttendee().containsKey(splitText[1]) &&
                            !speakerManager.getUsernameToSpeaker().containsKey(splitText[1])){
                        organizerManager.createOrganizer(splitText[1], splitText[2]);
                    }
                }

            }
        }
        System.out.println(speakerManager.getAllSpeakers());
        System.out.println(attendeeManager.getAllAttendees());
        System.out.println(organizerManager.getAllOrganizers());
    }

    // Save events to text file
    public void saveAll(EventScheduler scheduler,  SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) throws IOException {
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        List<List<String>> convertedSpeakerLogins = new ArrayList<List<String>>();
        List<List<String>> convertedAttendeeLogins = new ArrayList<List<String>>();
        List<List<String>> convertedOrganizerLogins = new ArrayList<List<String>>();
        //System.out.println("Enter file name to save to (.txt):");
        //String input = br.readLine();
        BufferedWriter outputWriter;

        try {
            outputWriter = new BufferedWriter(new FileWriter(new File("phase1/src/saved.txt")));
            convertedEvents = scheduler.eventToString(speakerManager);
            convertedSpeakerLogins = speakerManager.loginToString();
            convertedAttendeeLogins = attendeeManager.loginToString();
            convertedOrganizerLogins = organizerManager.loginToString();

            // Write Events to txt file
            outputWriter.write("Events");
            outputWriter.newLine();
            for(List<String> i : convertedEvents){
                for(String l : i){
                    outputWriter.write(String.valueOf(l));
                }
                outputWriter.newLine();
            }
            outputWriter.newLine();
            // Write logins to txt file
            outputWriter.write("Logins");
            outputWriter.newLine();
            for(List<String> i : convertedSpeakerLogins){
                for(String l : i){
                    outputWriter.write(String.valueOf(l));
                }
                outputWriter.newLine();
            }
            for(List<String> i : convertedAttendeeLogins){
                for(String l : i){
                    outputWriter.write(String.valueOf(l));
                }
                outputWriter.newLine();
            }
            for(List<String> i : convertedOrganizerLogins){
                for(String l : i){
                    outputWriter.write(String.valueOf(l));
                }
                outputWriter.newLine();
            }
            outputWriter.close();
            System.out.println("--File Saved Successfully--");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
