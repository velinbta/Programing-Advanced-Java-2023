package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory_01_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // <- Първият input съдържа Home url, или може да е "back"

        String homeUrl = null;

        Deque<String> urlStack = new ArrayDeque<>(); // <- Тук държа url адресите

        while (!input.equals("Home")) {

            if (input.equals("back")) {  // <- Ако input e "back"

                if (homeUrl != null) { // <- В случай, че ми се подаде back, още отначало

                    if (!urlStack.isEmpty()) {

                        // Премахвам върха на стека, и пак питам дали е празен
                        urlStack.pop();

                        if (!urlStack.isEmpty()) {

                            System.out.println(urlStack.peek());

                        } else { // <- Ако е празен

                            System.out.println("no previous URLs");
                            urlStack.push(homeUrl); // <- Задавам му обратно Home url на върха

                        }

                    }

                } else { // <- В случай, че ми се подаде back, още отначало

                    System.out.println("no previous URLs");

                }

            } else { // Ако input не е "back"

                if (homeUrl == null) { // <- Задавам Home url
                    homeUrl = input;
                }

                System.out.println(input);
                urlStack.push(input);

            }

            input = scanner.nextLine();

        }

    }

}
