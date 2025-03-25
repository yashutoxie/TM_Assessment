/*Advanced Banking System (Checked & Unchecked Exceptions)
Problem Statement:
Design a banking system that allows users to deposit and withdraw money. Implement exception handling for the following cases:
InsufficientBalanceException (Checked Exception): Raised when a user tries to withdraw more money than the available balance.
InvalidAmountException (Unchecked Exception): Raised when a user attempts to deposit or withdraw a negative amount.
Use proper try-catch blocks to handle these exceptions and display meaningful error messages.*/

import java.util.*;
 
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Unchecked Exception: Thrown for invalid deposit/withdraw amounts
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
} 
class BankAccount {
    private double balance;
 
    public BankAccount(double balance) {
        if (balance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative.");
        }
        this.balance = balance;
    }
 
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
    }

    // throws checked exception
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Available: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount + " | Remaining Balance: ₹" + balance);
    }
 
    public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class Main{
    public static void main (String[] args) throws InsufficientBalanceException, InvalidAmountException{
        BankAccount ba = new BankAccount(70000);
        ba.deposit(1000);
        ba.withdraw(90000);
    }
}
