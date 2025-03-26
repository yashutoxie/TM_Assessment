package com.jpa.DemoJpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity 
@Table(name="emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
    @Column(nullable = false) 
    private String name;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private double salary;

    // Default constructor for JPA
    public Employee() {}

    // Constructor with parameters
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    // Getters and Setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getDepartment() { 
        return department; 
    }

    public void setDepartment(String department) { 
        this.department = department; 
    }

    public double getSalary() { 
        return salary; 
    }

    public void setSalary(double salary) { 
        this.salary = salary; 
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
