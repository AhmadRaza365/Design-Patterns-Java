// Chain Design Pattern
// Date: 22-12-2022

// Chain of Responsibility Design Pattern in terms of Authentication and Authorization


interface Authentication {
    public void authenticate();
}

class Login {
    public void login() {
        System.out.println("logging in");
    }
}

class Logout {
    public void logout() {
        System.out.println("logging out");
    }
}

class LoginAuthentication implements Authentication {
    private Login login;

    public LoginAuthentication(Login login) {
        this.login = login;
    }

    public void authenticate() {
        login.login();
    }
}

class LogoutAuthentication implements Authentication {
    private Logout logout;

    public LogoutAuthentication(Logout logout) {
        this.logout = logout;
    }

    public void authenticate() {
        logout.logout();
    }
}

class Button {
    private Authentication authentication;
    private String name;

    public Button(String btnname) {
        name = btnname;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public void click() {
        System.out.println(name + " clicked");
        authentication.authenticate();
    }
}

public class ChainDesignPattern {
    public static void main(String[] args) {
        Button loginButton = new Button("Login");
        Button logoutButton = new Button("Logout");

        Login login = new Login();
        Logout logout = new Logout();

        LoginAuthentication loginAuthentication = new LoginAuthentication(login);
        LogoutAuthentication logoutAuthentication = new LogoutAuthentication(logout);

        loginButton.setAuthentication(loginAuthentication);

        logoutButton.setAuthentication(logoutAuthentication);

        loginButton.click();
        logoutButton.click();
    }
}




