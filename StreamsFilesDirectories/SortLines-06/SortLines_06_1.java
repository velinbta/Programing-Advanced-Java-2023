package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines_06_1 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/SortLines-06/input.txt";
        String outPath = "StreamsFilesDirectories/SortLines-06/SortLines_06_1_output.txt";

        try (PrintWriter printWriter = new PrintWriter(outPath)) {

            // Махам празните редове, сортирам файла и го съхранявам в списък
            List<String> sortedBlankFreeLinesList = new BufferedReader(new FileReader(inPath)).lines()
                    .filter(line -> !line.isBlank()).sorted().collect(Collectors.toList());

            // Прехвърлям всеки ред от списъка във новия файл
            sortedBlankFreeLinesList.forEach(line -> printWriter.println(line));

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
