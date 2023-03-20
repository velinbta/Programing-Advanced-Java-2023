package SetsMaps;

import java.util.*;

public class SoftUniParty_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guests = scanner.nextLine();

        // Попълвам поканените гости
        Set<String> invitationSet = fillInGuestStringHashSet(scanner, guests, "PARTY");

        guests = scanner.nextLine();

        // Попълвам гостите, които са дошли на партито
        Set<String> appearedSet = fillInGuestStringHashSet(scanner, guests, "END");

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
