package CustomListIterator_09_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")) {

            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {

                case "Add": {

                    String element = data[1];
                    list.add(element);

                }
                break;

                case "Remove": {

                    int index = Integer.parseInt(data[1]);
                    list.remove(index);

                }
                break;

                case "Contains": {

                    String element = data[1];
                    System.out.println(list.contains(element));

                }
                break;

                case "Swap": { // <- Разменя местата на два индекса в списъка

                    int firstIndex = Integer.parseInt(data[1]);
                    int secondIndex = Integer.parseInt(data[2]);
                    list.swap(firstIndex, secondIndex);

                }
                break;

                case "Greater": { // <- Принтира, колко са по-големи от дадения елемент

                    String element = data[1];
                    System.out.println(list.countGreaterThan(element));

                }
                break;

                case "Max": // <- Най-голямото

                    System.out.println(list.getMax());

                    break;

                case "Min": // <- Най-малкото

                    System.out.println(list.getMin());

                    break;

                case "Sort": // <- Сортира елементите в нарастващ ред

                    Sorter.sort(list);

                    break;

                case "Print":

                    list.forEach(System.out::println);

                    break;

                default:
                    throw new IllegalArgumentException(String.format("Invalid command \"%s\"", command));

            }

            input = scanner.nextLine();
        }

    }

}
