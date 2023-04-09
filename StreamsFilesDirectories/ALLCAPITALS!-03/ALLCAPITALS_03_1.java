package StreamsFilesDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ALLCAPITALS_03_1 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/ALLCAPITALS!-03/input.txt";
        String outPath = "StreamsFilesDirectories/ALLCAPITALS!-03/ALLCAPITALS_03_1_output.txt";

        try (PrintWriter writer = new PrintWriter(outPath)) {

            // Прочитам всички редове и правя буквите главни
            List<String> upperList = Files.readAllLines(Paths.get(inPath)).stream().map(e -> e.toUpperCase())
                    .collect(Collectors.toList());

            upperList.forEach(line -> writer.println(line)); // <- Записвам/принтирам изходните данни, ред по ред

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
