import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;


public abstract class Person<Public> implements Serializable{
    private String username;
    private String password;
    private Map<String, List> senderToMessages;
    private List storedMessages;
    protected boolean isSpeaker;
    protected boolean isAttendee;
    protected boolean isOrganizer;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
        this.senderToMessages = new HashMap<String, List>();
        this.storedMessages = new ArrayList();
    }

    // returns true if person is a speaker
    boolean isSpeakerType() {
        return this.isSpeaker;
    }

    // returns true if person is an attendee
    boolean isAttendeeType() {
        return this.isAttendee;
    }

    // returns true if person is an organizer
    boolean isOrganizerType() {
        return this.isOrganizer;
    }

    // returns true since person is a person
    boolean isPersonType() {
        return true;
    }

    // returns the Person's username
    public String getUsername(){
        return this.username;
    }

    // returns Person's password
    public String getPassword(){
        return this.password;
    }

    // returns messages that has been sent to Person
    public String getStoredMessages(){
        String delim = " ,";
        return String.join(delim, storedMessages);
    }

    // adds a message that was sent to Person to their storage
    // uses senders username
    public void addToMessageStorage(String messageContent, String messageSender){
        if (senderToMessages.containsKey(messageSender)){
            senderToMessages.get(messageSender).add(messageContent);
        } else {
            List messages = new ArrayList();
            messages.add(messageContent);
            senderToMessages.put(messageSender, messages);
        }
        storedMessages.add(messageSender +": " + messageContent);
    }
}

