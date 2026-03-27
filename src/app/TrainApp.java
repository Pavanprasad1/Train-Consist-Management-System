package app;

import java.util.LinkedHashSet;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedHashSet for train formation
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate
        trainFormation.add("Sleeper"); // duplicate

        // Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(trainFormation);

        System.out.println("\nSystem preserves order and prevents duplicates.");
    }
}