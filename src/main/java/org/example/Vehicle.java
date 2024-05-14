package org.example;

/**
 * The Vehicle class is an abstract class designed to serve as a base class
 * for different types of vehicles in a dealership management system.
 * It defines the common properties and functionalities that all vehicle
 * subclasses should inherit and implement.
 */
public abstract class Vehicle {
    // Protected class members are accessible within the class itself, its subclasses,
    // and classes within the same package. These members include brand, color, and price of the vehicle.
    protected String brand;
    protected String color;
    protected int price;

    /**
     * Constructor with parameters for initializing a Vehicle object.
     * This constructor allows for setting the initial state of a vehicle when an instance is created.
     *
     * @param brand The brand of the vehicle (e.g., Toyota, Ford).
     * @param color The color of the vehicle.
     * @param price The price of the vehicle in currency units.
     */
    public Vehicle(String brand, String color, int price) {
        this.brand = brand; // Assigns the brand of the vehicle.
        this.color = color; // Assigns the color of the vehicle.
        this.price = price; // Assigns the price of the vehicle.
    }

    /**
     * Default constructor for Vehicle.
     * This constructor is provided to enable subclass constructors to call super()
     * without any arguments, especially when the subclass wants to handle the initialization itself
     * or when default values are to be used.
     */
    public Vehicle() {
        // This constructor intentionally left blank.
    }

    /**
     * Abstract method that subclasses need to implement. This method is intended to
     * display detailed information about the vehicle, which may vary significantly between
     * different types of vehicles.
     */
    public abstract void displayDetails();

    /**
     * Retrieves the brand of the vehicle.
     * @return A string representing the brand of the vehicle.
     */
    public String getBrand() { return brand; }

    /**
     * Sets the brand of the vehicle.
     * @param brand A string representing the new brand of the vehicle.
     */
    public void setBrand(String brand) { this.brand = brand; }

    /**
     * Retrieves the color of the vehicle.
     * @return A string representing the color of the vehicle.
     */
    public String getColor() { return color; }

    /**
     * Sets the color of the vehicle.
     * @param color A string representing the new color of the vehicle.
     */
    public void setColor(String color) { this.color = color; }

    /**
     * Retrieves the price of the vehicle.
     * @return An integer representing the price of the vehicle.
     */
    public int getPrice() { return price; }

    /**
     * Sets the price of the vehicle.
     * @param price An integer representing the new price of the vehicle.
     */
    public void setPrice(int price) { this.price = price; }
}

