/* Simulate an ATM withdrawal process where:
> The outer try block checks for network connectivity (simulated by throwing a NetworkException).
> The inner try block handles the actual withdrawal process, which may throw: 
o  InvalidPINException (if the PIN entered is incorrect).
o  InsufficientFundsException (if the balance is too low).
o  DailyLimitExceededException (if the user exceeds the withdrawal limit).
> Use nested try-catch blocks to ensure each error is handled separately, providing the user with clear error messages.
*/

import java.util.*;

 class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

 class NumberGenerator extends Thread {
    private final int[] numbers;
    private final Random random = new Random();

    public NumberGenerator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        try {
            System.out.println("Generating random numbers...");
            for (int i = 0; i < numbers.length; i++) {
                // Random numbers between -10 and 100
                numbers[i] = random.nextInt(111) - 10; 
                System.out.println("Generated: " + numbers[i]);
                Thread.sleep(500);  
            }
        } catch (InterruptedException e) {
            System.err.println("Number generation thread interrupted.");
        } finally {
            System.out.println("Number generation thread completed.");
        }
    }
}
 
class SquareRootCalculator extends Thread {
    private final int[] numbers;

    public SquareRootCalculator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        try {
            System.out.println("\nCalculating square roots...");
            for (int number : numbers) {
                if (number < 0) {
                    throw new NegativeNumberException("Negative number found: " + number);
                }
                System.out.println("Square root of " + number + " is " + Math.sqrt(number));
                Thread.sleep(500);  
            }
        } catch (NegativeNumberException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Square root calculation thread interrupted.");
        } finally {
            System.out.println("Square root calculation thread completed.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        NumberGenerator generator = new NumberGenerator(numbers);
        SquareRootCalculator calculator = new SquareRootCalculator(numbers);

        generator.start();
        
        try {
            generator.join();  
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted during join.");
        }

        calculator.start();

        try {
            generator.join();
            calculator.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }

        System.out.println("Program completed.");
    }
}
