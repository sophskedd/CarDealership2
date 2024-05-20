package org.example;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlingTest {

    private static final String FILE_PATH = "testInventory.dat";

    @Test
    public void saveInventoryToFile() {
        Inventory originalInventory = new Inventory("TestItem", 10);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(originalInventory);
        } catch (IOException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    public void loadInventoryFromFile() {
        Inventory originalInventory = new Inventory("TestItem", 10);
        Inventory loadedInventory = null;

        // First, save the inventory to ensure the file exists
        saveInventoryToFile();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            loadedInventory = (Inventory) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertNotNull(loadedInventory);
        assertEquals(originalInventory, loadedInventory);
    }

    static class Inventory implements Serializable {
        private String name;
        private int quantity;

        public Inventory(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inventory inventory = (Inventory) o;
            return quantity == inventory.quantity && name.equals(inventory.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, quantity);
        }
    }
}
