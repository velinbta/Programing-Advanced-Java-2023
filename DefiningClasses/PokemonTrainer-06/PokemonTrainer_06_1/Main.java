package PokemonTrainer_06_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainerList = getTrainers(scanner);

        String element = scanner.nextLine();

        while (!element.equals("End")) {

            String finalElement = element;

            trainerList.forEach(trainer -> {

                // Ако треньорът, съдържа поне един покемон с този елемент
                if (trainer.containsAtLeastOnePokemonWithGivenElement(finalElement)) {
                    trainer.increaseBadges(); // <- +1
                } else {
                    trainer.decreasePokemonsHealthBy10AndRemoveIfBelow1(); // <- -10
                }

            });

            element = scanner.nextLine();
        }

        // Сортирам по значки в низходящ ред
        trainerList.stream().sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(System.out::println);

    }

    private static List<Trainer> getTrainers(Scanner scanner) {
        // Добавя треньорите (уникални имена) и вътрешната им колекция от покемони
        List<Trainer> trainerList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] trainerData = input.split("\\s+");
            String trainerName = trainerData[0];
            String pokemonName = trainerData[1];
            String element = trainerData[2];
            int health = Integer.parseInt(trainerData[3]);

            // Филтрира и взима треньора, ако има такъв
            Trainer trainer = trainerList.stream().filter(tr -> tr.getName().equals(trainerName))
                    .findFirst().orElse(null);

            if (trainer == null) {
                trainer = new Trainer(trainerName); // <- Ако няма го създава
                trainerList.add(trainer);
            }

            // Добавя покемона към списъка на треньора
            trainer.addPokemon(new Pokemon(pokemonName, element, health));

            input = scanner.nextLine();
        }

        return trainerList;
    }

}
