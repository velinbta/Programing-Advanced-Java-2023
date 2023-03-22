package SetsMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbersArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(n -> Double.parseDouble(n)).toArray();

        Map<Double, Integer> numbersOccurrencesMap = new LinkedHashMap<>();

        for (double number : numbersArr) {
            // Слагам в Map, стойностите от масива, ако липсват с първоначална нулева стойност
            numbersOccurrencesMap.putIfAbsent(number, 0);
            // При всяко следващо срещане увеличавам броят им с 1
            numbersOccurrencesMap.put(number, numbersOccurrencesMap.get(number) + 1);

        }

        for (Map.Entry<Double, Integer> entry : numbersOccurrencesMap.entrySet()) {

            System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue());

        }

    }

}
