package Threeuple_11_1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Три Generic Threeuple<>, съдържащи различни обекти
        String[] data = readArray(scanner);
        String name = String.format("%s %s", data[0], data[1]);
        String address = data[2];
        String town = data[3];

        // First
        Threeuple<String, String, String> nameAddressTown = new Threeuple<>(name, address, town);

        data = readArray(scanner);
        name = data[0];
        int litersBeer = Integer.parseInt(data[1]);
        boolean isDrunk = data[2].equals("drunk");

        // Second
        Threeuple<String, Integer, Boolean> nameLitersBeerDrunk = new Threeuple<>(name, litersBeer, isDrunk);

        data = readArray(scanner);
        name = data[0];
        double accountBalance = Double.parseDouble(data[1]);
        String bank = data[2];

        // Third
        Threeuple<String, Double, String> nameBalanceBank = new Threeuple<>(name, accountBalance, bank);

        String output = getOutput(nameAddressTown, nameLitersBeerDrunk, nameBalanceBank);
        System.out.println(output);

    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String getOutput(Threeuple... threeuples) {
        // Форматира изходните данни
        StringBuilder output = new StringBuilder();
        IntStream.range(0, threeuples.length).forEach(index -> {
            output.append(threeuples[index]);
            if (index != threeuples.length - 1) {
                output.append(System.lineSeparator());
            }
        });

        return output.toString();
    }

}
