/* Multi-Catch Block: E-Commerce System
Problem Statement:
Develop an order management system where users can place orders. Handle the following scenarios:
If a user enters a non-numeric quantity, throw a NumberFormatException.
If a product is out of stock, throw an OutOfStockException (custom exception).
If a product is not found, throw a ProductNotFoundException (custom exception).
Use a single catch block to handle multiple exceptions. */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter product file path: ");
            String filePath = scanner.nextLine();

            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            int stock = calculateStock(filePath, productName);

            if (quantity <= 0) {
                throw new NumberFormatException("Non-numeric or invalid quantity is not allowed.");
            }

            if (stock == -1) {
                throw new ProductNotFoundException("Product not found: " + productName);
            }

            if (stock < quantity) {
                throw new OutOfStockException("Stock is insufficient. Available: " + stock);
            }

            System.out.println("Order placed successfully for " + quantity + " units of " + productName);

        } catch (NumberFormatException | OutOfStockException | ProductNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred while reading the file.");
        } finally {
            scanner.close();
        }
    }

    static class OutOfStockException extends Exception {
        public OutOfStockException(String message) {
            super(message);
        }
    }

    static class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    public static int calculateStock(String filePath, String productName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String product = parts[0].trim();
                    int stock = Integer.parseInt(parts[1].trim());

                    if (product.equalsIgnoreCase(productName)) {
                        return stock;
                    }
                }
            }
        }
        return -1; // Product not found
    }
}
