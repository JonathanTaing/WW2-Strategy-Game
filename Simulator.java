// Simulator.java -> Game.java
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


// Simulator to cycle for select number of years
public class Simulator implements SysOut {
    Scanner scanner = new Scanner(System.in);
    Country playerCountry;

    // This is the Country's Hub
    Hub hub;
    private Set<String> defeatedCountries = new HashSet<>();

    void run() {
        File file = new File("SimResults.txt");
        boolean fileExists = file.exists();

        // If file exists, overwrite it.
        try {
            FileWriter fileWriter = new FileWriter(file, !fileExists);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out("Welcome to the WW2 Strategy Game!");
        chooseCountry();
        mainMenu();
    }

    private void chooseCountry() {
        out("Please choose a country to play as (enter number): ");
        out("1. USA");
        out("2. Germany");
        out("3. UK");
        out("4. Russia");
        out("5. Japan");
        out("6. France");
    
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                playerCountry = new Country("USA");
                hub = new Hub();
                break;
            case 2:
                playerCountry = new Country("Germany");
                hub = new Hub();
                break;
            case 3:
                playerCountry = new Country("UK");
                hub = new Hub();
                break;
            case 4:
                playerCountry = new Country("Russia");
                hub = new Hub();
                break;
            case 5:
                playerCountry = new Country("Japan");
                hub = new Hub();
                break;
            case 6:
                playerCountry = new Country("France");
                hub = new Hub();
                break;
            default:
                out("Invalid selection. Try again.");
                chooseCountry();
                return;
        }
        out("You chose: " + playerCountry.name);
    }

    private void displayAttackableCountries() {
        String[] countries = {"USA", "Germany", "UK", "Russia", "Japan", "France"};
        int index = 1;
        for (String country : countries) {
            if (!country.equals(playerCountry.name) && !defeatedCountries.contains(country)) {
                out(index + ". " + country);
                index++;
            }
        }
    }
    
    private String getAttackableCountry(int choice) {
        String[] countries = {"USA", "Germany", "UK", "Russia", "Japan", "France"};
        List<String> attackableCountries = new ArrayList<>();
        for (String country : countries) {
            if (!country.equals(playerCountry.name) && !defeatedCountries.contains(country)) {
                attackableCountries.add(country);
            }
        }
        if (choice > 0 && choice <= attackableCountries.size()) {
            return attackableCountries.get(choice - 1);
        } else {
            return null;
        }
    }
    private void mainMenu() {
        int year = 0;
        int totalYears = 30;

        Publisher publisher = Publisher.getInstance();
        Logger logger = Logger.getInstance();

        while (year < totalYears) {
            logger.setLogger(year+1, publisher);

            out("\nYear: " + (year+1));
            out("Gold:" + hub.getBudget());
            out("Please select an option (enter number): ");
            out("1. Extract Resources");
            out("2. Sell resources");
            out("3. Spy on another country");
            out("4. Train troops, pilots & tankers");
            out("5. Attack a country");
            out("6. Quit game");

            Enums.Resources resourceType;
            Enums.StaffType staffType;
            double doubleQuantity;
            int intQuantity;
            int resourceChoice;

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    out("Extracting Resources...");
                    hub.Extractresources();
                    break;
                case 2:
                    out("Selling Resources...");

                    // Ask the user for the resource type they want to sell
                    out("Please choose the resource type to sell (enter number): ");
                    out("1. Oil");
                    out("2. Food");
                    out("3. Ammo");
                    out("4. Medicine");

                    resourceChoice = scanner.nextInt();
                    switch (resourceChoice) {
                        case 1:
                            resourceType = Enums.Resources.Oil;
                            break;
                        case 2:
                            resourceType = Enums.Resources.Food;
                            break;
                        case 3:
                            resourceType = Enums.Resources.Ammo;
                            break;
                        case 4:
                            resourceType = Enums.Resources.Medicine;
                            break;
                        default:
                            out("Invalid selection. Try again.");
                            continue;
                    }

                    // Ask the user for the quantity they want to sell
                    out("Enter the quantity to sell: ");
                    doubleQuantity = scanner.nextDouble();

                    // Call to sellResources raises an exception
                     hub.sellResources(resourceType, doubleQuantity);
                    break;
                case 3:
                    out("Spying...");
                    break;
                case 4:
                    out("Training...");

                    // Ask the user for the troops type they want to train
                    out("Please choose the staff type to train (enter number): ");
                    out("1. Pilots");
                    out("2. Soldiers");
                    out("3. TanksDriver");
                    out("4. Mechanics");
                    out("5. Medic");

                    resourceChoice = scanner.nextInt();
                    switch (resourceChoice) {
                        case 1:
                            staffType = Enums.StaffType.Pilots;
                            break;
                        case 2:
                            staffType = Enums.StaffType.Soldiers;
                            break;
                        case 3:
                            staffType = Enums.StaffType.TanksDriver;
                            break;
                        case 4:
                            staffType = Enums.StaffType.Mechanics;
                            break;
                        case 5:
                            staffType = Enums.StaffType.Medic;
                            break;
                        default:
                            out("Invalid selection. Try again.");
                            continue;
                    }

                    // Ask the user for how much to spend on training.
                    out("Enter the amount to spend on training: ");
                    intQuantity = scanner.nextInt();

                    // Call to trainTroops raises an exception
                     hub.trainTroops(staffType, intQuantity);
                    break;
                case 5:
                out("Attacking...");

            // Ask the user for the country they want to attack
            out("Please choose a country to attack (enter number): ");
            displayAttackableCountries();

            int targetCountryChoice = scanner.nextInt();
            String targetCountry = getAttackableCountry(targetCountryChoice);
            if (targetCountry == null) {
                out("Invalid selection. Try again.");
                continue;
            }

            boolean isDefeated = hub.attack(targetCountry);
            if (isDefeated) {
                defeatedCountries.add(targetCountry);
                out(targetCountry + " has been defeated!");
            }

                    break;
                case 6:
                    out("Thanks for playing!");
                    System.exit(0);
                default:
                    out("Invalid selection. Try again.");
                    continue;
            }
            logger.close();
            year++;
        }
    }
}


