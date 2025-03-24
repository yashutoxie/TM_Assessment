/*Implement a Java program to swap two variables without using a third variable.
Example Input:
int a = 10, b = 20;
Expected Output:
Before Swap: a = 10, b = 20
After Swap: a = 20, b = 10
*/

public class Main {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("Before Swap: a = " + a + ", b = " + b);
        a = a ^ b; 
        b = a ^ b;
        a = a ^ b;
        System.out.println("After Swap: a = " + a + ", b = " + b);
    }
}
