import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BackupManager backupManager = new BackupManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFile Backup and Recovery System");
            System.out.println("1. Backup Directory");
            System.out.println("2. Recover Files");
            System.out.println("3. View Backup Metadata");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter directory to backup: ");
                    String dir = scanner.nextLine();
                    backupManager.backupDirectory(dir);
                    break;
                case 2:
                    backupManager.recoverFiles();
                    break;
                case 3:
                    backupManager.showBackupMetadata();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
