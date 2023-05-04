import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hub implements SysOut {
    private double CountryBudget = 500000;
    private double Oil = 1000000;
    private double Food = 1000000;
    private double Ammo = 1000000;
    private double Medicine = 10000;

    private ArrayList<Pilots> Pilots = new ArrayList<Pilots>();
    private ArrayList<Soldiers> Soldiers = new ArrayList<Soldiers>();
    private ArrayList<TanksDriver> TanksDriver = new ArrayList<TanksDriver>();
    private ArrayList<Mechanics> mechanics = new ArrayList<Mechanics>();
    private ArrayList<Medic> Medics = new ArrayList<Medic>();

    // This ArrayList will hold all the staffmembers in our WW2 simulation.
    // It exhibits polymorphism by acting as a container for all the children
    // objects
    // that inherit from the Staff class.
    private ArrayList<Staff> staff = new ArrayList<Staff>();

    private ArrayList<Tanks> Tanks = new ArrayList<Tanks>();
    private ArrayList<Airplane> Airplane = new ArrayList<Airplane>();
    private ArrayList<Weapon> Weapon = new ArrayList<Weapon>();

    public Hub() {
        // Initialize Staff prior to Day 1
        // for (int i = 0; i < 2; i++) {
        // addStaff(StaffType.Pilots);
        // }

        // for (int i = 0; i < 10; i++) {
        // addStaff(StaffType.MECHANIC);
        // }

        // for (int i = 0; i < 200; i++) {
        // addStaff(StaffType.Soldiers);
        // }
        // for (int i = 0; i < 10; i++) {
        // addStaff(StaffType.TanksDriver);
        // }

        // for (int i = 0; i < 10; i++) {
        // addStaff(StaffType.Medic);
        // }
    }

    public void addBudget(double amt) {
        this.CountryBudget += amt;
    }

    public ArrayList<Pilots> getPilots() {
        return Pilots;
    }

    public ArrayList<Soldiers> getSoldiers() {
        return Soldiers;
    }

    public ArrayList<TanksDriver> getTanksDriver() {
        return TanksDriver;
    }

    public ArrayList<Mechanics> getMechanics() {
        return mechanics;
    }

    public ArrayList<Medic> getMedics() {
        return Medics;
    }

    public ArrayList<Weapon> getWeapon() {
        return Weapon;
    }

    public ArrayList<Tanks> getTanks() {
        return Tanks;
    }

    public ArrayList<Airplane> getAirplane() {
        return Airplane;
    }

    public void subtractBudget(double expense) {
        this.CountryBudget -= expense;
    }

    public double getBudget() {
        return this.CountryBudget;
    }

    public double getResourceQuantity(Enums.Resources resourceType) {
        switch (resourceType) {
            case Oil:
                return this.Oil;
            case Food:
                return this.Food;
            case Ammo:
                return this.Ammo;
            case Medicine:
                // Assuming there's a medicine field in your Hub class
                return this.Medicine;
            default:
                return 0;
        }
    }

    void Extractresources() {
        this.CountryBudget += 50000;
        this.Ammo += 100000;
        this.Food += 100000;
        this.Oil += 100000;

        out("You finished the year with the following impact ");
        out("Country Budget increased by " + 50000);
        out("Ammo increased by " + 100000);
        out("Food increased by " + 100000);
        out("Oil increased by " + 100000);

    }

    void sellResources(Enums.Resources resourceType, double quantity) {
        double currentResourceQuantity = this.getResourceQuantity(resourceType);

        if (quantity > currentResourceQuantity) {
            System.out.println("Error: exceeded the amount");
        } else {
            // Proceed with selling the resources
            switch (resourceType) {
                case Oil:
                    this.Oil -= quantity;
                    this.CountryBudget += 0.2 * quantity;
                    break;
                case Food:
                    this.Food -= quantity;
                    this.CountryBudget += 0.2 * quantity;
                    break;
                case Ammo:
                    this.Ammo -= quantity;
                    this.CountryBudget += 0.2 * quantity;
                    break;
                case Medicine:
                    // Assuming there's a medicine field in your Hub class
                    this.Medicine -= quantity;
                    this.CountryBudget += 25 * quantity;
                    break;
                default:
                    break;
            }
        }
    }

}
