package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes_04_1 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/CountCharacterTypes-04/input.txt";
        String outPath = "StreamsFilesDirectories/CountCharacterTypes-04/CountCharacterTypes_04_1_output.txt";

        try (FileInputStream in = new FileInputStream(inPath);
             PrintWriter out = new PrintWriter(outPath)) {

            int bytes = in.read();

            Set<Character> skipSet = new HashSet<>(Set.of(' ', '\n', '\r'));
            Set<Character> vowelsSet = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
            Set<Character> punctuationSet = new HashSet<>(Set.of('!', ',', '.', '?'));

            long vowelsCount = 0L;
            long otherSymbolsCount = 0L;
            long punctuationCount = 0L;

            while (bytes != -1) {

                char currentCh = (char) bytes;

                if (!skipSet.contains(currentCh)) { // <- Ако не е празно място или нов ред

                    boolean isVowel = vowelsSet.contains(currentCh); // <- гласна
                    boolean isPunctuation = punctuationSet.contains(currentCh); // <- пунктуационен знак

                    if (isVowel) {

                        vowelsCount++;

                    } else if (isPunctuation) {

                        punctuationCount++;

                    } else {

                        otherSymbolsCount++;

                    }

                }

                bytes = in.read();
            }

            // Принтирам преброените в изходния файл
            out.printf("Vowels: %d\n", vowelsCount);
            out.printf("Other symbols: %d\n", otherSymbolsCount);
            out.printf("Punctuation: %d\n", punctuationCount);

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
