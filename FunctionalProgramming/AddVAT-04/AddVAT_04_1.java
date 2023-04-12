package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT_04_1 {
    public static void main(String[] args) {

        String line = new Scanner(System.in).nextLine();

        double[] noVatPrices = Arrays.stream(line.split(",\\s+")).mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> vatPrice = n -> n * 1.20; // <- ДДС

        System.out.println("Prices with VAT:");
        Arrays.stream(noVatPrices).forEach(n ->
                System.out.printf("%.2f\n", vatPrice.apply(n))); // <- Към всяко число прибавям ДДС

    }

}
