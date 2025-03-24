/*	You are given a number N as input. Write a Java program that prints the multiplication table of N using all three types of loops (for, while, do-while). Additionally, modify the program to:
Print the multiplication table in reverse order (from N x 10 to N x 1) using a for loop.
Allow the user to specify a custom range (e.g., from start to end) for the multiplication table using a while loop.
Ensure the program asks the user if they want to generate another table and continues until the user chooses to stop (use a do-while loop).*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            System.out.print("Enter start value: ");
            int start = sc.nextInt();
            System.out.print("Enter end value: ");
            int end = sc.nextInt();

            int i = start;
            while (i <= end) {
                System.out.println(n + " x " + i + " = " + (n * i));
                i++;
            }

            System.out.print("Generate another table? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
