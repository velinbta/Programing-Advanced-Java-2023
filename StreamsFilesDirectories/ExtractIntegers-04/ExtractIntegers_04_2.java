package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04_2 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/ExtractIntegers-04/input.txt";
        String outPath = "StreamsFilesDirectories/ExtractIntegers-04/ExtractIntegers_04_2_output.txt";

        try {

            Scanner scanner = new Scanner(new FileInputStream(inPath));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(outPath));

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {

                    printWriter.println(scanner.nextInt()); // <- Записвам всяко намерено число

                }

                scanner.next();
            }

            // Затварям входни и изходни потоци
            scanner.close();
            printWriter.close();

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
