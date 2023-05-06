import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

// Staff is an abstract class to be inherited by the following classes: Pilots, Soldiers, and TanksDriver, Mechanics, and Medics.
public abstract class Staff implements SysOut {
    String name;
    int number;
    Enums.StaffType type;
}

class Pilots extends Staff {
    static List<String> Generalnames = Arrays.asList("Fred", "Ethel", "Lucy", "Desi");
    static Namer namer = new Namer(Generalnames);

    Pilots() {
        type = Enums.StaffType.Pilots;
        name = namer.getNext(); // every new General gets a new name
        number = 1000;
    }
}

class Soldiers extends Staff {
    static List<String> Generalnames = Arrays.asList("James", "Scotty", "Spock", "Uhura");
    static Namer namer = new Namer(Generalnames);

    Soldiers() {
        type = Enums.StaffType.Soldiers;
        name = namer.getNext(); // every new General gets a new name
        number = 10000;

    }
}

class TanksDriver extends Staff {
    static List<String> Generalnames = Arrays.asList("Rachel", "Monica", "Phoebe", "Chandler", "Ross", "Joey");
    static Namer namer = new Namer(Generalnames);

    TanksDriver() {
        type = Enums.StaffType.TanksDriver;
        name = namer.getNext(); // every new General gets a new name
        number = 1000;
    }
}

class Mechanics extends Staff {
    static List<String> Generalnames = Arrays.asList("Fred", "Ethel", "Lucy", "Desi");
    static Namer namer = new Namer(Generalnames);

    Mechanics() {
        type = Enums.StaffType.Mechanics;
        name = namer.getNext(); // every new General gets a new name
        number = 1000;
    }
}

class Medic extends Staff {
    static List<String> Generalnames = Arrays.asList("James", "Scotty", "Spock", "Uhura");
    static Namer namer = new Namer(Generalnames);

    Medic() {
        type = Enums.StaffType.Medic;
        name = namer.getNext(); // every new General gets a new name
        number = 1000;
    }
}
