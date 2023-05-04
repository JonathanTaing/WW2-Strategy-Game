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
    private ArrayList<Medic> Medic = new ArrayList<Medic>();

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

    public void subtractBudget(double expense) {
        this.CountryBudget -= expense;
    }

    public double getBudget() {
        return this.CountryBudget;
    }

    // adding staff
    // smells like we need a factory or something...
    void addStaff(Enums.StaffType t) {
        Staff newStaff = null;
        newStaff = StaffCreator.createStaff(t);
        out("Assigned a new " + newStaff.type + " General named " + newStaff.name);
        staff.add(newStaff);
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

    void trainTroops(Enums.StaffType staffType, int quantity) {
        // Check if there's enough budget to train the troops
        double trainingCost = 0;
        switch (staffType) {
            case Pilots:
                quantity /= 1000;
                trainingCost = 100000 * quantity;
                break;
            case Soldiers:
                quantity /= 10000;
                trainingCost = 200000 * quantity;
                break;
            case TanksDriver:
                quantity /= 1000;
                trainingCost = 50000 * quantity;
                break;
            case Mechanics:
                quantity /= 1000;
                trainingCost = 30000 * quantity;
                break;
            case Medic:
                quantity /= 1000;
                trainingCost = 400000 * quantity;
                break;
            default:
                break;
        }

        if (trainingCost > this.CountryBudget) {
            System.out.println("Error: Not enough budget to train the troops");
            return;
        }

        // Train the troops
        for (int i = 0; i < quantity; i++) {
            addStaff(staffType);
        }

        // Deduct the training cost from the budget
        subtractBudget(trainingCost);
    }

    void manufactureEquipment(Enums.Equipment equipmentType, int quantity) {
        // Check if there's enough budget to manufacture the equipment
        double manufacturingCost = 0;
        switch (equipmentType) {
            case Weapon:
                manufacturingCost = 100 * quantity;
                break;
            case Airplane:
                manufacturingCost = 20000 * quantity;
                break;
            case Tanks:
                manufacturingCost = 15000 * quantity;
                break;
            default:
                break;
        }

        if (manufacturingCost > this.CountryBudget) {
            System.out.println("Error: Not enough budget to manufacture the equipment");
            return;
        }

        // Manufacture the equipment
        for (int i = 0; i < quantity; i++) {
            switch (equipmentType) {
                case Weapon:
                    Weapon weapon = new Weapon(1, 100);
                    this.Weapon.add(weapon);
                    break;
                case Airplane:
                    Airplane airplane = new Airplane(1, 20000);
                    this.Airplane.add(airplane);
                    break;
                case Tanks:
                    Tanks tank = new Tanks(1, 15000);
                    this.Tanks.add(tank);
                    break;
                default:
                    break;
            }
        }

        // Deduct the manufacturing cost from the budget
        subtractBudget(manufacturingCost);
    }

}
