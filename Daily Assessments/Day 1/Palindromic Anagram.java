/*
Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.

Input Format
A single line which contains the input string.
*/
import java.util.*;
public class Main{
    public static void main (String[] args) {
        String s = "abababa";
        String res = canFormPalindrome(s);
        System.out.println(res);
    }
    private static String canFormPalindrome(String s){
        HashMap<Character, Integer> cnt = new HashMap<>();
        for(char c : s.toCharArray()){
            int f = cnt.getOrDefault(c, 0) + 1;
            cnt.put(c, f);
        }
        System.out.println(cnt.toString());
        int oddC = 0;
        for(int c : cnt.values()){
            if(c % 2 != 0) oddC++;
            if(oddC > 1) return "No";
        }
        return"Yes";
    }
}

/* Output: Yes*/
