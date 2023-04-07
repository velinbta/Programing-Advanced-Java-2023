package StreamsFilesDirectories;

import java.io.*;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/WriteToFile-02/input.txt"; // <- Вход
        String outPath = "StreamsFilesDirectories/WriteToFile-02/output.txt"; // <- Изход

        try (InputStream inputStream = new FileInputStream(inPath);
             OutputStream outputStream = new FileOutputStream(outPath)) {

            Set<Character> punctuation = Set.of(',', '.', '!', '?');

            int oneByte = inputStream.read();

            while (oneByte != -1) {

                boolean isPunctuation = punctuation.contains((char) oneByte);

                if (!isPunctuation) { // <- Ако не е пунктуационен знак

                    outputStream.write(oneByte); // <- Записвам байт по байт в изходния поток

                }

                oneByte = inputStream.read();
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
