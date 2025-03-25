/*Secure User Data with Encapsulation
Scenario:
Your company needs a secure user management system where:
The User class has private fields (username, password).
Only getter for username, but no getter for password.
A setter for password that ensures it meets security criteria.

Implement proper access control using getters/setters.
Ensure password must be at least 8 characters long. */

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
            System.out.print("Pwd successfully set.\n");
        } else {
            System.out.print("Error: Pwd must be at least 8 characters long.");
        }
    }

    public String getName(String username) {
        return username;
    } 

    public void userDetails() {
        System.out.println("Username: " + username);
    }

}

public class D2_Q6_Encapsulation {
    public static void main(String[] args) {
        User u1 = new User("Yash", "Secure123");
        u1.userDetails();  
    }
}

    