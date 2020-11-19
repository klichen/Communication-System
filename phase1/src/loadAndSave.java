import java.io.*;
import java.util.*;

public class loadAndSave{

    /**
     * Method to load all events and users login that are stored in the txt file to the program
     *
     * @param scheduler Instance of scheduler in order to add the loaded events
     * @param speakerManager Instance of SpeakerManager in order to add the list of speakers
     * @param attendeeManager Instance of AttendeeManager in order to add the list of attendees
     * @param organizerManager Instance of OrganizerManager in order to add the list of organizers
     */
    public void loadAll(EventScheduler scheduler, SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) {
        List<List<String>> arrEvents = new ArrayList<List<String>>();
        List<List<String>> arrLogins = new ArrayList<List<String>>();
        BufferedReader inputReader;

        try {
            inputReader = new BufferedReader(new FileReader(new File("phase1/src/data.txt")));

            String line;
            // Load events
            line = inputReader.readLine();
            if(line.equalsIgnoreCase("Events")){
                while ((line = inputReader.readLine()) != null){
                    if(!line.isEmpty()){
                        List<String> tempEvents = new ArrayList<String>();
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
                        List<String> tempLogins = new ArrayList<String>();
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
        updateEvents(arrEvents, scheduler, speakerManager);
        updateLogins(arrLogins, attendeeManager, organizerManager, speakerManager);
    }

    /**
     * Helper method to add the generated events and its speaker from the txt file to EventScheduler
     *
     * @param arrEvents Current list of events loaded
     * @param scheduler Instance of EventScheduler in order to access its methods
     * @param speakerManager Instance of SpeakerManager in order to update the list of speakers
     */
    public void updateEvents(List<List<String>> arrEvents, EventScheduler scheduler,
                             SpeakerManager speakerManager){
        for(List<String> i : arrEvents){
            for (String l : i){
                String[] splitText = l.split(",");
                boolean update = scheduler.updateEvents(splitText[0], splitText[1], Integer.valueOf(splitText[2]),
                        splitText[3]);
                if(update){
                    speakerManager.createSpeaker(splitText[3], splitText[4]);
                }
            }
        }
    }

    /**
     * Helper method to add the generated logins from the txt file to its respective type
     * (Attendee, Organizer or Speaker)
     *
     * @param arrLogins Current list of logins loaded
     * @param attendeeManager Instance of AttendeeManager in order to update the list of attendees
     * @param organizerManager Instance of OrganizerManager in order to update the list of organizers
     * @param speakerManager Instance of SpeakerManager in order to update the list of speakers
     */
    public void updateLogins(List<List<String>> arrLogins, AttendeeManager attendeeManager,
                              OrganizerManager organizerManager, SpeakerManager speakerManager){
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
    }

    /**
     * Method to save all events and users login that are stored in the program to a txt file
     *
     * @param scheduler Instance of scheduler in order to get the list of events
     * @param speakerManager Instance of SpeakerManager in order to access the list of speakers
     * @param attendeeManager Instance of AttendeeManager in order to access the list of attendees
     * @param organizerManager Instance of OrganizerManager in order to access the list of organizers
     */
    public void saveAll(EventScheduler scheduler,  SpeakerManager speakerManager,
                        AttendeeManager attendeeManager, OrganizerManager organizerManager) throws IOException {
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        List<List<String>> convertedSpeakerLogins = new ArrayList<List<String>>();
        List<List<String>> convertedAttendeeLogins = new ArrayList<List<String>>();
        List<List<String>> convertedOrganizerLogins = new ArrayList<List<String>>();

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
