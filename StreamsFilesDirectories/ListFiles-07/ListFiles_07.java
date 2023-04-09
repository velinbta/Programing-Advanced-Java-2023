package StreamsFilesDirectories;

import java.io.File;
import java.util.Arrays;

public class ListFiles_07 {
    public static void main(String[] args) {

        String path = "StreamsFilesDirectories/ListFiles-07/Files-and-Streams";

        try {

            File file = new File(path);
            File[] filesArr = file.listFiles(f -> f.isFile()); // <- Масив, само от файловете

            Arrays.stream(filesArr).forEach(f ->
                    System.out.printf("%s: [%d]\n", f.getName(), f.length())); // <- Име, големина

        } catch (NullPointerException e) {

            System.out.println("No files available"); // <- Ако не намери папки

        }

    }

}

