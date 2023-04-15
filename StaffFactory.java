// The code below implements the Factory pattern for the creation of Staff.
public abstract class StaffFactory {
    public abstract Staff createStaff();
}

class PilotsFactory extends StaffFactory {
    @Override
    public Staff createStaff() {
        return new Pilots();
    }
}

class SoldiersFactory extends StaffFactory {
    @Override
    public Staff createStaff() {
        return new Soldiers();
    }
}

class TanksDriverFactory extends StaffFactory {
    @Override
    public Staff createStaff() {
        return new TanksDriver();
    }
}

class MechanicsFactory extends StaffFactory {
    @Override
    public Staff createStaff() {
        return new Mechanics();
    }
}

class MedicFactory extends StaffFactory {
    @Override
    public Staff createStaff() {
        return new Medic();
    }
}



class StaffCreator {
    public static Staff createStaff(Enums.StaffType type) {
        StaffFactory factory;
        switch (type) {
            case Pilots:
                factory = new PilotsFactory();
                break;
            case Soldiers:
                factory = new SoldiersFactory();
                break;
            case TanksDriver:
                factory = new TanksDriverFactory();
                break;
            case Mechanics:
                factory = new MechanicsFactory();
                break;
            case Medic:
                factory = new MedicFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid staff type: " + type);
        }
        return factory.createStaff();
    }
}