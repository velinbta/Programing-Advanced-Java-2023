package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes_04_2 {
    public static void main(String[] args) {

        String inPath = "StreamsFilesDirectories/CountCharacterTypes-04/input.txt";
        String outPath = "StreamsFilesDirectories/CountCharacterTypes-04/CountCharacterTypes_04_2_output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));
             PrintWriter writer = new PrintWriter(outPath)) {

            String line = reader.readLine();

            long vowelsCount = 0L;
            long punctuationCount = 0L;
            long otherSymbolsCount = 0L;

            Set<Character> vowelsSet = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
            Set<Character> punctuationSet = new HashSet<>(Set.of('.', ',', '!', '?'));

            while (line != null) {
                // Филтрирам гласните, пункуацията и останалите символи на текущия ред и ги добавям към сбора
                long currentVowels = line.chars().filter(c -> vowelsSet.contains((char) c)).count();
                vowelsCount += currentVowels;

                long currentPunctuation = line.chars().filter(c -> punctuationSet.contains((char) c)).count();
                punctuationCount += currentPunctuation;

                long currentOtherSymbols = line.chars().filter(c -> !punctuationSet.contains((char) c))
                        .filter(c -> !vowelsSet.contains((char) c)).filter(c -> c != ' ').count();
                otherSymbolsCount += currentOtherSymbols;

                line = reader.readLine();
            }

            // Принтирам преброените в изходния файл
            writer.printf("Vowels: %d\n", vowelsCount);
            writer.printf("Other symbols: %d\n", otherSymbolsCount);
            writer.printf("Punctuation: %d\n", punctuationCount);

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

}
