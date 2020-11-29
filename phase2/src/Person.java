import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Person<Public> implements Serializable {
    private String username;
    private String password;
    private Map<String, List> senderToMessages;
    private List<String> storedMessages;
    protected boolean isSpeaker;
    protected boolean isAttendee;
    protected boolean isOrganizer;

    /**
     * Constructor for entity class that creates a Person object
     * @param username The Person's username as a String
     * @param password The Person's password as a String
     */
    public Person(String username, String password) {
        this.username = username;
        this.password = password;
        this.senderToMessages = new HashMap<>();
        this.storedMessages = new ArrayList<>();
    }

    /**
     * Returns whether the Person is a Speaker
     * @return a boolean that returns true if Person is a Speaker and false otherwise
     */
    boolean isSpeakerType() {
        return this.isSpeaker;
    }

    /**
     * Returns whether the Person is an Attendee
     * @return a boolean that returns true if Person is an Attendee and false otherwise
     */
    boolean isAttendeeType() {
        return this.isAttendee;
    }

    /**
     * Returns whether the Person is an Organizer
     * @return a boolean that returns true if Person is an Organizer and false otherwise
     */
    boolean isOrganizerType() {
        return this.isOrganizer;
    }

    /**
     * Returns whether a Person is a Person
     * always true
     * @return true as a Person is always a Person
     */
    boolean isPersonType() {
        return true;
    }

    /**
     * Returns the Person's username
     * @return The username of Person as a String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the Person's password
     * @return The password of Person as a String
     */
    public String getPassword() {
        return this.password;
    }

    // returns messages that has been sent to Person
//    public String getStoredMessages() {
//        String delim = " ,";
//        return String.join(delim, storedMessages);
//    }

    /**
     * Returns variable storedMessages
     * @return A List containing all the Messages Person has been sent as Strings
     */
    public List<String> getStoredMessagesList() {
        return this.storedMessages;
    }

    /**
     * Adds a message and it's sender to variable storedMessages and to senderToMessages
     * @param messageContent The message that was sent to Person as a String
     * @param messageSender The username of the Person who sent the message to Person as a String
     */
    public void addToMessageStorage(String messageContent, String messageSender) {
        if (senderToMessages.containsKey(messageSender)) {
            senderToMessages.get(messageSender).add(messageContent);
        } else {
            List<String> messages = new ArrayList<>();
            messages.add(messageContent);
            senderToMessages.put(messageSender, messages);
        }
        storedMessages.add(messageSender + ": " + messageContent);
    }
}

