package StreamsFilesDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines_06_2 {
    public static void main(String[] args) {

        Path inPath = Paths.get("StreamsFilesDirectories/SortLines-06/input.txt");
        Path outPath = Paths.get("StreamsFilesDirectories/SortLines-06/SortLines_06_2_output.txt");

        try {
            // Прочитам всички редове и махам празните, сортирам файла и го съхранявам в списък
            List<String> linesList = Files.readAllLines(inPath).stream().filter(line -> !line.isBlank())
                    .sorted().collect(Collectors.toList());

            Files.write(outPath, linesList); // <- Записвам цялата информация

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
