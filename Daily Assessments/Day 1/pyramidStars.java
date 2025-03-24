/*Write a program to print a pattern using nested loops.
Example Input/Output:
Input: 5
Output:
    *
   ***
  *****
 *******
*********

*/

public class Main {
   public static void main(String[] args) {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" "); //spaces
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*"); //stars
            }
            System.out.println();
        }
    }
}

