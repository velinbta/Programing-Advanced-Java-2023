package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory_01_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<String> historyStack = new ArrayDeque<>(); // <- Тук държа url адресите

        while (!input.equals("Home")) {

            if (input.equals("back")) { // <- Ако е "back"

                if (historyStack.size() < 2) { // <- Ако е останал само първоначално въведения адрес, или няма никакъв

                    System.out.println("no previous URLs");

                } else { // <- Ако размера е >= 2

                    historyStack.pop(); // <- Махам
                    System.out.println(historyStack.peek()); // <- Принтирам върха на стека

                }

            } else { // <- Ако е "нормална навигация"

                historyStack.push(input);
                System.out.println(historyStack.peek());

            }

            input = scanner.nextLine();

        }

    }

}