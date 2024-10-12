package projectManager.controllers;

public class LoginController {
    public void login(String email, String password) {
        if (email.equals("admin") && password.equals("admin")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

}
