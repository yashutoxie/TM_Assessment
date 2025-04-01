/*Simulate an ATM withdrawal process where:
The outer try block checks for network connectivity (simulated by throwing a NetworkException).
The inner try block handles the actual withdrawal process, which may throw: 
oInvalidPINException (if the PIN entered is incorrect).
oInsufficientFundsException (if the balance is too low).
oDailyLimitExceededException (if the user exceeds the withdrawal limit).
Use nested try-catch blocks to ensure each error is handled separately, providing the user with clear error messages.*/

import java.util.Scanner;

// Custom Exception: Network not available
class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}

// Custom Exception: Incorrect PIN
class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

// Custom Exception: Insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom Exception: Daily withdrawal limit exceeded
class DailyLimitExceededException extends Exception {
    public DailyLimitExceededException(String message) {
        super(message);
    }
}

class ATM {
    private double balance;
    private int correctPIN;
    private final double dailyLimit = 50000.0;
    private boolean isNetworkAvailable;

    public ATM(double balance, int correctPIN, boolean isNetworkAvailable) {
        this.balance = balance;
        this.correctPIN = correctPIN;
        this.isNetworkAvailable = isNetworkAvailable;
    }

    // Simulate network check
    public void checkNetwork() throws NetworkException {
        if (!isNetworkAvailable) {
            throw new NetworkException("Network Error: Unable to connect. Please try again later.");
        }
    }

    // Process withdrawal
    public void withdraw(double amount, int enteredPIN) throws InvalidPINException, InsufficientFundsException, DailyLimitExceededException {
        if (enteredPIN != correctPIN) {
            throw new InvalidPINException("Invalid PIN: Please enter the correct PIN.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient Funds: Your balance is too low.");
        }

        if (amount > dailyLimit) {
            throw new DailyLimitExceededException("Daily Limit Exceeded: Max withdrawal limit is ₹" + dailyLimit);
        }

        balance -= amount;
        System.out.println("Withdrawal Successful! Amount: ₹" + amount);
        System.out.println("Remaining Balance: ₹" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(100000.0, 1234, true);
        Scanner scanner = new Scanner(System.in);

        try {
            atm.checkNetwork();
            System.out.println("Network Connected. Proceeding with withdrawal...");

            try {
                System.out.print("Enter your PIN: ");
                int enteredPIN = scanner.nextInt();

                System.out.print("Enter withdrawal amount: ₹");
                double amount = scanner.nextDouble();

                atm.withdraw(amount, enteredPIN);
            } catch (InvalidPINException | InsufficientFundsException | DailyLimitExceededException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } catch (NetworkException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using our ATM!");
            scanner.close();
        }
    }
}
