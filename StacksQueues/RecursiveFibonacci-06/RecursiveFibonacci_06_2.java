package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> recursiveQueue = new ArrayDeque<>(); // <- Последните две числа от поредицата
        recursiveQueue.offer(1L);
        recursiveQueue.offer(1L);

        for (int i = 0; i < n; i++) {
            // Събирам последните две числа
            Long sumOfLastTwoInQueue = recursiveQueue.stream().mapToLong(e -> e).sum();
            recursiveQueue.offer(sumOfLastTwoInQueue);
            recursiveQueue.poll(); // <- Махам първото

        }

        System.out.println(recursiveQueue.poll()); // <- Желаното n-число

    }

}
