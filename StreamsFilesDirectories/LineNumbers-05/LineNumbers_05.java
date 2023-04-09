package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers_05 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/LineNumbers-05/inputLineNumbers.txt";
        String outPath = "StreamsFilesDirectories/LineNumbers-05/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));
             PrintWriter writer = new PrintWriter(outPath)) {

            String line = reader.readLine(); // <- Ред по ред

            int numberOfLine = 1;
            while (line != null) {
                // Слагам номер пред всеки ред и записвам/принтирам изходните данни в output.txt
                writer.printf("%d. %s\n", numberOfLine, line);

                numberOfLine++;
                line = reader.readLine();
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
