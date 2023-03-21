package SetsMaps;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesOfInput = Integer.parseInt(scanner.nextLine());

        // Континенти, държави и списък с градовете
        Map<String, Map<String, List<String>>> continentCountryCityMap = new LinkedHashMap<>();

        for (int i = 0; i < linesOfInput; i++) {
            // Отделям входните данни на променливи
            String[] inputArr = scanner.nextLine().split("\\s+");
            String continent = inputArr[0];
            String country = inputArr[1];
            String city = inputArr[2];

            // Ако го няма континента, го записвам и слагам нов LinkedHashMap
            continentCountryCityMap.putIfAbsent(continent, new LinkedHashMap<>());
            // Ако на континента, няма такава държава я добавям и слагам нов списък
            continentCountryCityMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentCountryCityMap.get(continent).get(country).add(city); // <- Добавям и градовете

        }

        continentCountryCityMap.entrySet().forEach(continent -> { // <- За всеки континент

            System.out.printf("%s:\n", continent.getKey());

            continent.getValue().entrySet().forEach(country -> { // <- За всека държава

                System.out.printf("%s -> ", country.getKey());
                System.out.printf("%s\n", country.getValue().toString()
                        .replaceAll("[\\[\\]]", "")); // <- Градовете

            });

        });

    }

}
