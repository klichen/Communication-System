import java.util.*;

public class OrganizerManager{
    private List<Organizer> allOrganizers;
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
    public List<Organizer> getAllOrganizers(){
        return allOrganizers;
    }

    // Get Map (String -> Organizer)
    public Map<String, Organizer> getUsernameToOrganizer() {
        return usernameToOrganizer;
    }

    // Check login for logging in
    public boolean checkLogin(String username, String password){
        boolean valid = false;
        for (Organizer user: allOrganizers){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                valid = true;
            }
        }
        return valid;
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

    public void updateOrganizerObjects(Organizer a){
        createOrganizer(a.getUsername(), a.getPassword());
    }
}
