package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expressionArr = scanner.nextLine().split("\\s+"); // <- Даден израз - infix

        Deque<String> operatorStack = new ArrayDeque<>(); // <- Оператори (+, -, *, /)
        Deque<String> expressionQueue = new ArrayDeque<>(); // <- postfix израз

        for (String currentElement : expressionArr) {

            if (currentElement.matches("[\\dA-Za-z]+")) { // <- Ако е цифра/и или буква

                expressionQueue.offer(currentElement);

            } else { // <- Ако е оператор

                if (currentElement.equals("(")) {

                    operatorStack.push(currentElement); // <- Първата отваряща я слагам в стека

                } else if (currentElement.equals(")")) {

                    if (!operatorStack.contains("(")) { // <- Ако не намеря отваряща, продължавам напред
                        continue;
                    }

                    while (!operatorStack.peek().equals("(")) { // <- Докато не намеря отваряща скоба

                        // Слагам в postfix израза - последния елемент на стека
                        expressionQueue.offer(operatorStack.pop());

                    }

                    operatorStack.pop(); // <- Махам отварящата скоба


                } else { // <- Ако не са скоби, значи са оператори

                    while (!operatorStack.isEmpty()) {

                        // Докато не изпразня стека с операторите, с метод определям предимството на операторите
                        // Ако текущия е по-малък или равен на оператора на върха, вкарвам в израза
                        if (getPrecedence(currentElement) <= getPrecedence(operatorStack.peek())) {

                            expressionQueue.offer(operatorStack.pop());

                        } else { // <- Ако е с по-голямо предимство

                            break;

                        }

                    }

                    operatorStack.push(currentElement); // <- Слагам текущия елемент в стека

                }

            }

        }

        while (!operatorStack.isEmpty()) { // <- Добавям останалите оператори накрая, ако има

            expressionQueue.offer(operatorStack.pop());

        }

        expressionQueue.forEach(e -> System.out.print(e + " ")); // <- postfix израза

    }

    private static int getPrecedence(String element) {

        if (element.equals("+") || element.equals("-"))

            return 1;

        else if (element.equals("*") || element.equals("/"))

            return 2;

        else

            return -1;

    }

}
