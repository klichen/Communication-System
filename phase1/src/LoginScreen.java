import java.util.List;

public class LoginScreen {

    private List<Person> users;
    public LoginScreen(List<Person> logins){
        users = logins;
    }

    public void run(){
        System.out.println("Enter username");
        LoginType login = new LoginType();
        login.readUsername();
        System.out.println("Enter password");
        login.readPassword();
        login.checkLogin(users);
    }
}
