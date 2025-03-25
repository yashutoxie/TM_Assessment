// ANGRY BIRDS
// There is a long wire along a straight line, which contains N bird nests at
// positions x1, x2, x3, ...xN.

// There are B (B <= N) birds, which becomes angry towards each other once put
// into a nest. To put the birds from hurting each other you want to assign
// birds to nests such that minimum distance between any two birds as large as
// possible. Find the largest minimum distance?I
// nput:
// 5
// 1 2 4 8 9
// 3
// Output:
// 3

import java.util.*; 
public class AngryBirds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter Number Of Birds: ");
        int b = sc.nextInt();
        int nests[] = new int[n];
        System.out.print("Enter nests positions: ");
        for (int i = 0; i < nests.length; i++) {
            nests[i] = sc.nextInt();
        }
        sc.close();
        int maxMinDist = largestMinDist(nests, b);
        System.out.println("Largest Minimum Distance: " + maxMinDist);

    }

    public static boolean canPlaceBirds(int nests[], int b, int minDist) {
        int bP = 1;
        int lP = nests[0];
        for (int i = 1; i < nests.length; i++) {
            if (nests[i] - lP >= minDist) {
                bP++;
                lP = nests[i];
                if (bP == b)
                    return true;

            }
        }

        return false;
    }

    public static int largestMinDist(int[] nests, int b) {
        Arrays.sort(nests);
        int l = 1, h = nests[nests.length - 1] - nests[0];
        int res = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (canPlaceBirds(nests, b, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return res;
    }
}