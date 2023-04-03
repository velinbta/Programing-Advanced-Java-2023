package SetsMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> nameEmailMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            String name = input;
            String email = scanner.nextLine();

            if (getValidEmail(email)) { // <- Ако е валиден, го добавям

                nameEmailMap.putIfAbsent(name, email);

            }

            input = scanner.nextLine();
        }

        nameEmailMap.entrySet().forEach(person ->
                System.out.printf("%s -> %s\n", person.getKey(), person.getValue()));

    }

    private static boolean getValidEmail(String email) {
        // Валидира email, не трябва да завършва на "us", "uk,", "com" - case insensitive
        int indexOfDot = email.lastIndexOf(".");
        String endOfEmail = email.substring(indexOfDot + 1).toLowerCase(); // <- След последната точка, до края

        return !endOfEmail.equals("us") && !endOfEmail.equals("uk") && !endOfEmail.equals("com");

    }

}
