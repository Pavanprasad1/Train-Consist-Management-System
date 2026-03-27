package app;

import model.Bogie;
import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import model.GoodsBogie;


public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 80));

        // Display original list
        System.out.println("\nOriginal Bogies:");
        System.out.println(bogies);

        // UC7: Sort
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nSorted Bogies:");
        System.out.println(bogies);

        // UC8: Filter
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        System.out.println(filteredBogies);

        // UC9: Group
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("\nGrouped Bogies by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ✅ UC10: Calculate total capacity
        int totalCapacity = bogies.stream()
                .map(b -> b.getCapacity())   // extract capacity
                .reduce(0, Integer::sum);    // sum all values

        System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);

        // Original list unchanged
        System.out.println("\nOriginal List After Operations:");
        System.out.println(bogies);

        // ✅ UC11: Regex Validation


// Sample inputs (you can later take from user)
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

// Define regex patterns
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

// Create matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

// Validate Train ID
        if (trainMatcher.matches()) {
            System.out.println("\nTrain ID is valid: " + trainId);
        } else {
            System.out.println("\nInvalid Train ID: " + trainId);
        }

// Validate Cargo Code
        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid: " + cargoCode);
        } else {
            System.out.println("Invalid Cargo Code: " + cargoCode);
        }

        // ✅ UC12: Safety Compliance Check


// Create goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // valid
        goodsBogies.add(new GoodsBogie("Open", "Coal"));             // valid
        goodsBogies.add(new GoodsBogie("Box", "Grain"));             // valid
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));      // ❌ invalid

// Display goods bogies
        System.out.println("\nGoods Bogies:");
        System.out.println(goodsBogies);

// Safety check using allMatch()
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    if (b.getType().equals("Cylindrical")) {
                        return b.getCargo().equals("Petroleum");
                    }
                    return true;
                });

// Display result
        if (isSafe) {
            System.out.println("\nTrain is SAFE for operation.");
        } else {
            System.out.println("\nTrain is UNSAFE due to invalid cargo!");
        }
    }
}