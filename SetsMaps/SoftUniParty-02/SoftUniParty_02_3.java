package SetsMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Попълвам поканените гости
        Set<String> invitationSet = fillInGuestStringHashSet(scanner, scanner.nextLine(), "PARTY");

        // Попълвам гостите, които са дошли на партито
        Set<String> appearedSet = fillInGuestStringHashSet(scanner, scanner.nextLine(), "END");

        Set<String> nonAppearedSet = new TreeSet<>(); // <- Гости, които не са дошли
        invitationSet.forEach(guest -> {

            if (!appearedSet.contains(guest)) { // <- Ако в дошлите гости, не се съдържат поканените
                nonAppearedSet.add(guest);
            }

        });

        System.out.println(nonAppearedSet.size()); // <- Брой на гости, който не са дошли
        nonAppearedSet.forEach(guest -> System.out.println(guest));

    }

    private static Set<String> fillInGuestStringHashSet(Scanner scanner, String guests, String command) {
        // Попълва HashSet с гости
        Set<String> guestsSet = new HashSet<>();
        while (!guests.equals(command)) {

            guestsSet.add(guests);
            guests = scanner.nextLine();
        }

        return guestsSet;
    }

}
