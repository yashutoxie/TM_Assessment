import java.util.*;

public class Main{
public static boolean isValid(String expr) {
        Stack<Character> st = new Stack<Character>();
         for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            { 
                st.push(x);
                continue;
            }
            if (st.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = st.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = st.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
             case ']':
                check = st.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
        return st.isEmpty();
    }

        public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
		String s=in.nextLine();
		if(isValid(s)==true)
		System.out.println("True");
		else
		System.out.println("False");

        }
}
