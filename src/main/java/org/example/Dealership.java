package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Dealership class encapsulates all the functionalities of a car dealership
 * related to managing an inventory of cars. It allows adding cars to inventory,
 * displaying inventory, and handling persistence by saving to and loading from
 * a file.
 */
@SuppressWarnings("ALL")
public class Dealership implements Serializable {

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
     * Saves the current state of the inventory to a file.
     *
     * @param fileHandling The FileHandling instance used to save the inventory.
     * @param filename     The name of the file where the inventory should be saved.
     * @throws IOException If an I/O error occurs while saving the inventory.
     */
    public void saveInventoryToFile(FileHandling fileHandling, String filename) throws IOException {
        fileHandling.saveObjectToFile(filename, inventory);
    }

    /**
     * Loads the inventory from a file.
     *
     * @param fileHandling The FileHandling instance used to load the inventory.
     * @param filename     The name of the file from which the inventory should be loaded.
     * @throws IOException            If an I/O error occurs while loading the inventory.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    public void loadInventoryFromFile(FileHandling fileHandling, String filename) throws IOException, ClassNotFoundException {
        // Check if the file exists
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        // Load object from file
        Object loadedObject = fileHandling.loadObjectFromFile(filename);
        // Validate loaded data in the file
        if (!(loadedObject instanceof List<?>)) {
            throw new IOException("The loaded file does not contain a valid inventory list.");
        }
        // casted and cased the loaded object to List<Car> - the problem
        List<?> loadedList = (List<?>) loadedObject;
        List<Car> loadedCars = new ArrayList<>();
        for (Object obj : loadedList) {
            if (!(obj instanceof Car)) {
                throw new IOException("The loaded file does not contain a valid inventory list.");
            }
            loadedCars.add((Car) obj);
        }

        // Update inventory
        this.inventory.clear(); // Clear the current inventory
        this.inventory.addAll(loadedCars); // Add all loaded cars to the inventory
    }


    public void displayInventory() {
        // Method to display inventory details
        for (Car car : inventory) {
            car.displayDetails();
        }
    }
}
