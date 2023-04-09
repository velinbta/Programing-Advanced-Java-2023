package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEveryThirdLine_05_2 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/WriteEveryThirdLine-05/input.txt";
        String outPath = "StreamsFilesDirectories/WriteEveryThirdLine-05/WriteEveryThirdLine_05_2_output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outPath))) {

            String line = reader.readLine();
            int lineCounter = 1;

            while (line != null) {

                if (lineCounter % 3 == 0) {

                    writer.write(line); // <- Записвам всеки трети ред
                    writer.newLine(); // <- Слизам на следващия ред
                }

                lineCounter++;
                line = reader.readLine(); // <- Прочитам следващия ред от текста
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
