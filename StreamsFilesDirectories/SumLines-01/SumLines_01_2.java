package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01_2 {
    public static void main(String[] args) {

        String path = "StreamsFilesDirectories/SumLines-01/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine(); // <- Ред

            while (line != null) {

                long sum = line.chars().sum(); // <- Сума, ascii стойностите на целия ред
                System.out.println(sum);

                line = reader.readLine(); // <- Прочитам нов ред
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
