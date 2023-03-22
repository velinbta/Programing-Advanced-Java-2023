package SetsMaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитам списък и сортирам елементите в намаляващ ред, като ги ограничавам до 3
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(n -> Integer.parseInt(n)).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());

        numbersList.forEach(n -> System.out.print(n + " "));

    }

}
