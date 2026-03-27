package app;

import java.util.HashMap;
import java.util.Map;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create HashMap for bogie-capacity mapping
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Add bogie capacities
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 40);

        // Display mapping
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        System.out.println("\nSystem maps each bogie to its capacity.");
    }
}