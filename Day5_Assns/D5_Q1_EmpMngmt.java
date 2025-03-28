import java.util.*;

class Employee {
    private int id;
    private String name;
    private String dept;
    private double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee emp = (Employee) obj;
        return id == emp.id; // Compare by ID to prevent duplicates
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Use 'Objects' instead of 'Object'
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + dept + "', salary=" + salary + "}";
    }

    public static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.getSalary(), e2.getSalary());
        }
    }

    public static class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareToIgnoreCase(e2.getName());
        }
    }
}

public class D5_Q1_EmpMngmt {
    private Set<Employee> employeeSet = new HashSet<>();
    private Map<String, List<Employee>> deptMap = new HashMap<>();

    public void addEmp(Employee emp) {
        if (employeeSet.add(emp)) {
            deptMap.computeIfAbsent(emp.getDept(), k -> new ArrayList<>()).add(emp);
            System.out.println("Emp Added: " + emp);
        } else {
            System.out.println("Duplicate emp id. Cannot Add: " + emp);
        }
    }

    public void displayEmp() {
        if (employeeSet.isEmpty()) {
            System.out.println("No emp found");
        } else {
            employeeSet.forEach(System.out::println);
        }
    }

    public Employee searchById(int id) {
        for (Employee emp : employeeSet) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void displayByDept(String dept) {
        List<Employee> emps = deptMap.get(dept);
        if (emps != null) {
            emps.forEach(System.out::println);
        } else {
            System.out.println("No emp found in the " + dept + " department");
        }
    }

    public void sortBySalary() {
        List<Employee> sortedList = new ArrayList<>(employeeSet);
        sortedList.sort(new Employee.SalaryComparator());
        sortedList.forEach(System.out::println);
    }

    public void sortByName() {
        List<Employee> sortedList = new ArrayList<>(employeeSet);
        sortedList.sort(new Employee.NameComparator());
        sortedList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        D5_Q1_EmpMngmt sys = new D5_Q1_EmpMngmt();
        sys.addEmp(new Employee(101, "Yash", "CSE", 100000));
        sys.addEmp(new Employee(102, "Zayn", "CSE", 100000));
        sys.addEmp(new Employee(102, "Zayn", "CSE", 100000)); // Duplicate entry

        System.out.println("\nAll employees:");
        sys.displayEmp();

        System.out.println("\nEmployees in CSE Department:");
        sys.displayByDept("CSE");

        System.out.println("\nSearching for Employee by ID 102:");
        Employee res = sys.searchById(102);
        System.out.println(res != null ? res : "Employee not found.");

        System.out.println("\nEmployees Sorted by Salary:");
        sys.sortBySalary();

        System.out.println("\nEmployees Sorted by Name:");
        sys.sortByName();
    }
}
