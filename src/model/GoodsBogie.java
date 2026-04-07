package model;

public class GoodsBogie {

    private String type;   // Cylindrical / Open / Box / Rectangular
    private String cargo;  // Petroleum / Coal / Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // ✅ ADD THIS METHOD (THIS FIXES YOUR ERROR)
    public void assignCargo(String cargo) {

        // Rule: Rectangular cannot carry Petroleum
        if (this.type.equals("Rectangular") && cargo.equals("Petroleum")) {
            throw new CargoSafetyException("Unsafe: Rectangular bogie cannot carry Petroleum");
        }

        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " (" + cargo + ")";
    }
}