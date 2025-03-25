/* Constructor Chaining in a Banking System
Scenario:
You are designing a BankAccount class that should allow:
1.Default account creation (balance = 0).
2.Account creation with balance.
3.Account creation with balance and owner name.

Implement constructor chaining to avoid code repetition.
Example Usage:
BankAccount acc1 = new BankAccount();
BankAccount acc2 = new BankAccount(1000);
BankAccount acc3 = new BankAccount(5000, "John Doe");*/

class BankAcc {
    private double balance;
    private String name;

    public BankAcc() {
        this(0, "Unknown");
        System.out.println("Default Account With Balance = 0");
    }

    public BankAcc(double balance) {
        this(balance, "Unknown"); 
    }

    public BankAcc(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("Owner: " + name + ", Balance: " + balance);
    }
}

public class D2_Q5_Constructor_Chaining {
    public static void main(String[] args) {

        BankAcc ba = new BankAcc();
        BankAcc bb = new BankAcc(1000);
        BankAcc bc = new BankAcc(1390, "JD");
        ba.displayDetails();
        bb.displayDetails();
        bc.displayDetails();
    }

}
