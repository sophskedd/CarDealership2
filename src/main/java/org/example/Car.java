package org.example;

/**
 * The Car class extends the Vehicle class and adds specific attributes
 * and functionalities that are unique to cars. This class demonstrates
 * the use of inheritance in Java by extending the Vehicle class.
 */
public class Car extends Vehicle {
    // Additional attribute specific to cars, representing the mileage that can be covered per tank.
    private int mileagePerTank;

    // Boolean attribute to indicate whether the car is equipped with a navigation system.
    private boolean hasNavigationSystem;

    /**
     * Constructor for creating a Car object with detailed attributes including navigation and mileage capabilities.
     *
     * @param brand The brand of the car (e.g., Toyota, Ford).
     * @param color The color of the car.
     * @param price The price of the car in currency units.
     * @param mileagePerTank The maximum distance (in miles or kilometers) the car can travel on a full tank of fuel.
     * @param hasNavigationSystem Indicates whether the car is equipped with a navigation system (true or false).
     */
    public Car(String brand, String color, int price, int mileagePerTank, boolean hasNavigationSystem) {
        super(brand, color, price); // Call to the superclass (Vehicle) constructor to initialize common attributes.
        this.mileagePerTank = mileagePerTank; // Set the mileage per tank specific to this car.
        this.hasNavigationSystem = hasNavigationSystem; // Set the navigation system presence.
    }

    /**
     * Simplified constructor for creating a Car object without specifying mileage and navigation system.
     * This uses the superclass's constructor to set common attributes.
     *
     * @param brand The brand of the car.
     * @param color The color of the car.
     * @param price The price of the car.
     */
    public Car(String brand, String color, int price) {
        super(brand, color, price); // Initialize the car with default settings for mileage and navigation.
        this.mileagePerTank = 0; // Default value indicating no specific mileage is set.
        this.hasNavigationSystem = false; // Default setting with no navigation system.
    }

    /**
     * Overrides the abstract method displayDetails from the Vehicle class.
     * Provides a detailed description of the car, including specific attributes.
     */
    @Override
    public void displayDetails() {
        System.out.println("Car - Brand: " + brand + ", Color: " + color + ", Price: $" + price +
                ", Mileage per Tank: " + mileagePerTank + ", Navigation System: " + (hasNavigationSystem ? "Yes" : "No"));
    }

    // Getter method for mileagePerTank. (all not implemented)
    public int getMileagePerTank() { return mileagePerTank; }

    // Setter method for mileagePerTank.
    public void setMileagePerTank(int mileagePerTank) { this.mileagePerTank = mileagePerTank; }

    // Getter method for hasNavigationSystem.
    public boolean hasNavigationSystem() { return hasNavigationSystem; }

    // Setter method for hasNavigationSystem.
    public void setNavigationSystem(boolean hasNavigationSystem) { this.hasNavigationSystem = hasNavigationSystem; }
}

