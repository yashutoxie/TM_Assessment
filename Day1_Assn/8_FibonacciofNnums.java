/* Implement a program to generate the first N Fibonacci numbers using a do-while loop.
Example Input/Output:
Input: 5
Output: 0, 1, 1, 2, 3
*/

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int a = 0, b = 1, count = 0;

        do {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
            count++;
        } while (count < n);
    }
}

