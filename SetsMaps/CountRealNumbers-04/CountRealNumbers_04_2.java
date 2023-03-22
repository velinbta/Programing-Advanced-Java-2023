package SetsMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] inputArr = readDoubleArray(scanner);

        Map<Double, Integer> numbersOccurrenceMap = new LinkedHashMap<>();

        // Слагам в Map, стойностите от масива, ако липсват с първоначална нулева стойност
        Arrays.stream(inputArr).forEach(n -> numbersOccurrenceMap.putIfAbsent(n, 0));
        // При всяко следващо срещане увеличавам броят им с 1
        Arrays.stream(inputArr).forEach(n -> numbersOccurrenceMap.put(n, numbersOccurrenceMap.get(n) + 1));

        numbersOccurrenceMap.entrySet().forEach(entry ->
                System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue()));

    }

    private static double[] readDoubleArray(Scanner scanner) {
        // Прочита double[] от конзолата
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(n -> Double.parseDouble(n)).toArray();

    }

}
