package FunctionalProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int divisibleOption = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();
        // Премахвам всички числа, които се делят на даденото число и ги запаметявам в Stack
        Arrays.stream(input.split("\\s+")).map(Integer::parseInt)
                .filter(n -> n % divisibleOption != 0).forEach(stack::push);

        stack.forEach(n -> System.out.print(n + " "));

    }

}
