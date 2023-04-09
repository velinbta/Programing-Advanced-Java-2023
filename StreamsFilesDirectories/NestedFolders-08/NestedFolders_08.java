package StreamsFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders_08 {
    public static void main(String[] args) {

        String repositoryPath = "StreamsFilesDirectories/NestedFolders-08/Files-and-Streams";

        try {

            File root = new File(repositoryPath); // <- Започвам от корена

            Deque<File> directoriesQueue = new ArrayDeque<>();
            directoriesQueue.offer(root); // <- Добавям корена в опашка

            int count = 1; // <- Броя от корена и другите директории
            while (!directoriesQueue.isEmpty()) {

                // Изваждам добавения и създавам масив от файлове (от него)
                File currentFile = directoriesQueue.poll();
                File[] innerFiles = currentFile.listFiles();

                for (File innerFile : innerFiles) {
                    // Обхождам и ги добавям, ако са директории
                    if (innerFile.isDirectory()) {

                        directoriesQueue.offer(innerFile);
                        count++;
                    }

                }

                System.out.println(currentFile.getName()); // <- Принтирам текущия файл

            }

            System.out.printf("%d folders\n", count);

        } catch (NullPointerException e) {

            System.out.println("Directory not found, please review source!");

        }

    }

}


