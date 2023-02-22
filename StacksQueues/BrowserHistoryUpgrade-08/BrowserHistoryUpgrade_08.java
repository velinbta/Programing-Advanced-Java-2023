package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<String> backStack = new ArrayDeque<>(); // <- back url адреси
        Deque<String> forwardStack = new ArrayDeque<>(); // <- forward url адреси

        while (!input.equals("Home")) {

            if (input.equals("back")) { // <- Ако е "back"

                if (backStack.size() < 2) { // <- Ако е останал само първоначално въведения адрес, или няма никакъв

                    System.out.println("no previous URLs");

                } else { // <- Ако размера е >= 2

                    forwardStack.push(backStack.pop()); // <- Слагам на върха на forwardStack
                    System.out.println(backStack.peek());

                }

            } else if (input.equals("forward")) { // <- Ако е "forward"

                if (forwardStack.isEmpty()) { // <- Ако няма предходни адреси

                    System.out.println("no next URLs");

                } else {

                    System.out.println(forwardStack.peek());
                    backStack.push(forwardStack.pop()); // <- Слагам на върха на backStack

                }

            } else { // <- Ако е "нормална навигация"

                backStack.push(input);
                System.out.println(backStack.peek());
                forwardStack.clear(); // <- Чистя изцяло forwardStack

            }

            input = scanner.nextLine();

        }

    }

}