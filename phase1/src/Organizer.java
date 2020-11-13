import java.util.ArrayList;

public class Organizer extends Person{
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

    //
}
