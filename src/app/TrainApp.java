package app;

import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after adding
        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);

        // Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Display after removal
        System.out.println("\nPassenger Bogies after removal of AC Chair:");
        System.out.println(passengerBogies);

        // Check if Sleeper exists
        boolean exists = passengerBogies.contains("Sleeper");

        System.out.println("\nDoes Sleeper bogie exist? " + exists);

        // Final state
        System.out.println("\nFinal Train Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nSystem ready for further operations.");
    }
}