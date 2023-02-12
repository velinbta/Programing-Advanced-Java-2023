package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory_01_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // <- Първият input съдържа Home url, или може да е "back"

        Deque<String> urlDeque = new ArrayDeque<>(); // <- Тук държа url адресите

        while (!input.equals("Home")) {

            if (input.equals("back")) { // <- Ако input e "back"

                // Home url искам да остава, затова махам само ако размера е раличен
                // от 0 (празен) или от 1 (съдържа Home url)
                if (urlDeque.size() != 1 && urlDeque.size() != 0) {

                    urlDeque.pop(); // <- Махам
                    System.out.println(urlDeque.peek()); // <- Принтирам върха на стека

                } else { // <- Ако е само Home url

                    System.out.println("no previous URLs");

                }

            } else { // Ако не е "back"

                urlDeque.push(input); // <- Добавям адрес
                System.out.println(urlDeque.peek()); // <- Принтирам върха на стека - последния url

            }

            input = scanner.nextLine();

        }

    }

}
