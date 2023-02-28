package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesOfInput = Integer.parseInt(scanner.nextLine());

        StringBuilder textBuilder = new StringBuilder(); // <- Отначало празен текст
        Deque<String> textStack = new ArrayDeque<>(); // <- Undo/предишен текст

        for (int i = 0; i < linesOfInput; i++) {

            String[] commandArr = scanner.nextLine().split("\\s+");

            // Командата е на 0 позиция, търся по нея
            String command = commandArr[0];
            switch (command) {

                case "1":

                    String text = commandArr[1]; // <- Текст на позиция 1
                    textBuilder.append(text);
                    textStack.push(textBuilder.toString());

                    break;

                case "2":

                    int countElements = Integer.parseInt(commandArr[1]); // <- Брои елементи
                    int length = textBuilder.length();

                    if (countElements > 0 && countElements <= length) { // <- Ако са в рамките на текста

                        int startingIndex = length - countElements;
                        textBuilder.delete(startingIndex, length); // <- Трия последните букви от текста
                        textStack.push(textBuilder.toString());

                    }

                    break;

                case "3":

                    int index = Integer.parseInt(commandArr[1]) - 1; // <- Индекс

                    if (index >= 0 && index < textBuilder.length()) { // <- Ако е в рамките, принтирам буквата

                        System.out.println(textBuilder.charAt(index));

                    }

                    break;

                case "4":

                    if (!textStack.isEmpty()) { // <- Ако има предишни версии на текста

                        textStack.pop();

                        textBuilder = textStack.isEmpty()
                                ? new StringBuilder() // <- Нова стойност - празен StringBuilder
                                : new StringBuilder(textStack.peek()); // <- Предишната версия на текста

                    }

                    break;

            }

        }

    }

}
