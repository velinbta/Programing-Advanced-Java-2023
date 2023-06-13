package ExamsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> materialsStack = readStack(scanner);
        Deque<Integer> magicQueue = readQueue(scanner);

        Map<String, Integer> presentCountMap = getPresentMap(); // <- Подаръци

        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()) { // <- Докато, някоя структура не е празна

            int craftResult = materialsStack.peek() * magicQueue.peek();

            if (!isCraftingSuccessful(craftResult, presentCountMap, materialsStack, magicQueue)) {
                // При неуспешна изработка, данните се обработват по други критерии
                operateUnsuccessfulConditions(craftResult, materialsStack, magicQueue);
            }

        }

        // При изработени, двойка подаръци - "Doll" и "Wooden train" или "Teddy bear" и "Bicycle"
        boolean hasSuccessfullyCraftedAtLeastOnePairOfPresents = verifyPresents(presentCountMap);

        String output = getOutput(hasSuccessfullyCraftedAtLeastOnePairOfPresents, materialsStack,
                magicQueue, presentCountMap);

        System.out.print(output);

    }

    private static Deque<Integer> readStack(Scanner scanner) {
        // Прочита стек от терминала
        String input = scanner.nextLine();
        Deque<Integer> materialStack = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).
                forEach(materialStack::push);
        return materialStack;

    }

    private static Deque<Integer> readQueue(Scanner scanner) {
        // Прочита опашка от терминала
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static Map<String, Integer> getPresentMap() {
        // Въвежда подаръците с първоначални нулеви стойности
        Map<String, Integer> presentCountMap = new TreeMap<>();
        presentCountMap.put("Doll", 0);
        presentCountMap.put("Wooden train", 0);
        presentCountMap.put("Teddy bear", 0);
        presentCountMap.put("Bicycle", 0);

        return presentCountMap;
    }

    private static boolean isCraftingSuccessful(int craftResult, Map<String, Integer> presentCountMap,
                                                Deque<Integer> materialsStack, Deque<Integer> magicQueue) {
        // Проверява, дали резултатът е точен, за изработка на подарък
        // Ако е точен - изработва и премахва материал и "магия"
        switch (craftResult) {

            case 150:
                presentCountMap.put("Doll", presentCountMap.get("Doll") + 1);
                removeBothMaterialsAndMagicFromDeque(materialsStack, magicQueue);
                return true;

            case 250:
                presentCountMap.put("Wooden train", presentCountMap.get("Wooden train") + 1);
                removeBothMaterialsAndMagicFromDeque(materialsStack, magicQueue);
                return true;

            case 300:
                presentCountMap.put("Teddy bear", presentCountMap.get("Teddy bear") + 1);
                removeBothMaterialsAndMagicFromDeque(materialsStack, magicQueue);
                return true;

            case 400:
                presentCountMap.put("Bicycle", presentCountMap.get("Bicycle") + 1);
                removeBothMaterialsAndMagicFromDeque(materialsStack, magicQueue);
                return true;
        }

        return false; // <- Ако не е точен
    }

    private static void removeBothMaterialsAndMagicFromDeque(Deque<Integer> materialsStack, Deque<Integer> magicQueue) {
        // Премахва материал и "магия"
        materialsStack.pop();
        magicQueue.poll();
    }

    private static void operateUnsuccessfulConditions(int craftResult, Deque<Integer> materialsStack,
                                                      Deque<Integer> magicQueue) {

        if (craftResult < 0)
            // При резултат по-малък от 0 - събира материал и "магия", премахва ги и ги добавя към материалите
            materialsStack.push(materialsStack.pop() + magicQueue.poll());

        else if (craftResult > 0) {
            // При по-голям от 0 - премахва "магия" и на материала добавя +15
            magicQueue.poll();
            materialsStack.push(materialsStack.pop() + 15);

        } else { // <- Ако резултатът е 0
            // Проверява дали "магията" или материала са 0 и премахва (ако са равни на 0)
            if (magicQueue.peek().equals(0))
                magicQueue.poll();

            if (materialsStack.peek().equals(0))
                materialsStack.pop();

        }

    }

    private static boolean verifyPresents(Map<String, Integer> presentCountMap) {
        // Проверява дали успешно е изработена, някоя от двойките подаръци
        if (presentCountMap.get("Doll") > 0 && presentCountMap.get("Wooden train") > 0)
            return true;
        else
            return presentCountMap.get("Teddy bear") > 0 && presentCountMap.get("Bicycle") > 0;
    }

    private static String getOutput(boolean hasSuccessfullyCraftedAtLeastOnePairOfPresents,
                                    Deque<Integer> materialsStack, Deque<Integer> magicQueue,
                                    Map<String, Integer> presentCountMap) {
        // Билдва изходните данни:
        StringBuilder output = new StringBuilder();

        if (hasSuccessfullyCraftedAtLeastOnePairOfPresents)
            output.append("The presents are crafted! Merry Christmas!");
        else
            output.append("No presents this Christmas!");

        output.append(System.lineSeparator());

        if (!materialsStack.isEmpty()) { // <- Ако има материали
            output.append("Materials left: ");
            while (!materialsStack.isEmpty()) {
                output.append(materialsStack.pop());
                if (materialsStack.size() != 0)
                    output.append(", ");
            }
            output.append(System.lineSeparator());
        }

        if (!magicQueue.isEmpty()) { // <- Ако има "магия"
            output.append("Magic left: ");
            while (!magicQueue.isEmpty()) {
                output.append(magicQueue.poll());
                if (magicQueue.size() != 0)
                    output.append(", ");
            }
            output.append(System.lineSeparator());
        }

        presentCountMap.entrySet().forEach(entry -> { // <- Само ако има изработени подаръци - в азбучен ред
            if (entry.getValue() != 0) {
                output.append(String.format("%s: %d", entry.getKey(), entry.getValue()));
                output.append(System.lineSeparator());
            }
        });

        return output.toString();
    }

}
