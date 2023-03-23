package SetsMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Set<String> usernamesSet = new LinkedHashSet<>();

        while (lines-- > 0) {
            // Прочитам имената и ги добавям, по ред на прочитане, в Set
            String username = scanner.nextLine();
            usernamesSet.add(username);

        }

        usernamesSet.forEach(username -> System.out.println(username));

    }

}
