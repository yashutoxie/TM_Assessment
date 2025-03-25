/*Write a program to reverse the bits of an integer.
Example Input:
int num = 5; // Binary: 0000 0101
Expected Output:
Reversed Binary: 1010 0000 (Equivalent Decimal: 160)*/

public class Main {
    public static void main(String[] args) {
        int num = 5;
        int result = 0;
        for (int i = 0; i < 8; i++) { // i < n(no.of bits to display)
            result = result * 2 + (num & 1);
            num = num / 2;
        }
        System.out.println("Reversed Binary: " + Integer.toBinaryString(result));
    }
}

