package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



public class FileHandling {
    public void saveInventoryToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            Object inventory = null;
            out.writeObject(null); // Write the entire inventory list as an object to the file.
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
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            List<Car> inventory = (List<Car>) in.readObject(); // Read the inventory list object from the file.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory: " + e.getMessage()); // Exception handling for file input errors or class not found.
        }
    }
}
