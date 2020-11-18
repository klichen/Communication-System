import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizerManager{
    private ArrayList<Organizer> allOrganizers;
    private Map<String, Organizer> usernameToOrganizer;

    public OrganizerManager(){
        allOrganizers = new ArrayList<>();
        usernameToOrganizer = new HashMap<>();
    }

    // Create organizer accounts
    public boolean createOrganizer(String username, String password){
        if (!usernameToOrganizer.containsKey(username)) {
            Organizer organizer = new Organizer(username, password);
            allOrganizers.add(organizer);
            usernameToOrganizer.put(username, organizer);
            return true;
        } else {
            return false;
        }
    }

    // Get all organizers
    public ArrayList<Organizer> getAllOrganizers(){
        return allOrganizers;
    }

    // Get Map (String -> Organizer)
    public Map<String, Organizer> getUsernameToOrganizer() {
        return usernameToOrganizer;
    }

    // Check login for logging in
    public boolean checkLogin(String username, String password){
        for (Organizer user: allOrganizers){
            return user.getUsername().equals(username) && user.getPassword().equals(password);
        }
        return false;
    }

    // Convert all list of attendee to list of string
    public List<List<String>> loginToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        System.out.println(usernameToOrganizer);
        for (String i : usernameToOrganizer.keySet()){
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add("organizer" + "," + usernameToOrganizer.get(i).getUsername()
                    + "," + usernameToOrganizer.get(i).getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }
}
