import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonManager {
    protected ArrayList<Person> allPersons;

    protected Map<String, Person> usernameToPerson;

    public PersonManager(){
    }

    // Update logins from textfile
    public void updateLogins(String type, String user, String pass) {
        if(!usernameToPerson.containsKey(user)){
            if (type.equalsIgnoreCase("speaker")) {
                createSpeaker(user, pass);
            } else if (type.equalsIgnoreCase("attendee")) {
                createAttendee(user, pass);
            } else if (type.equalsIgnoreCase("organizer")) {
                createOrganizer(user, pass);
            }
        }

    }

    // Get Person object with a username
    public String getPersonType(String username, String password) {
        if (usernameToAttendee.containsKey(username) && usernameToAttendee.get(username).getPassword().equals(password)) {
            return "Attendee";
        } else if (usernameToOrganizer.containsKey(username) && usernameToOrganizer.get(username).getPassword().equals(password)) {
            return "Organizer";
        } else if (usernameToSpeaker.containsKey(username) && usernameToSpeaker.get(username).getPassword().equals(password)) {
            return "Speaker";
        } else {
            //System.out.println("This username does not exist.");
            return null;
        }
    }


    public List<List<String>> loginToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        System.out.println(usernameToPerson);
        for (String i : usernameToPerson.keySet()){
            String type = "";
            if(usernameToPerson.get(i).isSpeakerType()){
                type = "speaker";
            }
            else if (usernameToPerson.get(i).isAttendeeType()){
                type = "attendee";
            }
            else if (usernameToPerson.get(i).isOrganizerType()){
                type = "organizer";
            }
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add(type + "," + usernameToPerson.get(i).getUsername()
                    + "," + usernameToPerson.get(i).getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }
}
