package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> recursiveQueue = new ArrayDeque<>(); // <- Последните две числа от поредицата
        recursiveQueue.offer(1L);
        recursiveQueue.offer(1L);

        long last = 1; // <- Желанато число
        for (int i = 0; i < n - 1; i++) {

            Long getFirst = recursiveQueue.poll();

            if (getFirst != null) {

                Long result = getFirst + last; // <- Събирам последните две числа
                recursiveQueue.offer(result);
                last = result;

            }

        }

        System.out.println(last);

    }

}
