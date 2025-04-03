import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDatabase db = new EmployeeDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Database System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    db.addEmployee(new Employee(id, name, salary, dept));
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    Employee emp = db.searchEmployee(scanner.nextInt());
                    System.out.println(emp != null ? emp : "Employee not found.");
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    db.updateSalary(updateId, newSalary);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    db.deleteEmployee(scanner.nextInt());
                    break;
                case 5:
                    db.displayEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
