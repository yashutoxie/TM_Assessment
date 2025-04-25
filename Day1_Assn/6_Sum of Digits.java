/*Implement a Java program to find the sum of digits of a given number using a while loop.
Example Input/Output:
Input: 1234
Output: 10
(Explanation: 1 + 2 + 3 + 4 = 10)
*/

public class Main {
    public static void main(String[] args) {
        int num = 1234;
        int sum = 0;
        while (num > 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }
        System.out.println("Sum of digits: " + sum);
    }
}
