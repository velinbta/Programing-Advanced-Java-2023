package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles_07 {
    public static void main(String[] args) {

        String firstFilePath = "StreamsFilesDirectories/MergeTwoFiles-07/inputOne.txt";
        String secondFilePath = "StreamsFilesDirectories/MergeTwoFiles-07/inputTwo.txt";
        String output = "StreamsFilesDirectories/MergeTwoFiles-07/output.txt";

        try (PrintWriter writer = new PrintWriter(output)) {

            // Прочитам и презаписвам двата файла
            readAndWriteOutput(firstFilePath, writer);
            readAndWriteOutput(secondFilePath, writer);

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

    private static void readAndWriteOutput(String path, PrintWriter writer) throws IOException {
        // Прочита байт по байт файла и презаписва информацията
        FileInputStream in = new FileInputStream(path);
        int oneByte = in.read();

        while (oneByte != -1) {

            writer.write((char) oneByte);

            oneByte = in.read();

        }

        writer.write(System.lineSeparator());
        in.close();

    }

}
