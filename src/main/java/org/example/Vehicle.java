package org.example;

import java.io.Serializable;

/**
 * The Vehicle class is an abstract class designed to serve as a base class
 * for different types of vehicles in a dealership management system.
 * It defines the common properties and functionalities that all vehicle
 * subclasses should inherit and implement.
 */
public abstract class Vehicle implements Serializable {

    protected final String brand;
    protected final String color;
    protected final int price;

    /**
     * Constructor with parameters for initializing a Vehicle object.
     * This constructor allows for setting the initial state of a vehicle when an instance is created.
     *
     * @param brand The brand of the vehicle (e.g., Toyota, Ford).
     * @param color The color of the vehicle.
     * @param price The price of the vehicle in currency units.
     */
    public Vehicle(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public abstract void displayDetails();
}