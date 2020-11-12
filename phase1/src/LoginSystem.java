import java.util.ArrayList;
import java.util.List;

public class LoginSystem {
    private List<Person> ListOfLogins;

    public LoginSystem(){
        ListOfLogins =  new ArrayList<Person>();
    }

    public void updateLogins(String type, String user, String pass){
        if(validLogin(user)){
            if(type.equalsIgnoreCase("attendee")){
                Attendee a = new Attendee(user, pass);
                ListOfLogins.add(a);
            }
            else if(type.equalsIgnoreCase("speaker")){
                Speaker s = new Speaker(user, pass);
                ListOfLogins.add(s);
            }
            else if(type.equalsIgnoreCase("organizer")){
                Organizer o = new Organizer(user, pass);
                ListOfLogins.add(o);
            }
        }
    }

    public boolean validLogin(String user){
        for(Person i : ListOfLogins){
            if(user.equals(i.getUsername())){
                return false;
            }
        }
        return true;
    }

    public List<Person> getLoginList(){
        return ListOfLogins;
    }

    public List<List<String>> loginToString(){
        List<List<String>> convertedEvents = new ArrayList<List<String>>();
        for (Person i : ListOfLogins){
            String type = "";
            if(i.isSpeakerType()){
                type = "speaker";
            }
            else if (i.isAttendeeType()){
                type = "attendee";
            }
            else if (i.isOrganizerType()){
                type = "organizer";
            }
            List<String> tempConvert = new ArrayList<String>();
            tempConvert.add(type + "," + i.getUsername() + "," + i.getPassword());
            convertedEvents.add(tempConvert);
        }
        return convertedEvents;
    }
}
