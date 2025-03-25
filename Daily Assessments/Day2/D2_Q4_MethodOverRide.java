class Employee {
    protected int salary = 50000;

    public int CalculateSalary() {
        return salary;
    }

}

class Manager extends Employee {
    private int bonus = 10000;

    @Override
    public int CalculateSalary() {
        return salary + bonus;

    }
}

public class D2_Q4_MethodOverRide {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Manager mngr = new Manager();
        System.out.println(emp.CalculateSalary());
        System.out.println(mngr.CalculateSalary());
    }

}
