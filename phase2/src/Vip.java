import java.util.ArrayList;
import java.util.List;

public class Vip extends Attendee{
    private List<String> contactList;
    private List<String> schedule;

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
