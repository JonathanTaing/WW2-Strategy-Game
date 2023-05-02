// Simulator.java -> Game.java
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Simulator to cycle for select number of years
public class Simulator implements SysOut {
    Scanner scanner = new Scanner(System.in);
    Country playerCountry;

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

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                playerCountry = new Country("USA");
                break;
            case 2:
                playerCountry = new Country("Germany");
                break;
            default:
                out("Invalid selection. Try again.");
                chooseCountry();
                return;
        }
        out("You chose: " + playerCountry.name);
    }

    private void mainMenu() {
        int year = 0;
        int totalYears = 30;

        Publisher publisher = Publisher.getInstance();
        Logger logger = Logger.getInstance();

        while (year < totalYears) {
            logger.setLogger(year, publisher);

            out("\nYear: " + (year+1));
            out("Please select an option (enter number): ");
            out("1. Extract Resources");
            out("2. Sell resources");
            out("3. Spy on another country");
            out("4. Train troops, pilots & tankers");
            out("5. Manufacture arms, aircraft & tanks.");
            out("6. Attack a country");
            out("7. Develop technology");
            out("8. Quit game");

            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    out("Extracting Resources...");
                    break;
                case 2:
                    out("Selling Resources...");
                    break;
                case 3:
                    out("Spying...");
                    break;
                case 4:
                    out("Training...");
                    break;
                case 5:
                    out("Manufacturing...");
                    break;
                case 6:
                    out("Attacking...");
                    break;
                case 7:
                    out("Developing...");
                    break;
                case 8:
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


