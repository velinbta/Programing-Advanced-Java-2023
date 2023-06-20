package ExamsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> healingItemCount = getItemsAndTheirDefaultValue();

        Deque<Integer> textilesQueue = readQueue(scanner);
        Deque<Integer> medicamentsStack = readStack(scanner);

        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {

            int sum = textilesQueue.peek() + medicamentsStack.peek();

            if (sumEqualsFollowingNumbers(sum)) { // <- 30, 40, 100

                addCountToHealingItemMap(healingItemCount, sum); // <- Увеличава бройката в Map
                removeBothValues(textilesQueue, medicamentsStack); // <- Премахва и двете стойности

            } else if (sumIsBiggerThanTheMedKitValue(sum)) {

                int remainingSum = sum - 100;

                healingItemCount.put("MedKit", healingItemCount.get("MedKit") + 1); // + 1

                removeBothValues(textilesQueue, medicamentsStack);

                if (!medicamentsStack.isEmpty()) { // + Оставащата сума
                    medicamentsStack.push(medicamentsStack.pop() + remainingSum);
                }

            } else {

                textilesQueue.poll();
                medicamentsStack.push(medicamentsStack.pop() + 10); // + 10

            }

        }

        String output = getOutput(textilesQueue, medicamentsStack, healingItemCount);
        System.out.println(output);

    }

    private static Deque<Integer> readQueue(Scanner scanner) {
        // Прочита опашка от терминала
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

    }

    private static Deque<Integer> readStack(Scanner scanner) {
        // Прочита стек от терминала
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt)
                .forEach(stack::push);
        return stack;
    }

    private static Map<String, Integer> getItemsAndTheirDefaultValue() {
        // Попълва Map с първоначални default стойности
        Map<String, Integer> healingItemCount = new HashMap<>();
        healingItemCount.put("Patch", 0);
        healingItemCount.put("Bandage", 0);
        healingItemCount.put("MedKit", 0);

        return healingItemCount;
    }

    private static boolean sumEqualsFollowingNumbers(int sum) {
        return sum == 30 || sum == 40 || sum == 100;
    }

    private static boolean sumIsBiggerThanTheMedKitValue(int sum) {
        return sum > 100;
    }

    private static void removeBothValues(Deque<Integer> textilesQueue, Deque<Integer> medicamentsStack) {
        textilesQueue.poll();
        medicamentsStack.pop();
    }

    private static void addCountToHealingItemMap(Map<String, Integer> healingItemCount, int sum) {
        // Добавя бройка в Map
        switch (sum) {

            case 30:
                healingItemCount.put("Patch", healingItemCount.get("Patch") + 1);
                break;

            case 40:
                healingItemCount.put("Bandage", healingItemCount.get("Bandage") + 1);
                break;

            case 100:
                healingItemCount.put("MedKit", healingItemCount.get("MedKit") + 1);
                break;

        }

    }

    private static String getOutput(Deque<Integer> textilesQueue, Deque<Integer> medicamentsStack,
                                    Map<String, Integer> healingItemCount) {
        // Билдва изходните данни
        StringBuilder output = new StringBuilder();

        if (textilesQueue.isEmpty() && medicamentsStack.isEmpty())
            output.append("Textiles and medicaments are both empty.");
        else if (textilesQueue.isEmpty())
            output.append("Textiles are empty.");
        else if (medicamentsStack.isEmpty())
            output.append("Medicaments are empty.");

        output.append(System.lineSeparator());

        // Низходящ ред по стойност, ако са равни по азбучен ред, без default стойностите
        healingItemCount.entrySet().stream().filter(n -> n.getValue() != 0)
                .sorted((f, s) -> {

                    int result = f.getValue() - s.getValue();
                    if (result < 0)
                        return 1;
                    else if (result > 0)
                        return -1;

                    return f.getKey().compareTo(s.getKey());
                }).forEach(n -> {

                    output.append(String.format("%s - %d", n.getKey(), n.getValue()));
                    output.append(System.lineSeparator());

                });

//        // Премахва последния ред, ако контейнерите са празни - в judge, заради Trim функцията не работи
//        if (medicamentsStack.isEmpty() && textilesQueue.isEmpty()) {
//            output.deleteCharAt(output.length() - 1);
//            output.deleteCharAt(output.length() - 1);
//        }

        // Контейнерите, ако не са празни
        if (!medicamentsStack.isEmpty()) {

            output.append("Medicaments left: ");

            while (!medicamentsStack.isEmpty()) {
                output.append(medicamentsStack.pop());

                if (!medicamentsStack.isEmpty())
                    output.append(", ");
                else if (!textilesQueue.isEmpty())
                    output.append(System.lineSeparator());

            }

        }

        if (!textilesQueue.isEmpty()) {

            output.append("Textiles left: ");

            while (!textilesQueue.isEmpty()) {

                output.append(textilesQueue.poll());

                if (!textilesQueue.isEmpty()) {
                    output.append(", ");
                }

            }

        }

        return output.toString();
    }

}
