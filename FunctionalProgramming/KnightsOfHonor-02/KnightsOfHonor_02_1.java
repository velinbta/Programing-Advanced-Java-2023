package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor_02_1 {
    public static void main(String[] args) {

        List<String> wordsList = Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+")).collect(Collectors.toList());

        List<String> modifiedList = new ArrayList<>();

        // Добавям и презаписвам в нов списък
        Consumer<List<String>> modifier = addSirInFrontOfEveryWordAndAddToOtherList(modifiedList);
        modifier.accept(wordsList);

        // Принтирам новия списък
        Consumer<List<String>> printer = list -> list.forEach(System.out::println);
        printer.accept(modifiedList);

    }

    private static Consumer<List<String>> addSirInFrontOfEveryWordAndAddToOtherList(List<String> modifiedList) {
        // Добавя "Sir " пред всяка дума и презаписва в нов лист по избор
        return list -> list.stream().map(w ->

                w = new StringBuilder(w).insert(0, "Sir ").toString()

        ).forEach(modifiedList::add);

    }

}
