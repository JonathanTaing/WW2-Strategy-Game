public abstract class Equipment {
    private String type;
    private int quantity;

    public Equipment(String equipmentType, int initialQuantity) {
        this.type = equipmentType;
        this.quantity = initialQuantity;
    }

    public String getType() {
        return this.type;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Tanks extends Equipment {
    private double cost;

    public Tanks(int initialQuantity, double cost) {
        super("Tanks", initialQuantity);
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }
}

class Airplane extends Equipment {
    private double cost;

    public Airplane(int initialQuantity, double cost) {
        super("Airplane", initialQuantity);
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }
}

class Weapon extends Equipment {
    private double cost;

    public Weapon(int initialQuantity, double cost) {
        super("Weapon", initialQuantity);
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }
}
