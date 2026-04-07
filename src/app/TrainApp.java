package app;

import model.Bogie;
import model.GoodsBogie;
import model.InvalidCapacityException;
import model.CargoSafetyException;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ================= UC7: Create Bogies =================
        List<Bogie> bogies = new ArrayList<>();

        try {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 40));
            bogies.add(new Bogie("Sleeper", 80));

            // UC14: Invalid bogie
            bogies.add(new Bogie("Invalid", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        System.out.println("\nOriginal Bogies:");
        System.out.println(bogies);

        // ================= UC7: Sort =================
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("\nSorted Bogies:");
        System.out.println(bogies);

        // ================= UC8: Filter =================
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (>60):");
        System.out.println(filtered);

        // ================= UC9: Group =================
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("\nGrouped Bogies:");
        grouped.forEach((k, v) -> System.out.println(k + " -> " + v));

        // ================= UC10: Reduce =================
        int totalCapacity = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Capacity: " + totalCapacity);

        // ================= UC11: Regex Validation =================
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        System.out.println("\nTrain ID Valid: " + trainPattern.matcher(trainId).matches());
        System.out.println("Cargo Code Valid: " + cargoPattern.matcher(cargoCode).matches());

        // ================= UC12: Safety Check =================
        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Open", "Coal"));
        goods.add(new GoodsBogie("Cylindrical", "Coal")); // invalid

        boolean isSafe = goods.stream()
                .allMatch(b -> b.getType().equals("Cylindrical")
                        ? b.getCargo().equals("Petroleum")
                        : true);

        System.out.println("\nSafety Status: " + (isSafe ? "SAFE" : "UNSAFE"));

        // ================= UC13: Performance =================
        List<Bogie> bigList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            try {
                bigList.add(new Bogie("Sleeper", 72));
            } catch (InvalidCapacityException ignored) {}
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bigList) {
            if (b.getCapacity() > 60) loopResult.add(b);
        }
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<Bogie> streamResult = bigList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();

        System.out.println("\nLoop Time: " + (endLoop - startLoop));
        System.out.println("Stream Time: " + (endStream - startStream));

        // ================= UC15: Safe Cargo Assignment =================
        System.out.println("\n--- UC15: Safe Cargo Assignment ---");

        GoodsBogie bogie1 = new GoodsBogie("Cylindrical", "None");
        GoodsBogie bogie2 = new GoodsBogie("Rectangular", "None");

        try {
            bogie1.assignCargo("Petroleum");
            System.out.println("Cargo assigned to Cylindrical bogie: Petroleum");

            bogie2.assignCargo("Petroleum"); // unsafe

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment process completed.");
        }

        System.out.println("System continues running safely...");

        // ================= UC16: Bubble Sort =================
        System.out.println("\n--- UC16: Bubble Sort (Manual Sorting) ---");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Capacities: " + Arrays.toString(capacities));
        // ================= UC17: Arrays.sort() =================

        System.out.println("\n--- UC17: Sort Bogie Names (Arrays.sort) ---");

// Array of bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

// Display original
        System.out.println("Original Names: " + Arrays.toString(bogieNames));

// Sort using built-in method
        Arrays.sort(bogieNames);

// Display sorted result
        System.out.println("Sorted Names: " + Arrays.toString(bogieNames));
        // ================= UC18: Linear Search =================

        System.out.println("\n--- UC18: Linear Search for Bogie ID ---");

// Array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

// Search key
        String searchKey = "BG309";  // you can change this for testing

        boolean found = false;

// Linear Search
        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                found = true;
                break; // stop when found
            }
        }

// Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND in the train.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND.");
        }

        // ================= FINAL =================
        System.out.println("\n=== SYSTEM EXECUTION COMPLETE ===");
    }
}