import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Map;

public class OrganizerManager{
    private ArrayList<Organizer> allOrganizers;
    private Map<String, Organizer> usernameToOrganizer;

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
}
