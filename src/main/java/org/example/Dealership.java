package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Dealership class encapsulates all the functionalities of a car dealership
 * related to managing an inventory of cars. It allows adding cars to inventory,
 * displaying inventory, and handling persistence by saving to and loading from
 * a file.
 */
public class Dealership {
    // List to hold the inventory of cars. It uses Java's generic ArrayList to handle dynamic collections of Car objects.
    private final List<Car> inventory;

    /**
     * Constructor for the Dealership class. Initializes the inventory as an empty list.
     */
    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Adds a Car object to the inventory list.
     *
     * @param vehicle The Car object to be added to the dealership inventory.
     */
    public void addVehicle(Car vehicle) {
        inventory.add(vehicle); // Adds a new car to the inventory list.
    }

    /**
     * Displays the details of each car in the inventory. This method iterates over
     * the inventory list and calls the displayDetails method on each Car object.
     */
    public void displayInventory() {
        for (Car vehicle : inventory) {
            vehicle.displayDetails(); // Each car's details are displayed.
        }
    }

    public void saveInventoryToFile(String filename) {
    }

    public void loadInventoryFromFile(String filename) {
    }

    /**
     * Saves the current state of the inventory to a file. This method serializes
     * the list of Car objects to the specified filename.
     *
     * @param filename The name of the file where the inventory should be saved.
     */
   
}

