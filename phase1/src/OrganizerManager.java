import java.util.*;

public class OrganizerManager{
    private List<Organizer> allOrganizers;
    private Map<String, Organizer> usernameToOrganizer;

    /**
     * Creates an OrganizerManager object and initializes allOrganizers as an empty ArrayList and
     * usernameToOrganizer as an empty HashMap.
     */
    public OrganizerManager(){
        allOrganizers = new ArrayList<>();
        usernameToOrganizer = new HashMap<>();
    }

    /**
     * Creates an Organizer object, if the username does not already exist.
     * @param username String representing Organizer's username
     * @param password String representing Organizer's password
     * @return boolean; true if Organizer object was created, false if it was not created
     */
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

    /**
     * Adds Organizer object to List allOrganizers, and Map usernameToOrganizer.
     * @param o Organizer object
     */
    public void updateOrganizerObjects(Organizer o){
        allOrganizers.add(o);
        usernameToOrganizer.put(o.getUsername(), o);
    }

    /**
     * Get the List allOrganizers.
     * @return List allOrganizers
     */
    public List<Organizer> getAllOrganizers(){
        return allOrganizers;
    }

    /**
     * Get the Map usernameToOrganizer.
     * @return Map usernameToOrganizer
     */
    public Map<String, Organizer> getUsernameToOrganizer() {
        return usernameToOrganizer;
    }

    /**
     * Checks if the username exists and if it's password is correct.
     * @param username String representing Organizer's username
     * @param password String representing Organizer's password
     * @return boolean; true if username exists and it's password is correct, false if otherwise.
     */
    public boolean checkLogin(String username, String password){
        boolean valid = false;
        for (Organizer user: allOrganizers){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                valid = true;
                break;
            }
        }
        return valid;
    }

}
