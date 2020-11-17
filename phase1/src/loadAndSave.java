import java.io.*;
import java.util.*;

public class loadAndSave{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //private EventScheduler scheduler = new EventScheduler();
    //private LoginSystem login = new LoginSystem();

    // Load events from text file
    public void loadAll(EventScheduler scheduler, PersonManager personManager) throws IOException {
        List<List<String>> arrEvents = new ArrayList<List<String>>();
        List<List<String>> arrLogins = new ArrayList<List<String>>();
        BufferedReader inputReader;
        System.out.println("Enter file name to load from (.txt):");
        String input = br.readLine();
        try {
            inputReader = new BufferedReader(new FileReader(new File("phase1/src/" + input)));

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
                    personManager.updateLogins("speaker", splitText[3], splitText[4]);
                }
            }
        }
        for(List<String> i : arrLogins){
            for (String l : i){
                String[] splitText = l.split(",");
                personManager.updateLogins(splitText[0], splitText[1], splitText[2]);
            }
        }
        System.out.println(personManager.allPersons);
        System.out.println(personManager.usernameToPerson);
        System.out.println("MAP" + scheduler.getIdToEvent());
    }

    // Save events to text file
    public void saveAll(EventScheduler scheduler, PersonManager personManager) throws IOException {
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        List<List<String>> convertedLogins = new ArrayList<List<String>>();
        System.out.println("Enter file name to save to (.txt):");
        String input = br.readLine();
        BufferedWriter outputWriter;

        try {
            outputWriter = new BufferedWriter(new FileWriter(new File("phase1/src/" +input)));
            convertedEvents = scheduler.eventToString(personManager);
            convertedLogins = personManager.loginToString();

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
            for(List<String> i : convertedLogins){
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
