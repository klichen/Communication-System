import java.util.List;
import java.util.Scanner;

public class SpeakerSystem {
    // Controller class (gets input from user)
    SpeakerManager sm;

    public SpeakerSystem(SpeakerManager sm){
        this.sm = sm;
    }

    // Get list of talks they are giving (schedule)
    public List<String> getSchedule(String speakerUsername){
        return sm.getSchedule(speakerUsername);
    }
    public String readString(){
        String str;
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        return str;
    }
}
