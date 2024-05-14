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
    private List<Car> inventory;

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

    /**
     * Saves the current state of the inventory to a file. This method serializes
     * the list of Car objects to the specified filename.
     *
     * @param filename The name of the file where the inventory should be saved.
     */
    public void saveInventoryToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(inventory); // Write the entire inventory list as an object to the file.
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage()); // Exception handling for file output errors.
        }
    }

    /**
     * Loads the inventory from a file. This method deserializes the list of Car objects
     * from the specified filename into the inventory list.
     *
     * @param filename The name of the file from which the inventory should be loaded.
     */
    public void loadInventoryFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            inventory = (List<Car>) in.readObject(); // Read the inventory list object from the file.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory: " + e.getMessage()); // Exception handling for file input errors or class not found.
        }
    }
}

