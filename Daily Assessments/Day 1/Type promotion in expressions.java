/*Write a program that demonstrates type promotion in expressions involving mixed data types (e.g., int, float, double, char).
Example Input:
int a = 5;
char b = 'A';
double c = 2.5;
Expected Output:
Result of (a + b * c) = <calculated_value> (167.5)
Explain how Java promotes types in the expression.
*/

public class Main {
    public static void main(String[] args) {
        int a = 5;
        char b = 'A';
        double c = 2.5;
        double result = a + b * c; 
        System.out.println("\nResult of (a + b * c) = " + result);
    }
}
