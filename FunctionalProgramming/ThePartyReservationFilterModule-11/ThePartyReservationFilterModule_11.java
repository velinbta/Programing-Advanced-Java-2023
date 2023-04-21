package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> applyFiltersSet = getSetOfFiltersToApply(scanner);

        for (String filter : applyFiltersSet) {

            String[] data = filter.split(";");
            String condition = data[0];
            String letterCombination = data[1];

            // Получавам Predicate<String> в зависимост от условието
            Predicate<String> conditionFilter = getConditionPredicate(condition, letterCombination);

            // Фиртрирам ги и презаписвам списъка
            guestsList = guestsList.stream().filter(conditionFilter).collect(Collectors.toList());

        }

        guestsList.forEach(guest -> System.out.print(guest + " "));

    }

    private static Set<String> getSetOfFiltersToApply(Scanner scanner) {
        // Добавя в Set всички филтри, които трябва да се приложат
        String command = scanner.nextLine();
        Set<String> applyFiltersSet = new HashSet<>();
        while (!command.equals("Print")) {

            int startIndex = command.indexOf(";") + 1; // <- Начален индекс
            String substring = command.substring(startIndex); // <- Подтекст

            if (command.contains("Add"))
                applyFiltersSet.add(substring);

            else if (command.contains("Remove"))
                applyFiltersSet.remove(substring); // <- Ако съществува го премахвам, за не го прилагам после

            else
                throw new IllegalArgumentException("Unknown command " + command);

            command = scanner.nextLine();
        }

        return applyFiltersSet;
    }

    private static Predicate<String> getConditionPredicate(String condition, String letterCombination) {
        // Връща Predicate<String> в зависимост от условието
        switch (condition) {

            case "Starts with": // <- Да не започват с дадената комбинация
                return w -> !w.startsWith(letterCombination);
            case "Ends with": // <- Да не завършват с дадената комбинация
                return w -> !w.endsWith(letterCombination);
            case "Length": // <- Всички с размер различен от дадената комбинация
                int length = Integer.parseInt(letterCombination);
                return w -> w.length() != length;
            case "Contains": // <- Всички, които не съдържат дадената комбинация
                return w -> !w.contains(letterCombination);
            default:
                throw new IllegalArgumentException("Unknown condition " + condition);

        }

    }

}
