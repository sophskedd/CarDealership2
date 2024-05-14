package org.example;

import java.util.Scanner;

/**
 * The Main class serves as the entry point for the dealership application.
 * It provides a menu-driven interface to manage a dealership's inventory
 * through a console-based user interface.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize the Scanner object for capturing input from the console.
        Scanner scanner = new Scanner(System.in);

        // Create an instance of Dealership to manage the inventory of vehicles.
        Dealership dealership = new Dealership();

        // Filename where the inventory data will be saved and loaded.
        String filename = "inventory.dat";

        // Variable to store the user's menu choice.
        int option = 0;

        // Main loop that shows the menu and processes user input until the user chooses to exit.
        while (option != 6) {
            // Display the main menu options to the user.
            System.out.println("\nWelcome to the Dealership. Choose an option:");
            System.out.println("1. Add a Car");
            System.out.println("2. Display Inventory");
            System.out.println("3. Save Inventory");
            System.out.println("4. Load Inventory");
            System.out.println("5. Check Horn");
            System.out.println("6. Exit");

            // Read the user's choice from the console.

            //scanner.nextLine(); // Consume the trailing newline character after reading an integer.
            option = scanner.nextInt();
            // Switch statement to handle different user choices based on the option selected.
            if (option == 1) {
                // Option 1: Add a new car to the inventory.
                System.out.println("Enter brand:");
                String brand = scanner.nextLine(); // Read the car brand from the user.
                System.out.println("Enter color:");
                String color = scanner.nextLine(); // Read the car color from the user.
                System.out.println("Enter price:");
                int price = scanner.nextInt(); // Read the car price from the user.
                scanner.nextLine(); // Consume the trailing newline character.

                // Create a new Car object and add it to the dealership inventory.
                Car car = new Car(brand, color, price);
                dealership.addVehicle(car);
                break;
            }

            if (option == 2) {
                // Option 2: Display all cars currently in the inventory.
                dealership.displayInventory();
                break;
            }

            if (option == 3) {
                // Option 3: Save the current inventory to a file.
                dealership.saveInventoryToFile(filename);
                break;
            }

            if (option == 4) {
                // Option 4: Load the inventory from a file.
                dealership.loadInventoryFromFile(filename);
            }

            if (option == 5) {
                // Option 5: honk.
                System.out.println("HONK!!!!");
            }

            if (option == 6) {
                // Option 6: Exit the program.
                System.out.println("Exiting...");
            } else {
                // Handle invalid options chosen by the user.
                System.out.println("Invalid option, please choose again.");
                break;
            }
        }

        // Close the scanner to free up resources.
        //scanner.close();
    }
}

