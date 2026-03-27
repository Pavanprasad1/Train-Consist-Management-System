package app;

import java.util.HashSet;
import java.util.Set;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create HashSet for bogie IDs (ensures uniqueness)
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display final set
        System.out.println("\nUnique Bogie IDs in Train:");
        System.out.println(bogieIds);

        System.out.println("\nSystem ensures no duplicate bogie IDs.");
    }
}