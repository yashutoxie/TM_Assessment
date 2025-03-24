/*A banking system requires a custom ATM withdrawal function:
Implement a method that dispenses cash in denominations of 100, 500, and 2000 rupees, minimizing the number of notes.
Ensure proper error handling if the amount is not a multiple of 100.
Example Input/Output:
Input: 3700
Output: 1 x 2000, 3 x 500, 2 x 100

*/

class Main {
    public static void withdraw(int amount) {
        if (amount % 100 != 0) {
            System.out.println("Invalid amount");
            return;
        }
        int[] notes = {2000, 500, 100};
        for (int note : notes) {
            int count = amount / note;
            amount %= note;
            if (count > 0) System.out.println(count + " x " + note);
        }
    }
    
    public static void main (String[] args) {
        int amount = 5000; 
        withdraw(amount);
    }
}
