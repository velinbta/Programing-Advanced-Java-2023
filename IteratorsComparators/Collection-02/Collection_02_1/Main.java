package Collection_02_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String... varargs) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ListyIterator<String> iterator = new ListyIterator<>();

        while (!input.equals("END")) {

            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {

                case "Create":
                    // Създава нов ListyIterator с varargs
                    String[] elements = Arrays.copyOfRange(data, 1, data.length);
                    iterator = new ListyIterator<>(elements);

                    break;

                case "Move":
                    // Премества вътрешния индекс, ако има следващ елемент
                    System.out.println(iterator.move());

                    break;

                case "Print":

                    iterator.printCurrentIndex();

                    break;

                case "HasNext":

                    System.out.println(iterator.hasNext());

                    break;

                case "PrintAll":

                    iterator.printAll();

                    break;

            }

            input = scanner.nextLine();

        }

    }

}
