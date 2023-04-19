package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {

            String[] info = input.split("\\s+");
            String command = info[0];
            String condition = info[1];
            String letterCombination = info[2];

            Predicate<String> conditionFilter = getConditionPredicate(condition, letterCombination);

            switch (command) {

                case "Remove":

                    // Премахвам гостите, чиито имена започват или завършват с дадената комбинация
                    // или име различно от зададената дължина
                    guestsList = guestsList.stream().filter(conditionFilter.negate())
                            .collect(Collectors.toList());

                    break;

                case "Double":

                    // Филтрирам удвоените гости, отговарящи на условието и ги добавям обратно в списъка
                    guestsList.addAll(guestsList.stream().filter(conditionFilter)
                            .collect(Collectors.toList()));

                    break;

            }

            input = scanner.nextLine();

        }

        guestsList = guestsList.stream().sorted().collect(Collectors.toList()); // <- Сортирам ги

        String output = guestsList.isEmpty()
                ? "Nobody is going to the party!"
                : String.format("%s are going to the party!", String.join(", ", guestsList));

        System.out.println(output);

    }

    private static Predicate<String> getConditionPredicate(String condition, String letterCombination) {
        // Филтър за гости с имена от зададената комбинация или дължина
        switch (condition) {

            case "StartsWith":
                return w -> w.startsWith(letterCombination);
            case "EndsWith":
                return w -> w.endsWith(letterCombination);
            case "Length":
                int length = Integer.parseInt(letterCombination);
                return w -> w.length() == length;
            default:
                throw new IllegalArgumentException("Use:\nStartsWith\nEndsWith\nLength");

        }

    }

}
