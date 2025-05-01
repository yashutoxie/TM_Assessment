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


/*Approach 2:Without Collections*/

import java.util.*;
public class Main
{
	private  static int idx;
	public static int evaluate(String expr) {
		idx = 0;
		return parseExpression(expr.toCharArray());
	}

	private static int parseExpression(char[] chars) {
		int n = 0, res = 0, sign = 1, lastVal = 0;
		char lastOp = '+';
		while(idx < chars.length) {
			char ch = chars[idx++];
			if(Character.isDigit(ch)) {
				n = n * 10 + ((ch - '0'));
			}
			if(ch == '(') {
				n = parseExpression(chars);
			}
			if((!Character.isDigit(ch) && ch != ' ' && ch != '(') || idx == chars.length ||ch == ')')
			{
				switch(lastOp) {
				case '+':
					res += lastVal;
					lastVal = n;
					break;
				case '-':
					res += lastVal;
					lastVal = -n;
					break;
				case '*':
					lastVal *= n;
					break;
				case '/':
					lastVal /= n;
					break;
				}
				if(ch == ')') break;
				lastOp = ch;
				n = 0;
			}
		}
		return res + lastVal;
	}

	public static void main(String[] args) {
		String expr1 = "10 + 2 * 6";
		String expr2 = "100 * ( 2 + 12) / 14";
		System.out.println(evaluate(expr1));
		System.out.println(evaluate(expr2));
	}
}
