import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        loadAndSave las = new loadAndSave();
        EventScheduler scheduler = new EventScheduler();
        LoginSystem login = new LoginSystem();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean userInputCorrect = true;
        do {
            System.out.println("Enter load/save or done:");
            String input = br.readLine();
            //System.out.println(input);
            if(input.equals("load")){
                las.loadAll(scheduler, login);
            }
            else if(input.equals("save")){
                las.saveAll(scheduler, login);
            }
            else if (input.equals("done")){
                userInputCorrect = false;
            }
        } while (userInputCorrect);


    }
}
