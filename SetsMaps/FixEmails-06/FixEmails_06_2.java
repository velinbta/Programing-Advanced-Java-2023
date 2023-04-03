package SetsMaps;

import java.util.*;

public class FixEmails_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> lastNameStack = new ArrayDeque<>();
        Map<String, String> nameEmailMap = new LinkedHashMap<>();
        while (!input.equals("stop")) {

            if (!input.contains("@")) { // <- Ако не съдържа "@" значи се подава име, добавям го в стек

                lastNameStack.push(input);

            } else if (getValidEmail(input) && !lastNameStack.isEmpty()) {
                // Ако email е валиден и стекът не е празен добавям името и email в Map
                nameEmailMap.putIfAbsent(lastNameStack.pop(), input);

            }

            input = scanner.nextLine();
        }

        nameEmailMap.entrySet().forEach(person ->
                System.out.printf("%s -> %s\n", person.getKey(), person.getValue()));

    }

    private static boolean getValidEmail(String email) {
        // Валидира email, не трябва да завършва на "us", "uk,", "com" - case insensitive
        String lowerCaseEmail = email.toLowerCase();
        return !lowerCaseEmail.endsWith(".us") && !lowerCaseEmail.endsWith(".uk") && !lowerCaseEmail.endsWith(".com");

    }

}
