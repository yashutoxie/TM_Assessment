/*
 * Parking Lot Problem
 * You are given a parking lot represented as a character array arr of size n,
 * where each element can either be 'S' (indicating an empty slot) or 'X'
 * (indicating an occupied slot). Find the maximum number of cars that can be
 * parked consecutively in the parking lot. Cars can only park in empty slots
 * and must park in consecutive empty slots.
 * 
 * Example:
 * 
 * Input:
 * 
 * n: 16
 * 
 * arr: XXXSSSXXSXXSSXXSXX
 * 
 * Output:
 * 
 * 3
 */

import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter arr: ");
        String arr = sc.nextLine();
        sc.close();

        System.out.println("Max Consecutive empty slots to park: " + park(arr));

    }

    public static int park(String a) {
        int cnt = 0, maxCnt = 0;
        for (char slot : a.toCharArray()) {
            if (slot == 'S') {
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
            } else {
                cnt = 0;
            }
        }

        return maxCnt;
    }
}