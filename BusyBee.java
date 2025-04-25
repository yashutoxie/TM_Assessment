/*
 * BUSY BEE
 * Busy Bee is busy with her life and wants you to solve
 * 
 * one problem for her.
 * 
 * The problem is as follows:
 * 
 * You are given an array ‘A’ of size ‘N’ consisting of
 * 
 * integers.
 * 
 * You have to find the number of points (A[i], A[j]) and
 * 
 * ‘i’ < ‘j’. Such that their average is greater than or
 * 
 * equal to ‘K’.
 * Input:
 * 
 * 4
 * 
 * 5 1 3 4
 * 
 * 3
 * 
 * Output:
 * 
 * (5, 1) (5, 3) (5, 4) (3, 4)
 */

import java.util.Scanner;

public class BusyBee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter value of K:");
        int k = sc.nextInt();
        sc.close();
        System.out.print("Valid Pairs: ");
        findValidPairs(a, n, k);
    }

    public static void findValidPairs(int[] a, int n, int k) {
        int threshold = 2 * k;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] >= threshold) {
                    System.out.print("(" + a[i] + "," + a[j] + ") ");
                }
            }
        }
    }
}