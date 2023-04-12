package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class AddVAT_04_2 {
    public static void main(String[] args) {

        String line = new Scanner(System.in).nextLine();

        // Преобразувам ги към double, слагам им ДДС, форматирам и запазвам
        String[] vatArray = Arrays.stream(line.split(",\\s+")).mapToDouble(Double::parseDouble)
                .map(n -> n * 1.20).mapToObj(w -> String.format("%.2f", w)).toArray(String[]::new);

        System.out.println("Prices with VAT:");
        System.out.println(String.join(System.lineSeparator(), vatArray));

    }

}
