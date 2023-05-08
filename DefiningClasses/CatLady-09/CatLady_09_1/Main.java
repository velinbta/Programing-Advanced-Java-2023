package CatLady_09_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Cat> catsCollection = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            Cat cat = getCatAccordingToBreed(data); // <- Нова котка според породата
            catsCollection.add(cat);

            input = scanner.nextLine();
        }

        String searchCat = scanner.nextLine();

        // Намирам желаната котка
        Cat desiredCat = catsCollection.stream().filter(cat -> cat.getName().equals(searchCat))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Cat does not exist: " + searchCat));

        System.out.println(desiredCat);

    }

    public static Cat getCatAccordingToBreed(String[] catData) {
        // Връща нова котка, според породата
        String breed = catData[0];
        String catName = catData[1];

        switch (breed) {

            case "Siamese":
                double earSize = Double.parseDouble(catData[2]);
                return new Siamese(catName, earSize);

            case "Cymric":
                double furLength = Double.parseDouble(catData[2]);
                return new Cymric(catName, furLength);

            case "StreetExtraordinaire":
                double decibels = Double.parseDouble(catData[2]);
                return new StreetExtraordinaire(catName, decibels);

            default:
                throw new IllegalArgumentException("Unknown breed: " + breed);

        }

    }

}
