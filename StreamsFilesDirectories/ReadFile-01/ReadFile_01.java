package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_01 {
    public static void main(String[] args) {

        String path = "StreamsFilesDirectories/ReadFile-01/input.txt"; // <- Път към файла

        // Затваря автоматично, когато приключи
        try (FileInputStream fileInputStream = new FileInputStream(path)) {

            int oneByte = fileInputStream.read(); // <- Прочитам всеки един байт

            while (oneByte != -1) { // <- Докато текстът не свърши

                System.out.print(Integer.toBinaryString(oneByte) + " "); // <- Двуична репрезентация на всеки байт

                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
