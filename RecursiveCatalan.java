import java.util.Scanner;

public class RecursiveCatalan { // prints no. of catalan number mentioned
    public static long Catalan(int n) {
        int res = 0;

        // Base case
        if (n <= 0) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += Catalan(i) * Catalan(n - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num <= 0)
            System.out.println("0");
        else {
            for (int i = 0; i < num; i++) {
                long CatalanNo = Catalan(i);
                System.out.print(CatalanNo + " ");
            }
        }
        sc.close();
    }

}
