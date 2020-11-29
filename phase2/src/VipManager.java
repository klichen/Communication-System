import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VipManager {
    private Map<String, Vip> usernameToVip;
    private List<Vip> allVips;

    /**
     * Creates a VipManager object that initializes an empty ArrayList that will store all Vip objects and
     * it initializes an empty Hashmap that will store Vip usernames as the value and the corresponding Vip
     * object as the key.
     */
    public VipManager(){
        allVips = new ArrayList<>();
        usernameToVip = new HashMap<>();
    }

    /**
     * Creates a Vip account if the username does not already exist
     * @param username The Vip's username as a String
     * @param password The Vip's password as a String
     * @return A boolean returning true if the Vip account was created and false if it was not created
     */
    public boolean createVip(String username, String password){
        if (!usernameToVip.containsKey(username)) {
            Vip vip = new Vip(username, password);
            allVips.add(vip);
            usernameToVip.put(username, vip);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an Vip to allVips and to usernameToVip
     * @param a The Vip object to be added to allVips and usernameToVip
     */
    public void updateVipObjects(Vip a){
        allVips.add(a);
        usernameToVip.put(a.getUsername(), a);
    }

    /**
     * Returns the variable allVips
     * @return A List of all the Vips that exist
     */
    public List<Vip> getAllVips(){
        return allVips;
    }

    /**
     * Returns the variable usernameToVip
     * @return a Map pointing all the usernames of the Vips to its corresponding Vip object
     */
    public Map<String, Vip> getUsernameToVip() {
        return usernameToVip;
    }

    /**
     * Checks the username and password of the Vip who logs in to ensure that it is a real account
     * @param username The Vip's username as a String
     * @param password The Vip's password as a String
     * @return a boolean returning true if the login information exists and false if it does not
     */
    public boolean checkLogin(String username, String password){
        boolean valid = false;
        for (Vip user: allVips){
            if(user.getUsername().equals(username) && user.checkPassword(password)){
                valid = true;
            }
        }
        return valid;
    }

    /**
     * returns the Vip's list of contacts
     * @param username The Vip's username as a String
     * @return A List containing Vip's contacts usernames as Strings
     */
    public List<String> getContactList(String username){
        Vip vip = usernameToVip.get(username);
        return vip.getContactList();
    }

    /**
     * Checks whether a contact can be added to Vip's contact list by checking if they exist and if they are not
     * already on Vip's contact list
     * @param username The Vip's username as a String
     * @param contact The potential contact's username as a String
     * @return a boolean that returns true if contact can be added to Vip contact list and false if contact cannot
     * be added
     */
    public boolean canAddToContactList(String username, String contact){
        List<String> contactList = usernameToVip.get(username).getContactList();
        return !contactList.contains(contact);
    }

    /**
     * Adds a contact to Vip's contact list if the contact satisfies the conditions to be added
     * @param username The Vip's username as a String
     * @param contact The contact's username as a String
     */
    public void addToContactList(String username, String contact) {
        Vip vip = usernameToVip.get(username);
        if (canAddToContactList(username, contact)){
            vip.addToContact(contact);
        }
    }

    /**
     * Adds an event to the Vip's schedule
     * @param username The Vip's username as a String
     * @param eventID The ID of the event the Vip is signing up for
     */
    public void eventSignUp(String username, String eventID){
        Vip vip = usernameToVip.get(username);
        vip.addToSchedule(eventID);
    }

    /**
     * Removes an event from the Vip's schedule
     * @param username The Vip's username as a String
     * @param eventID The Id of the event the Vip is signing up for
     */
    public void eventCancel(String username, String eventID){
        Vip vip = usernameToVip.get(username);
        vip.removeFromSchedule(eventID);
    }

    /**
     * Returns the schedule of the Vip
     * @param username The Vip's username as a String
     * @return A List containing the ids of all the Events Vip has signed up for as a String
     */
    public List<String> getSchedule(String username){
        Vip vip = usernameToVip.get(username);
        return vip.getSchedule();
    }
}
