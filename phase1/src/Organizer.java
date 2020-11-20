import java.util.ArrayList;

public class Organizer extends Person{
    /**
     * Creates an Organizer object that inherits from Person and sets variables isSpeaker and isAttendee to false,
     * while isOrganizer is set to true.
     * @param username String representing Organizer's username
     * @param password String representing Organizer's password
     */
    public Organizer(String username, String password) {
        super(username, password);
        this.isSpeaker = false;
        this.isAttendee = false;
        this.isOrganizer = true;
    }
    // Since Organizer has every Person in its contact list,
    // the methods that check if a certain Person is in its contact list
    // should just check that if it is a type Person then its in its contact list
    // instead of using method getContactList which are present in Speaker and Attendee
}
