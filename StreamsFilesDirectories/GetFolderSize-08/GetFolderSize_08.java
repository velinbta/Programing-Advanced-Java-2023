package StreamsFilesDirectories;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        String path = "StreamsFilesDirectories/GetFolderSize-08/Exercises Resources";

        try {

            File file = new File(path);
            File[] filesArr = file.listFiles(); // <- Масив от файловете

            long size = 0;
            for (File f : filesArr) { // <- Събирам им размера

                size += f.length();

            }

            System.out.printf("Folder size: %d\n", size);

        } catch (NullPointerException e) {

            System.out.println("Review source, directory not available or null!");

        }

    }

}
