import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public abstract class Staff implements SysOut {
    String name;
    Enums.StaffType type;
}

class Pilots extends Staff {
    static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi");
    static Namer namer = new Namer(names);

    Pilots() {
        type = Enums.StaffType.Pilots;
        name = namer.getNext();  // every new Pilot gets a new name
    }
}

class Soldiers extends Staff {
    static List<String> names = Arrays.asList("James", "Scotty", "Spock", "Uhura");
    static Namer namer = new Namer(names);

    Soldiers() {
        type = Enums.StaffType.Soldiers;
        name = namer.getNext();  // every new Soldier gets a new name
    }
}

class TanksDriver extends Staff {
    static List<String> names = Arrays.asList("Rachel","Monica","Phoebe","Chandler","Ross","Joey");
    static Namer namer = new Namer(names);

    TanksDriver() {
        type = Enums.StaffType.TanksDriver;
        name = namer.getNext();  // every new TankDriver gets a new name
    }
}

class Mechanics extends Staff {
    static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi");
    static Namer namer = new Namer(names);

    Mechanics() {
        type = Enums.StaffType.Mechanics;
        name = namer.getNext();  // every new Mechanic gets a new name
    }
}

class Medic extends Staff {
    static List<String> names = Arrays.asList("James", "Scotty", "Spock", "Uhura");
    static Namer namer = new Namer(names);

    Medic() {
        type = Enums.StaffType.Medic;
        name = namer.getNext();  // every new Mechanic gets a new name
    }
}


