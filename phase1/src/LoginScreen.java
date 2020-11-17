import java.util.List;

public class LoginScreen {

    public void run(PersonManager pManager){
        System.out.println("Enter username");
        LoginType login = new LoginType();
        login.readUsername();
        System.out.println("Enter password");
        login.readPassword();
        login.checkLogin(pManager);
    }
}
