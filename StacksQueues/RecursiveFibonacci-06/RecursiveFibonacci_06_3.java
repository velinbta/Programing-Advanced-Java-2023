package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci_06_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> fibonacciQueue = new ArrayDeque<>(); // <- Последните две числа от поредицата
        fibonacciQueue.offer(1L);
        fibonacciQueue.offer(1L);

        for (int i = 0; i < n; i++) {
            // Събирам последните две числа
            Long sumOfLastTwoInQueue = fibonacciQueue.stream().mapToLong(e -> e).sum();
            fibonacciQueue.offer(sumOfLastTwoInQueue);
            fibonacciQueue.poll(); // <- Махам първото

        }

        System.out.println(fibonacciQueue.poll()); // <- Желаното n-число

    }

}
