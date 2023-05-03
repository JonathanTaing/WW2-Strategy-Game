import java.lang.reflect.Array;
import java.util.ArrayList;


public class Hub {
    private double CountryBudget = 500000;
    private double Oil = 1000000;
    private double Food = 1000000;
    private double Ammo = 1000000;

    private ArrayList<Pilots> Pilots = new ArrayList<Pilots>();
    private ArrayList<Soldiers> Soldiers = new ArrayList<Soldiers>();
    private ArrayList<TanksDriver> TanksDriver = new ArrayList<TanksDriver>();
    private ArrayList<Mechanics> mechanics = new ArrayList<Mechanics>();
    private ArrayList<Medic> Medics = new ArrayList<Medic>();
    
    // This ArrayList will hold all the staffmembers in our WW2 simulation.
    // It exhibits polymorphism by acting as a container for all the children objects
    // that inherit from the Staff class.
    private ArrayList<Staff> staff = new ArrayList<Staff>();


    private ArrayList<Tanks> Tanks = new ArrayList<Tanks>();
    private ArrayList<Airplane> Airplane = new ArrayList<Airplane>();
    private ArrayList<Weapon> Weapon = new ArrayList<Weapon>();


    public Hub() {
        // Initialize Staff prior to Day 1
        for (int i = 0; i < 2; i++) {
            addStaff(StaffType.Pilots);
        }

        for (int i = 0; i < 10; i++) {
            addStaff(StaffType.MECHANIC);
        }

        for (int i = 0; i < 200; i++) {
            addStaff(StaffType.Soldiers);
        }
                for (int i = 0; i < 10; i++) {
            addStaff(StaffType.TanksDriver);
        }

        for (int i = 0; i < 10; i++) {
            addStaff(StaffType.Medic);
        }
    }


    public void addBudget(double amt) {
        this.operatingBudget += amt;
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
        this.operatingBudget -= expense;
    }

    public double getBudget() {
        return this.operatingBudget;
    }

