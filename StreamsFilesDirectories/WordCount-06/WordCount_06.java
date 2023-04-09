package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount_06 {
    public static void main(String[] args) {

        String wordPath = "StreamsFilesDirectories/WordCount-06/words.txt";
        String textPath = "StreamsFilesDirectories/WordCount-06/text.txt";
        String outputPath = "StreamsFilesDirectories/WordCount-06/results.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(textPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            List<String> wordsList = getAllWordsFromTextFile(wordPath); // <- Всички думи, който трябва да се проверят
            Map<String, Integer> wordsOccurrencesMap = new HashMap<>();
            wordsList.forEach(word -> wordsOccurrencesMap.put(word, 0)); // <- Записвам думите в Map

            String line = reader.readLine();

            while (line != null) {
                // Прочитам ред по ред и премахвам всичко, което не е дума
                List<String> lineList = Arrays.stream(line.replaceAll("[^A-Za-z ]", "")
                        .split("\\s+")).collect(Collectors.toList());

                lineList.forEach(word -> { // <- Преброявам думите
                    if (wordsOccurrencesMap.containsKey(word)) {
                        wordsOccurrencesMap.put(word, wordsOccurrencesMap.get(word) + 1);
                    }
                });

                line = reader.readLine();
            }

            wordsOccurrencesMap.entrySet().stream() // <- Сортирам и записвам думите в намаляващ ред
                    .sorted(Collections.reverseOrder(Comparator.comparing(w -> w.getValue()))).
                    forEach(word -> writer.printf("%s - %d\n", word.getKey(), word.getValue()));

        } catch (IOException e) {

            System.out.println("File not found, please review source!");

        }

    }

    private static List<String> getAllWordsFromTextFile(String path) {
        // Съхранява в списък всички думи от текстовия файл
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();

            while (line != null) { // <- Може да пристигнат повече редове

                // Добавя всички думи от текстовия файл, като премахва всичко, което не е буква или празно място
                wordsList.addAll(Arrays.stream(line.replaceAll("[^A-Za-z ]", "")
                        .split("\\s+")).collect(Collectors.toList()));

                line = reader.readLine();
            }

        } catch (IOException e) {

            return wordsList;

        }

        return wordsList;
    }

}
