package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine_05_1 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/WriteEveryThirdLine-05/input.txt";
        String outPath = "StreamsFilesDirectories/WriteEveryThirdLine-05/WriteEveryThirdLine_05_1_output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inPath));
             PrintWriter out = new PrintWriter(new FileOutputStream(outPath))) {

            int lineCounter = 1;
            while (scanner.hasNextLine()) { // <- Докато има следващ ред

                if (lineCounter % 3 == 0) {

                    out.println(scanner.nextLine()); // <- Записвам всеки трети ред

                } else {

                    scanner.nextLine(); // <- Слизам на следващия

                }

                lineCounter++;

            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
