package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci_06_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> fibonacciQueue = new ArrayDeque<>(); // <- Последните две числа от поредицата
        fibonacciQueue.offer(1L);
        fibonacciQueue.offer(1L);

        long last = 1; // <- Желаното n-число
        for (int i = 0; i < n - 1; i++) {

            Long getFirst = fibonacciQueue.poll();

            if (getFirst != null) {

                Long result = getFirst + last; // <- Събирам последните две числа
                fibonacciQueue.offer(result);
                last = result;

            }

        }

        System.out.println(last);

    }

}
