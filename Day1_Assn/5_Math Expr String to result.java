/*	Write a Java program to evaluate a mathematical expression given as a string and return the result.
Example Input:
Input: "10 + 2 * 6"
Output: 22

Input: "100 * (2 + 12) / 14"
Output: 100*/


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String expression = "100 * (2 + 12) / 14";
        System.out.println("Result: " + evaluate(expression));
    }

    static int evaluate(String expr) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
             
            if (ch == ' ') continue;
             
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                values.push(num);
                i--; 
            } 
             
            else if (ch == '(') {
                operators.push(ch);
            } 
             
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); 
            } 
             
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }
 
        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    // Define precedence of operators
    static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }
 
    static int applyOperation(char operator, int b, int a) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero error");
                }
                return a / b;
        }
        return 0;
    }
}
