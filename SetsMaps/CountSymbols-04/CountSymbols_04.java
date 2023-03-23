package SetsMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] symbolsArr = scanner.nextLine().toCharArray();

        Map<Character, Integer> symbolOccurrencesMap = new TreeMap<>();

        for (Character symbol : symbolsArr) {
            // Ако съм го видял за първи път, го поставям с 0 срещания
            // Всеки път увеличавам броя на срещанията
            symbolOccurrencesMap.putIfAbsent(symbol, 0);
            symbolOccurrencesMap.put(symbol, symbolOccurrencesMap.get(symbol) + 1);

        }

        symbolOccurrencesMap.entrySet().forEach(symbol ->
                System.out.printf("%c: %d time/s\n", symbol.getKey(), symbol.getValue()));

    }

}
