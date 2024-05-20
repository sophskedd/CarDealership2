package org.example;

import java.io.IOException;
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
    private final FileHandling fileHandling;

    /**
     * Constructor for the Dealership class. Initializes the inventory as an empty list.
     */
    public Dealership() {
        this.inventory = new ArrayList<>();
        this.fileHandling = new FileHandling();
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
     * Saves the current state of the inventory to a file.
     *
     * @param filename The name of the file where the inventory should be saved.
     * @throws IOException If an I/O error occurs while saving the inventory.
     */
    public void saveInventoryToFile(String filename) throws IOException {
        fileHandling.saveObjectToFile(filename, inventory);
    }

    /**
     * Loads the inventory from a file.
     *
     * @param filename The name of the file from which the inventory should be loaded.
     * @throws IOException            If an I/O error occurs while loading the inventory.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    public void loadInventoryFromFile(String filename) throws IOException, ClassNotFoundException {
        Object loadedObject = fileHandling.loadObjectFromFile(filename);
        if (loadedObject instanceof List<?>) {
            this.inventory.clear(); // Clear the current inventory
            this.inventory.addAll((List<Car>) loadedObject); // Add all loaded cars to the inventory
        } else {
            System.err.println("Error: The loaded file does not contain a valid inventory list.");
        }
    }

    /**
     * Saves the current state of the inventory to a file. This method is a convenience
     * method that delegates to saveInventoryToFile.
     *
     * @param filename The name of the file where the inventory should be saved.
     * @throws IOException If an I/O error occurs while saving the inventory.
     */
    public void saveToFile(String filename) throws IOException {
        saveInventoryToFile(filename);
    }
}
