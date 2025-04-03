package com.assn;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
 
class Employee {
    private int id;
    private String name;
    private Optional<LocalDateTime> lastLogin; // Optional to handle missing logins
 
    public Employee(int id, String name, LocalDateTime lastLogin) {
        this.id = id;
        this.name = name;
        this.lastLogin = Optional.ofNullable(lastLogin); // Handles null values
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<LocalDateTime> getLastLogin() {
        return lastLogin;
    }
}
 
class AttendanceTracker {
    private List<Employee> employees;

    public AttendanceTracker(List<Employee> employees) {
        this.employees = employees;
    }

    // Find employees who haven't logged in for the past 7 days
    public List<Employee> getInactiveEmployees() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        return employees.stream()
                .filter(emp -> emp.getLastLogin().isPresent() && emp.getLastLogin().get().isBefore(sevenDaysAgo))
                .collect(Collectors.toList());
    }

    // Sort employees by last login date (oldest first)
    public List<Employee> getSortedEmployeesByLastLogin() {
        return employees.stream()
                .sorted(Comparator.comparing(emp -> emp.getLastLogin().orElse(LocalDateTime.MIN)))
                .collect(Collectors.toList());
    }
 
    public void displayEmployees(List<Employee> empList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Employee emp : empList) {
            String lastLogin = emp.getLastLogin()
                    .map(time -> time.format(formatter))
                    .orElse("No Login Record");
            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Last Login: " + lastLogin);
        }
    }
}
 
public class EmployeeAttendanceTrackerApp {
    public static void main(String[] args) { 
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice", LocalDateTime.now().minusDays(10)),
            new Employee(102, "Bob", LocalDateTime.now().minusDays(3)),
            new Employee(103, "Charlie", null), // No login record
            new Employee(104, "David", LocalDateTime.now().minusDays(15)),
            new Employee(105, "Eve", LocalDateTime.now().minusDays(1))
        );
 
        AttendanceTracker tracker = new AttendanceTracker(employees);

        // Find inactive employees
        System.out.println("\nEmployees who haven't logged in for 7+ days:");
        tracker.displayEmployees(tracker.getInactiveEmployees());

        // Sort employees by last login date
        System.out.println("\nEmployees sorted by last login date (oldest first):");
        tracker.displayEmployees(tracker.getSortedEmployeesByLastLogin());
    }
}
