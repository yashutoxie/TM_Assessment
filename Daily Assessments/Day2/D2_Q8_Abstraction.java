/*Online Shopping System using Abstraction
Scenario:
You are designing an online shopping system where:
1.Product is an abstract class with an abstract method calculateDiscount().
2.Electronics and Clothing extend Product and provide custom discount logic.

Implement an abstract class with at least one abstract method.
Ensure different discount calculations for Electronics and Clothing.
Example Usage:
Product phone = new Electronics(50000);
Product shirt = new Clothing(2000);
System.out.println(phone.calculateDiscount()); // 10% discount for electronics
System.out.println(shirt.calculateDiscount()); // 5% discount for clothing */


abstract class Product {
    protected double price;  
    
    public Product(double price) {
        this.price = price;
    }
 
    public abstract double calculateDiscount();
 
    public void displayPrice() {
        System.out.println("Original Price: " + price);
        System.out.println("Discounted Price: " + (price - calculateDiscount()));
    }
}
 
class Electronics extends Product { 
    public Electronics(double price) {
        super(price);
    }
 
    @Override
    public double calculateDiscount() {
        return price * 0.10;  
    }
}
 
class Clothing extends Product { 
    public Clothing(double price) {
        super(price);
    }
 
    @Override
    public double calculateDiscount() {
        return price * 0.05; 
    }
}
 
public class Main {
    public static void main(String[] args) { 
        Product phone = new Electronics(50000); 
        Product shirt = new Clothing(2000);    
        
        System.out.println("Electronic Item (Phone):");
        phone.displayPrice();

        System.out.println("\nClothing Item (Shirt):");
        shirt.displayPrice();
    }
}
