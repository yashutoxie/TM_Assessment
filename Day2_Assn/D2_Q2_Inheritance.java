/*Scenario:
You are designing a vehicle management system with multiple vehicle types:
1.Vehicle (parent class) → contains common attributes (speed, fuelType).
2.Car (inherits from Vehicle) → has an additional numDoors attribute.
3.ElectricCar (inherits from Car) → adds batteryCapacity attribute.

Implement single and multilevel inheritance.
Define a method displayDetails() in Vehicle and override it in Car and ElectricCar.
Example Usage:
ElectricCar tesla = new ElectricCar(120, "Electric", 4, 80);
tesla.displayDetails();
Expected Output:
Speed: 120 km/h, Fuel Type: Electric, Doors: 4, Battery: 80 kWh */

class Vehicle {
    private int speed;
    private String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public void displayDetails() {
        System.out.println("Speed: " + speed + " km/h" + " " + "fuelType: " + fuelType);
    }

}

class Car extends Vehicle {
    private int numDoors;

    public Car(int speed, String fuelType, int numDoors) {
        super(speed, fuelType);
        this.numDoors = numDoors;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numDoors);
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(int speed, int batteryCapacity, int numDoors) {
        super(speed, "Electric", numDoors);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity);
    }
}

public class D2_Q2_Inheritance {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(100, "Petrol");
        vehicle.displayDetails();

        Car car = new Car(150, "Diesel", 4);
        car.displayDetails();

        ElectricCar electricCar = new ElectricCar(200, 80, 4);
        electricCar.displayDetails();
    }
}