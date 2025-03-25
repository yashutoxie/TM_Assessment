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

class Authenticator {
	private final String correctPassword = "admin123";
	private class Validator {
		private boolean isValid(String password) {
			return correctPassword.equals(password);
		}
	}

	public void login(String password) {
		Validator validator = new Validator();

		if (validator.isValid(password)) {
			System.out.println("Login Successful!");
		} else {
			System.out.println("Incorrect Password.");
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Authenticator auth = new Authenticator();

		auth.login("admin123");
		auth.login("wrongPass"); //wrongPassword
	}
}
