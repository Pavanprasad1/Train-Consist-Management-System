package app;

import model.Bogie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));

        // Display before sorting
        System.out.println("\nBefore Sorting:");
        System.out.println(bogies);

        // Sort by capacity
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display after sorting
        System.out.println("\nAfter Sorting by Capacity:");
        System.out.println(bogies);

        System.out.println("\nSystem sorts bogies based on capacity.");
    }
}