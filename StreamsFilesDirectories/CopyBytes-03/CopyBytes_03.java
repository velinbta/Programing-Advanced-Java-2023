package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyBytes_03 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/CopyBytes-03/input.txt"; // <- Вход
        String outPath = "StreamsFilesDirectories/CopyBytes-03/output.txt"; // <- Изход

        try (InputStream inputStream = new FileInputStream(inPath);
             OutputStream outputStream = new FileOutputStream(outPath)) {

            int oneByte = inputStream.read();

            while (oneByte != -1) {

                boolean isWhiteSpaceOrNewLine = (char) oneByte == ' ' || (char) oneByte == '\n';

                if (isWhiteSpaceOrNewLine) {

                    // Записвам и запазвам само празното място или новия ред
                    outputStream.write(oneByte);

                } else {

                    char[] digitsArr = String.valueOf(oneByte).toCharArray();

                    for (char digit : digitsArr) {

                        outputStream.write(digit); // <- Записвам всяка отделна цифра на ASCII кода

                    }

                }

                oneByte = inputStream.read();
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
