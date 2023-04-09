package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SumLines_01_1 {
    public static void main(String[] args) {

        String path = "StreamsFilesDirectories/SumLines-01/input.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {

            int oneByte = in.read(); // <- Байт по байт

            List<Long> lineAsciiValuesList = new ArrayList<>();

            long count = 0;
            while (oneByte != -1) {

                if (oneByte == '\r') { // <- Carriage return, прочитам нов байт

                    oneByte = in.read();

                } else if (oneByte == '\n') { // <- На новия ред добавям към списъка и нулирам брояча

                    lineAsciiValuesList.add(count);
                    count = 0;
                    oneByte = in.read();

                } else { // <- Броя байтовете на реда

                    count += oneByte;
                    oneByte = in.read();

                }

            }

            lineAsciiValuesList.add(count); // <- Добавям последните преброени бойтове на реда
            lineAsciiValuesList.forEach(n -> System.out.println(n));

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
