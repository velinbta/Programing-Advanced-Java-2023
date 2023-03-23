package SetsMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> nameTelephonesMap = new HashMap<>();

        while (!input.equals("search")) {

            String name = input.split("-")[0]; // <- Име
            String phone = input.split("-")[1]; // <- Телефонен номер

            // Ако го срещна отново се задава нов телефонен номер
            nameTelephonesMap.put(name, phone);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            // Отговор на търсения абонат
            String response = nameTelephonesMap.containsKey(input)
                    ? String.format("%s -> %s\n", input, nameTelephonesMap.get(input))
                    : String.format("Contact %s does not exist.\n", input);

            System.out.print(response);

            input = scanner.nextLine();
        }

    }

}
