package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> fibonacciStack = new ArrayDeque<>(); // <- Последните две числа от поредицата
        fibonacciStack.push(0L);
        fibonacciStack.push(1L);

        for (int i = 0; i < n; i++) {

            // Събирам двете числа от поредицата n на брой пъти
            Long first = fibonacciStack.pop();
            Long second = fibonacciStack.pop();
            fibonacciStack.push(first);

            Long result = first + second;
            fibonacciStack.push(result);

        }

        System.out.println(fibonacciStack.pop()); // <- Желаното n-число

    }

}
