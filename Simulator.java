import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Simulator to cycle for select number of days
public class Simulator implements SysOut {
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

        for (int year = 1; year <= 30; ++year) {

        }
    }
}


