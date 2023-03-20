package SetsMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carsSet = new LinkedHashSet<>(); // <- Съхранявам само уникални номера

        String data = scanner.nextLine();

        while (!data.equals("END")) {

            String carNumber = data.split(",\\s+")[1]; // <- Номер на автомобил

            if (data.contains("IN")) { // <- При "IN" - добавям

                carsSet.add(carNumber);

            } else if (data.contains("OUT")) { // <- При "OUT" - премахвам

                carsSet.remove(carNumber);

            }

            data = scanner.nextLine();
        }

        printOutput(carsSet);

    }

    private static void printOutput(Set<String> carsSet) {
        // Принтира изходните данни
        if (carsSet.isEmpty())
            System.out.println("Parking Lot is Empty"); // <- Ако е празен
        else
            carsSet.forEach(car -> System.out.println(car));
    }

}
