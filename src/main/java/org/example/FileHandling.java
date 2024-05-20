package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandling {

    /**
     * Saves an object to a file. This method serializes the provided object
     * to the specified filename.
     *
     * @param filename The name of the file where the object should be saved.
     * @param object   The object to be saved.
     * @throws IOException If an I/O error occurs while saving the object.
     */
    public void saveObjectToFile(String filename, Object object) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            out.writeObject(object);
        }
    }

    /**
     * Loads an object from a file. This method deserializes the object
     * from the specified filename.
     *
     * @param filename The name of the file from which the object should be loaded.
     * @return The object read from the file.
     * @throws IOException            If an I/O error occurs while loading the object.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    public Object loadObjectFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return in.readObject();
        }
    }
}
