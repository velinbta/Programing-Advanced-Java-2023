package StacksQueues;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String childrenNames = scanner.nextLine();
        int toss = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> priorityNamesQueue = new PriorityQueue<>(); // <- Подреждам имената в приоритетна опашка
        Arrays.stream(childrenNames.split("\\s+")).forEach(e -> priorityNamesQueue.offer(e));

        int loop = 1; // <- Брояч на циклите

        while (priorityNamesQueue.size() > 1) { // <- Докато не остане само 1 дете

            for (int i = 0; i < toss - 1; i++) { // <- Броенето започва от първото дете (-1)

                priorityNamesQueue.offer(priorityNamesQueue.poll());

            }

            if (isPrime(loop)) { // <- Ако цикълът е просто число

                System.out.printf("Prime %s\n", priorityNamesQueue.peek());

            } else { // <- Ако не е "просто число", като по условие подвеждат с "1" - "водят го composite"

                System.out.printf("Removed %s\n", priorityNamesQueue.poll());

            }

            loop++;

        }

        System.out.printf("Last is %s\n", priorityNamesQueue.poll()); // <- Последния останал

    }

    private static boolean isPrime(int n) {

        if (n <= 1) {

            return false;

        } else {

            for (int i = 2; i < n; i++) {

                if (n % i == 0) {

                    return false;

                }

            }

        }

        return true;

    }

}
