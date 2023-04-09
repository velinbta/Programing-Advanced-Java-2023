package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01_2 {
    public static void main(String[] args) {

        String path = "StreamsFilesDirectories/SumLines-01/input.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {

            String line = in.readLine(); // <- Ред

            while (line != null) {

                int sum = line.chars().sum(); // <- Сума, ascii стойностите на целия ред
                System.out.println(sum);

                line = in.readLine(); // <- Прочитам нов ред
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
