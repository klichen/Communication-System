import java.util.ArrayList;
import java.util.List;

public class Vip extends Attendee{
    private List<String> contactList;
    private List<String> schedule;

    /**
     * Creates a VIP object that extends Attendee and initializes the VIPs contactList and schedule as an
     * empty ArrayList, sets variables isAttendee, isSpeaker and isOrganizer to false, while isVip is set to true.
     * @param username The VIP's username as a String
     * @param password The VIP's password as a String
     */
    public Vip(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<>();
        this.isSpeaker = false;
        this.isAttendee = false;
        this.isOrganizer = false;
        this.isVip = true;
        this.schedule = new ArrayList<>();
    }

}
