// One of 3 classes that implements the Strategy Pattern for the different kinds of Attacks that a Country can execute.
public class GroundStrike implements AttackMethod {
    @Override
    public void executeAttack() {
        System.out.println("Executing Ground Strike!");
    }
}
