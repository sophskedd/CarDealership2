package org.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class FileHandlingTest {

    private static final String FILE_PATH = "testCar.dat";
    private final FileHandling fileHandling = new FileHandling();

    @Test
    public void testSaveAndLoadObject() {
        Car originalCar = new Car("Toyota", "Red", 20000);

        // Test saving the object
        try {
            fileHandling.saveObjectToFile(FILE_PATH, originalCar);
        } catch (IOException e) {
            fail("Exception should not have been thrown during save: " + e.getMessage());
        }

        // Test loading the object
        Car loadedCar = null;
        try {
            loadedCar = (Car) fileHandling.loadObjectFromFile(FILE_PATH);
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception should not have been thrown during load: " + e.getMessage());
        }

        // Verify the loaded object
        assertNotNull(loadedCar);
        assertEquals(originalCar, loadedCar);
    }
}
