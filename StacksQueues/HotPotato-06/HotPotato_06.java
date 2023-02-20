package StacksQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String childrenNames = scanner.nextLine();
        int toss = Integer.parseInt(scanner.nextLine());

        Deque<String> namesQueue = new ArrayDeque<>();

        Arrays.stream(childrenNames.split("\\s+")).forEach(e -> namesQueue.offer(e));

        while (namesQueue.size() != 1) { // <- Докато не остане само 1 дете

            for (int i = 0; i < toss - 1; i++) { // <- Броенето започва от първото дете (-1)

                namesQueue.offer(namesQueue.peek());
                namesQueue.poll();

            }

            System.out.printf("Removed %s\n", namesQueue.poll()); // <- Махам, този в който е останал картофът

        }

        System.out.printf("Last is %s\n", namesQueue.poll()); // <- Последния останал

    }

}
