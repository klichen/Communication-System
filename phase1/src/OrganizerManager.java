import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Map;

public class OrganizerManager {
    private ArrayList<Organizer> allOrganizers;
    private Map<String, Organizer> usernameToOrganizer;

    // Get map (username -> Organizer object)
    public Map<String, Organizer> getUsernameToOrganizer() {
        return usernameToOrganizer;
    }

    // Create organizer accounts
    public void createOrganizer(String username, String password){
        Organizer organizer = new Organizer(username, password);
        allOrganizers.add(organizer);
        usernameToOrganizer.put(username, organizer);
    }

    // Get all organizers
    public ArrayList<Organizer> getAllOrganizers(){
        return allOrganizers;
    }
}
