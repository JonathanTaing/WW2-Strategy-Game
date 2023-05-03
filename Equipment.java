import java.util.Random;

public abstract class Equipment {
    private static Random rand = new Random();

    private String name;
    private String type;
    private double cost;


    public Equipment(String EquipmentType, int id, double initialCost) {
        this.name = EquipmentType + "_" + id;
        this.type = EquipmentType;
        this.cost = initialCost;
        
    }


    public String getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
    public double getCost() {
        return this.cost;
    }

}

class Tanks extends Equipment {
    private static int id = 1;
    
    public Tanks() {
        super("Tanks", id++, new Random().nextDouble(20000, 40000));
    }

}

class Airplane extends Equipment {
    private static int id = 1;
    
    public Airplane() {
        super("Airplane", id++, new Random().nextDouble(20000, 60000));
    }

}

class Weapon extends Equipment {
    private static int id = 1;
    
    public Weapon() {
        super("Weapon", id++, new Random().nextDouble(1000, 2000));
    }

}