package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge_05_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> nameAgeMap = new LinkedHashMap<>();

        IntStream.range(0, lines).forEach(line -> { // <- Запълвам Map с входните данни
            String[] info = scanner.nextLine().split(",\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            nameAgeMap.putIfAbsent(name, age);
        });

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        // Създавам и филтрирам нов Map според условието
        Map<String, Integer> filteredNameAgeMap = getNewFilteredMap(nameAgeMap, condition, age);

        // Принтирам според формата
        printResultsAccordingToTheFormat(filteredNameAgeMap, format);

    }

    private static Map<String, Integer> getNewFilteredMap(Map<String, Integer> nameAgeMap, String condition, int age) {
        // Филтрира и връща нов LinkedHashMap
        switch (condition) {

            case "older":

                return nameAgeMap.entrySet().stream().filter(e -> e.getValue() >= age)
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
                                (x, y) -> y, LinkedHashMap::new));

            case "younger":

                return nameAgeMap.entrySet().stream().filter(e -> e.getValue() <= age)
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
                                (x, y) -> y, LinkedHashMap::new));

            default:

                throw new IllegalArgumentException("\nPossible arguments are:\nolder\nyounger");

        }

    }

    private static void printResultsAccordingToTheFormat(Map<String, Integer> filteredNameAgeMap, String format) {
        // Принтира резултата според зададения формат
        switch (format) {

            case "name":

                filteredNameAgeMap.entrySet().forEach(e -> System.out.println(e.getKey()));
                break;

            case "age":

                filteredNameAgeMap.entrySet().forEach(e -> System.out.println(e.getValue()));
                break;

            case "name age":

                filteredNameAgeMap.entrySet().forEach(e ->
                        System.out.printf("%s - %d\n", e.getKey(), e.getValue()));

                break;

            default:

                throw new IllegalArgumentException("\nPossible formats are:\nname\nname age\nage");

        }

    }

}
