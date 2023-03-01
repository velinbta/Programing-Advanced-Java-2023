package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses_05_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] parenthesesArr = scanner.nextLine().toCharArray();

        Deque<Character> openingBracketsStack = new ArrayDeque<>(); // <- Съхранявам отварящите скоби
        boolean isBalanced = true;

        for (char currentBracket : parenthesesArr) {

            if (isOpeningBracket(currentBracket)) { // <- Ако е отваряща скоба

                openingBracketsStack.push(currentBracket);

            } else { // <- Ако е друго

                if (!openingBracketsStack.isEmpty()) { // <- Ако стекът не е празен

                    char poppedBracket = openingBracketsStack.pop(); // <- Изваждам последния елемент

                    // Ако текущата затваряща скоба не намери другарче - отваряща - не са балансирани
                    if (poppedBracket == '(' && currentBracket != ')') {

                        isBalanced = false;
                        break;

                    } else if (poppedBracket == '{' && currentBracket != '}') {

                        isBalanced = false;
                        break;

                    } else if (poppedBracket == '[' && currentBracket != ']') {

                        isBalanced = false;
                        break;

                    }

                } else { // <- Ако стекът е празен, търся отваряща без затваряща - не са балансирани

                    isBalanced = false;
                    break;

                }

            }

        }

        String result = isBalanced
                ? "YES" : "NO";

        System.out.println(result);

    }

    private static boolean isOpeningBracket(char ch) {

        return ch == '(' || ch == '[' || ch == '{';

    }

}
