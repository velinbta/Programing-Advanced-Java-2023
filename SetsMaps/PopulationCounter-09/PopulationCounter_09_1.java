package SetsMaps;

import java.util.*;

public class PopulationCounter_09_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> countryCityPopulationMap = new LinkedHashMap<>(); // <- Дължава, град, популация
        Map<String, Long> countryTotalPopulationMap = new LinkedHashMap<>(); // <- Дължава, обща популация

        while (!input.equals("report")) {

            String[] infoArr = input.split("\\|");

            String city = infoArr[0];
            String country = infoArr[1];
            // Дадено е 2 000 000 000 максимум за всеки град, събрани градовете надвишава Integer.MAX.VAlUE
            long population = Long.parseLong(infoArr[2]);

            // Въвеждам данните в маповете
            countryCityPopulationMap.putIfAbsent(country, new LinkedHashMap<>());
            countryCityPopulationMap.get(country).putIfAbsent(city, population);

            countryTotalPopulationMap.putIfAbsent(country, 0L);
            countryTotalPopulationMap.put(country, countryTotalPopulationMap.get(country) + population); // <- Общо

            input = scanner.nextLine();

        }

        countryTotalPopulationMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(values -> values.getValue())))
                .forEach(country -> { // <- По обща населеност, на всяка една държава

                    System.out.printf("%s (total population: %d)\n", country.getKey(), country.getValue());

                    // По населеност на всеки един град в намаляващ ред, или равни - в ред на добавяне
                    countryCityPopulationMap.get(country.getKey()).entrySet().stream()
                            .sorted(Collections.reverseOrder(Comparator.comparing(values -> values.getValue())))
                            .forEach(city -> System.out.printf("=>%s: %d\n", city.getKey(), city.getValue()));

                });

    }

}
