/*Polymorphism (Method Overloading, Method Overriding, Constructor Chaining)
Q3: Payment System using Method Overloading
Scenario:

> pay(double amount): Pay using a default payment method.
> pay(double amount, String method): Pay using a specific method (e.g., "Credit Card", "UPI").
> pay(double amount, String method, int emiMonths): Pay using EMI with a duration.

> Implement method overloading for pay().
> Demonstrate different ways to pay.
Example Usage:
Payment p = new Payment();
p.pay(1000); // Default payment
p.pay(2000, "Credit Card");
p.pay(5000, "UPI", 12); */

class Payment {
    private double amount;
    private String method;
    private int emiMonths;

    public void pay(double amount) {
        System.out.println("default payment method.");
    }

    public void pay(double amount, String method) {
        System.out.println("Credit or UPI payment method");
    }

    public void pay(double amount, String method, int emiMonths) {
        System.out.println("EMI payment method.");
    }

}

public class D2_Q3_Polymorphism {
    public static void main(String[] args) {
        Payment p = new Payment();
        p.pay(1000);
        p.pay(1000, "Credit Card");
        p.pay(1000, "UPI", 12);
    }
}
