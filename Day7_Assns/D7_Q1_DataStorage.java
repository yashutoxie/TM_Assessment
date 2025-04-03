import java.io.*;
import java.nio.file.*;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "users.txt";

    public Main() {
        File file = new File(FILE_NAME);
        try {
            if (file.createNewFile()) {
                System.out.println("users.txt created successfully!");
            }
        } catch (IOException e) {
            System.out.println("Error creating users.txt: " + e.getMessage());
        }
    }

    public void registerUser(User user) throws IOException {
        if (isUserExists(user.getEmail())) {
            System.out.println("User already exists with email: " + user.getEmail());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user.getUserData());
            writer.newLine();
            System.out.println("User registered successfully!");
        }
    }

    public boolean isUserExists(String email) throws IOException {
        Path path = Paths.get(FILE_NAME);
        if (!Files.exists(path)) return false;

        return Files.lines(path)
                .map(line -> line.split(",")[1])
                .anyMatch(existingEmail -> existingEmail.equalsIgnoreCase(email));
    }

    public Optional<User> searchUserByEmail(String email) throws IOException {
        Path path = Paths.get(FILE_NAME);
        if (!Files.exists(path)) return Optional.empty();

        return Files.lines(path)
                .map(line -> line.split(","))
                .filter(parts -> parts.length == 3 && parts[1].equalsIgnoreCase(email))
                .map(parts -> new User(parts[0], parts[1], parts[2]))
                .findFirst();
    }

    public static void main(String[] args) {
        Main app = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register User");
            System.out.println("2. Search User");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        app.registerUser(new User(name, email, password));
                        break;
                    case 2:
                        System.out.print("Enter Email: ");
                        String searchEmail = scanner.nextLine();
                        Optional<User> user = app.searchUserByEmail(searchEmail);
                        if (user.isPresent()) {
                            System.out.println("User found: " + user.get().getUserData());
                        } else {
                            System.out.println("User not found!");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
