package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10_1 {
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

            switch (command) {

                case "Remove":
                    // Премахвам гостите, чиито имена започват или завършват с дадената комбинация
                    // или име различно от зададената дължина
                    Predicate<String> removeGuests = getRemovePredicate(condition, letterCombination);

                    guestsList = guestsList.stream().filter(removeGuests)
                            .collect(Collectors.toList());

                    break;

                case "Double":
                    // Филтрирам удвоените гости, отговарящи на условието и ги добавям обратно в списъка
                    Predicate<String> filterByCondition = getFilterPredicate(condition, letterCombination);

                    List<String> filtered = guestsList.stream().filter(filterByCondition)
                            .collect(Collectors.toList());

                    guestsList.addAll(filtered);

                    break;

            }

            input = scanner.nextLine();

        }

        String output = guestsList.isEmpty()
                ? "Nobody is going to the party!"
                : String.format("%s are going to the party!", // <- Сортираните гости
                guestsList.stream().sorted().collect(Collectors.joining(", ")));

        System.out.println(output);

    }

    private static Predicate<String> getRemovePredicate(String condition, String letterCombination) {
        // Филтър за гости с имена различни от зададената комбинация или дължина
        switch (condition) {

            case "StartsWith":
                return w -> !w.startsWith(letterCombination);
            case "EndsWith":
                return w -> !w.endsWith(letterCombination);
            case "Length":
                int length = Integer.parseInt(letterCombination); // <- Ако е дължина
                return w -> w.length() != length;
            default:
                throw new IllegalArgumentException("Use:\nStartsWith\nEndsWith\nLength");

        }

    }

    private static Predicate<String> getFilterPredicate(String condition, String letterCombination) {
        // Филтър за гости с имена от зададената комбинация или дължина
        switch (condition) {

            case "StartsWith":
                return w -> w.startsWith(letterCombination);
            case "EndsWith":
                return w -> w.endsWith(letterCombination);
            case "Length":
                int length = Integer.parseInt(letterCombination); // <- Ако е дължина
                return w -> w.length() == length;
            default:
                throw new IllegalArgumentException("Use:\nStartsWith\nEndsWith\nLength");

        }

    }

}
