package StreamsFilesDirectories;

import java.io.*;

public class ALLCAPITALS_03_2 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/ALLCAPITALS!-03/input.txt";
        String outPath = "StreamsFilesDirectories/ALLCAPITALS!-03/ALLCAPITALS_03_2_output.txt";

        try (FileInputStream in = new FileInputStream(inPath);
             FileOutputStream out = new FileOutputStream(outPath)) {

            int bytes = in.read(); // <- Байт по байт

            while (bytes != -1) {

                char currentCh = (char) bytes;

                if (Character.isLetter(currentCh)) { // <- Ако е буква

                    // Записвам я като главна
                    char upperCase = Character.toUpperCase(currentCh);
                    out.write(upperCase);

                } else {

                    out.write(currentCh); // <- Всичко друго, презаписвам в новия файл

                }

                bytes = in.read();
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
