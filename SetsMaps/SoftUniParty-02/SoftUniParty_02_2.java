package SetsMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guestsSet = new TreeSet<>(); // Set с гостите

        // При "PARTY" - добавям, при "END" - премахвам
        operateWithSet(scanner, scanner.nextLine(), guestsSet, "PARTY");
        operateWithSet(scanner, scanner.nextLine(), guestsSet, "END");

        System.out.println(guestsSet.size()); // <- Брой на гости, който не са дошли
        guestsSet.forEach(guest -> System.out.println(guest));

    }

    private static void operateWithSet(Scanner scanner, String guests, Set<String> guestsSet, String command) {
        // Прочита от конзолата и според командата, добавя или премахва в Set
        while (!guests.equals(command)) {

            if (command.equals("PARTY"))
                guestsSet.add(guests);
            else if (command.equals("END"))
                guestsSet.remove(guests);

            guests = scanner.nextLine();
        }

    }

}
