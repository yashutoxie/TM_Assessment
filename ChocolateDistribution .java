
/*Chocolate Distribution Problem
Given an integer array arr of size n, where each element represents the number of chocolates a person receives, 
determine the minimum difference between the chocolates distributed to the person receiving the most chocolates 
and the one receiving the least. Your task is to return the smallest possible difference after distributing the 
chocolates such that the difference between the chocolates of any two people is minimized.

Example:

Input:

n: 5

arr: 10, 4, 12, 3, 1

m=3

Output: 3
*/

import java.util.Arrays;
import java.util.Scanner;

class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Enter m: ");
        int m = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter arr elements: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        // Arrays.sort(a);
        System.out.println("Minimum Distribution of Chocolate to each person: " + MinDistributionDiff(a, n, m));
        sc.close();

    }

    static int MinDistributionDiff(int[] a, int n, int m) {
        int res = Integer.MAX_VALUE;
        if (m == 0 || n == 0)
            return 0;
        for (int i = 0; i <= n - m; i++) {
            int diff = a[i + m - 1] - a[i]; // Difference between max and min in this subarray
            res = Math.min(res, diff);
        }

        return res;
    }
}
