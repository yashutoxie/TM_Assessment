/*Write a program to check whether a number is power of two using bitwise operators.
Example Input/Output:
Input: 16
Output: Yes, it is a power of two

Input: 18
Output: No, it is not a power of two*/

public class Main {
    public static void main(String[] args) {
        int num = 16;
        boolean isPowerOfTwo = num > 0;
        while (num > 1) {
            if (num % 2 != 0) {
                isPowerOfTwo = false;
                break;
            }
            num /= 2;
        }
        System.out.println(isPowerOfTwo ? "Yes, it is a power of two" : "No, it is not a power of two");
    }
}
