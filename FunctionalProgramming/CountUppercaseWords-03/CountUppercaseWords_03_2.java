package FunctionalProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03_2 {
    public static void main(String[] args) {

        String line = new Scanner(System.in).nextLine();
        Predicate<String> isUpperCase = w -> Character.isUpperCase(w.charAt(0));

        Deque<String> wordsQueue = Arrays.stream(line.split("\\s+")).filter(isUpperCase)
                .collect(Collectors.toCollection(ArrayDeque::new)); // <- Само думите с главни букви

        System.out.println(wordsQueue.size());
        wordsQueue.forEach(System.out::println);

    }

}
