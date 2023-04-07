package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ExtractIntegers_04_1 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/ExtractIntegers-04/input.txt";
        String outPath = "StreamsFilesDirectories/ExtractIntegers-04/ExtractIntegers_04_1_output.txt";

        try (InputStream inputStream = new FileInputStream(inPath);
             OutputStream outputStream = new FileOutputStream(outPath)) {

            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {

                    char[] digitsArr = String.valueOf(scanner.nextInt()).toCharArray();

                    for (char digit : digitsArr) {

                        outputStream.write(digit); // <- Записвам чар по чар

                    }

                    outputStream.write('\n'); // <- Празно място

                }

                scanner.next();
            }


        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
