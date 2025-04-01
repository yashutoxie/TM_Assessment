/*Using Inner Classes for Authentication
Scenario:
You are implementing an authentication system where:
1.Authenticator class contains a private inner class Validator.
2.Validator checks if a given password is correct.
3.Only Authenticator can create an instance of Validator.
Use a member inner class to encapsulate validation logic.
Example Usage:
Authenticator auth = new Authenticator();
auth.login("admin123"); // Output: Login Successful / Incorrect Password*/

// Authenticator Class (Outer Class)
class Authenticator {
    private final String correctPassword = "admin123";  

    // Private Inner Class  
    private class Validator { 
        private boolean isValid(String password) {
            return correctPassword.equals(password);  
        }
    }

    // Public method to authenticate user login
    public void login(String password) {
        // Create an instance of the private inner class
        Validator validator = new Validator();
        
        // Check if the password is correct
        if (validator.isValid(password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Incorrect Password.");
        }
    }
}
 
public class AuthenticationSystem {
    public static void main(String[] args) { 
        Authenticator auth = new Authenticator();
 
        auth.login("admin123"); // Output: Login Successful!
        auth.login("wrongPass"); // Output: Incorrect Password.
    }
}
