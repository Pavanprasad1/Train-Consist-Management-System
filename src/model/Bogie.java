package model;

public class Bogie {

    private String name;
    private int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    // Display format
    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}