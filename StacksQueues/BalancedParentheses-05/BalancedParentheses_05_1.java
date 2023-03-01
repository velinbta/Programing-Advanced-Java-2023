package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses_05_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] parenthesesArr = scanner.nextLine().toCharArray();

        Deque<Integer> typeFirstStack = new ArrayDeque<>(); // <- Първи вид скоби '{' '}'
        Deque<Integer> typeSecondStack = new ArrayDeque<>(); // <- Втори вид скоби '(' ')'
        Deque<Integer> typeThirdStack = new ArrayDeque<>(); // <- Трети вид скоби '[' ']'

        boolean isBalanced = true;

        for (int position = 0; position < parenthesesArr.length; position++) {

            char symbol = parenthesesArr[position]; // <- Текущ символ

            if (symbol == '{') {

                typeFirstStack.push(position);

            } else if (symbol == '}') { // <- Когато намеря затваряща '}'

                if (typeFirstStack.peek() != null) {

                    int result = position - typeFirstStack.pop();
                    if (result % 2 == 0) { // <- Ако получения резултат има остатък, не са "балансирани"
                        isBalanced = false;
                        break;
                    }

                } else { // <- Ако няма отваряща скоба

                    isBalanced = false;

                }

            } else if (symbol == '(') {

                typeSecondStack.push(position);

            } else if (symbol == ')') { // <- Когато намеря затваряща ')'

                if (typeSecondStack.peek() != null) {

                    int result = position - typeSecondStack.pop();
                    if (result % 2 == 0) { // <- Ако получения резултат има остатък, не са "балансирани"
                        isBalanced = false;
                        break;
                    }

                } else { // <- Ако няма отваряща скоба

                    isBalanced = false;

                }


            } else if (symbol == '[') {

                typeThirdStack.push(position);

            } else if (symbol == ']') { // <- Когато намеря затваряща ']'

                if (typeThirdStack.peek() != null) {

                    int result = position - typeThirdStack.pop();
                    if (result % 2 == 0) { // <- Ако получения резултат има остатък, не са "балансирани"
                        isBalanced = false;
                        break;
                    }

                } else { // <- Ако няма отваряща скоба

                    isBalanced = false;

                }

            }

        }

        String printResult = isBalanced
                ? "YES" : "NO";

        System.out.println(printResult);

    }

}
