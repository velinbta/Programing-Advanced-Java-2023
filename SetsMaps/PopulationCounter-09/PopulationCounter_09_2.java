package SetsMaps;

import java.math.BigInteger;
import java.util.*;

public class PopulationCounter_09_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // Държави, градове и популация
        Map<String, Map<String, Long>> countryCityPopulationMap = new LinkedHashMap<>();

        while (!input.equals("report")) {

            String[] infoArr = input.split("\\|");

            String city = infoArr[0];
            String country = infoArr[1];
            // Дадено е 2 000 000 000 максимум за всеки град, събрани градовете надвишава Integer.MAX.VAlUE
            long population = Long.parseLong(infoArr[2]);

            // Въвеждам изведените данни
            countryCityPopulationMap.putIfAbsent(country, new LinkedHashMap<>());
            countryCityPopulationMap.get(country).putIfAbsent(city, population);

            input = scanner.nextLine();

        }

        countryCityPopulationMap.entrySet().stream().sorted((left, right) -> {

            // Сравнявам ги по обща населеност на градовете, за всяка държава (във вложения Map)
            BigInteger leftResult = BigInteger.valueOf(left.getValue().entrySet().stream().mapToLong(e -> e.getValue()).sum());
            BigInteger rightResult = BigInteger.valueOf(right.getValue().entrySet().stream().mapToLong(e -> e.getValue()).sum());
            return rightResult.compareTo(leftResult); // <- descending order, или ред на въвеждане, ако са равни

        }).forEach(country -> {

            long totalPopulation = country.getValue().entrySet().stream().mapToLong(e -> e.getValue()).sum();
            System.out.printf("%s (total population: %d)\n", country.getKey(), totalPopulation);

            country.getValue().entrySet().stream() // <- За всеки един град по отделно в намаляващ ред
                    .sorted(Collections.reverseOrder(Comparator.comparing(e -> e.getValue())))
                    .forEach(city -> System.out.printf("=>%s: %d\n", city.getKey(), city.getValue()));

        });

    }

}
