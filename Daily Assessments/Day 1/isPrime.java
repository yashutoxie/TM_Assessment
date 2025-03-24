/*Implement a Java program that checks whether a given number is a prime number using a for loop.
Example Input/Output:
Input: 13
Output: Yes, 13 is a prime number

Input: 20
Output: No, 20 is not a prime number*/


public class Main {
    public static void main(String[] args) {
        int num = 13;
        boolean isPrime = num > 1;

        for (int i = 2; i * i <= num; i++) {
            if (num - (num / i) * i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(num + (isPrime ? " is a prime number" : " is not a prime number"));
    }
}
