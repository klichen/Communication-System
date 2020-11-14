import java.util.List;

public class SpeakerMainScreen {
    private List<String> schedule;
    private SpeakerSystem ss = new SpeakerSystem();
    public SpeakerMainScreen(String username){
        System.out.println("The list of talks you are giving is:");
        schedule = ss.getSchedule(username);
        for(String i: schedule){
            System.out.println(i);
        }
    }
}
