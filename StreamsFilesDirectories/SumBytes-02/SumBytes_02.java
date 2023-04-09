package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class SumBytes_02 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/SumBytes-02/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))) {

            String line = reader.readLine(); // <- Прочитам ред по ред

            long totalSumChars = 0;
            while (line != null) {

                long currentSumChars = line.chars().sum(); // <- Сумата на ascii стойностите на реда
                totalSumChars += currentSumChars;

                line = reader.readLine();
            }

            System.out.println(totalSumChars);

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
