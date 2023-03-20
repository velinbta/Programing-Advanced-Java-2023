package SetsMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guests = scanner.nextLine();

        Set<String> invitationSet = new HashSet<>(); // <- Поканени гости

        // Попълвам поканените гости
        while (!guests.equals("PARTY")) {
            invitationSet.add(guests);
            guests = scanner.nextLine();
        }

        guests = scanner.nextLine();

        Set<String> appearedSet = new HashSet<>(); // <- Дошлите гости

        // Попълвам гостите, които са дошли на партито
        while (!guests.equals("END")) {
            appearedSet.add(guests);
            guests = scanner.nextLine();
        }

        Set<String> nonAppearedSet = new TreeSet<>(); // <- Гости, които не са дошли

        for (String guest : invitationSet) {

            if (!appearedSet.contains(guest)) { // <- Ако в дошлите гости, не се съдържат поканените
                nonAppearedSet.add(guest);
            }

        }

        System.out.println(nonAppearedSet.size()); // <- Брой на гости, който не са дошли
        for (String guest : nonAppearedSet) {
            // Принтирам тези, който не са дошли
            System.out.println(guest);
        }

    }

}
