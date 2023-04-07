package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers_04_3 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/ExtractIntegers-04/input.txt";
        String outPath = "StreamsFilesDirectories/ExtractIntegers-04/ExtractIntegers_04_3_output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inPath));
             PrintWriter out = new PrintWriter(new FileOutputStream(outPath))) {

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {

                    out.println(scanner.nextInt()); // <- Записвам всяко намерено число

                }

                scanner.next();
            }


        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
