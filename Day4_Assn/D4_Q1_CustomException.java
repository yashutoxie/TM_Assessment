/*Advanced Banking System (Checked & Unchecked Exceptions)
Problem Statement:
Design a banking system that allows users to deposit and withdraw money. Implement exception handling for the following cases:
InsufficientBalanceException (Checked Exception): Raised when a user tries to withdraw more money than the available balance.
InvalidAmountException (Unchecked Exception): Raised when a user attempts to deposit or withdraw a negative amount.
Use proper try-catch blocks to handle these exceptions and display meaningful error messages.*/



import java.util.*;


class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}

class InvalidAmountException extends RuntimeException {
	public InvalidAmountException(String msg) {
		super(msg);
	}
}


class BankAccount {
	private double balance;

	public BankAccount(double balance) {
		if(balance < 0) {
			throw new InvalidAmountException("Initial Balance cannot be negative");
		}
		this.balance = balance;
	}

	public void deposit(double amount)  {
		if(amount <= 0) {
			throw new InvalidAmountException("Deposit amount must be positive.");
		}
		balance += amount;
		System.out.println("Deposited: " + amount + " New Balance: " + balance);
	}


	public void withdraw(double amount) throws InsufficientBalanceException {
		if(amount > balance) {
			throw new InsufficientBalanceException("Balance is Insufficient than Amount to withdraw ");

		}
		balance -= amount;
		System.out.println("Withdrawn" + amount +" New Balance: " + balance);
	}

	public void displayBalance() {
		System.out.println("Current Balance: " + balance);
	}
}


// Main class to simulate the advanced banking system
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			// Initialize account with starting balance
			System.out.print("Enter initial balance: ");
			double initialBalance = sc.nextDouble();
			BankAccount account = new BankAccount(initialBalance);

			while (true) {
				System.out.println("\nOptions: 1. Deposit  2. Withdraw  3. Check Balance  4. Exit");
				System.out.print("Choose an option: ");
				int option = sc.nextInt();

				switch (option) {
				case 1: // Deposit
					System.out.print("Enter deposit amount: ");
					double depositAmount = sc.nextDouble();
					account.deposit(depositAmount);
					break;

				case 2: // Withdraw
					System.out.print("Enter withdrawal amount: ");
					double withdrawAmount = sc.nextDouble();
					try {
						account.withdraw(withdrawAmount);
					} catch (InsufficientBalanceException e) {
						System.out.println("Error: " + e.getMessage());
					}
					break;

				case 3: // Check Balance
					account.displayBalance();
					break;

				case 4: // Exit
					System.out.println("Exiting Banking System. Thank you!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid option. Please choose again.");
				}
			}
		} catch (InvalidAmountException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close(); 
		}
	}
}
