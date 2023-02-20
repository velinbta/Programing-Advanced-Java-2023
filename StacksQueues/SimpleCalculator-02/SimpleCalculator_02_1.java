package StacksQueues;

import java.util.Scanner;

public class SimpleCalculator_02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expressionArr = scanner.nextLine().split("\\s+");

        int result = Integer.parseInt(expressionArr[0]); // <- Първоначално е позиция 0 - първото число от масива

        for (int i = 1; i < expressionArr.length - 1; i++) {

            String expression = expressionArr[i];

            if (i % 2 != 0) { // <- Нечетна позиция е знак "-", "+"

                // В зависимост от знака, събирам или изваждам
                int nextNumber = Integer.parseInt(expressionArr[i + 1]);

                if (expression.equals("+")) {

                    result += nextNumber;

                } else if (expression.equals("-")) {

                    result -= nextNumber;

                }

            }

        }

        System.out.println(result);

    }

}
