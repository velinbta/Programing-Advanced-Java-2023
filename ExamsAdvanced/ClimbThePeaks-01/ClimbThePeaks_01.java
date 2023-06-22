package ExamsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks_01 {
    private static int daysOfWeek = 7;

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> foodQuantityStack = readStack(scanner);
        Deque<Integer> dailyStaminaQueue = readQueue(scanner);
        checkLengthOfBothDeque(foodQuantityStack, dailyStaminaQueue);

        Map<Integer, String> difficultyMountainPeaksMap = fillInMap(); // <- Трудности, върхове
        Set<String> conqueredPeaks = new LinkedHashSet<>(); // <- Покорените върхове

        while (daysOfWeek-- > 0 && !difficultyMountainPeaksMap.isEmpty()) { // <- 7 дни, 5 планински върхове

            int sum = foodQuantityStack.pop() + dailyStaminaQueue.poll();
            int levelOfDifficulty = difficultyMountainPeaksMap.entrySet().iterator().next().getKey(); // <- По ред
            boolean canConquerPeak = sum >= levelOfDifficulty;

            if (canConquerPeak) {
                // Ако може да го изкачи, върхът се премахва, ако не опитва на другия ден - същия връх
                String currentPeak = difficultyMountainPeaksMap.get(levelOfDifficulty);
                conqueredPeaks.add(currentPeak);
                difficultyMountainPeaksMap.remove(levelOfDifficulty);

            }

        }

        String output = getOutput(difficultyMountainPeaksMap, conqueredPeaks);
        System.out.println(output);

    }

    private static Deque<Integer> readStack(Scanner scanner) {
        // Прочита стек от терминала
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt)
                .forEach(stack::push);

        return stack;
    }

    private static Deque<Integer> readQueue(Scanner scanner) {
        // Прочита опашка
        return Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static Map<Integer, String> fillInMap() {
        // Попълва трудността за всеки връх и самия него в дадена поредност
        Map<Integer, String> difficultyMountainPeaksMap = new LinkedHashMap<>();
        difficultyMountainPeaksMap.put(80, "Vihren");
        difficultyMountainPeaksMap.put(90, "Kutelo");
        difficultyMountainPeaksMap.put(100, "Banski Suhodol");
        difficultyMountainPeaksMap.put(60, "Polezhan");
        difficultyMountainPeaksMap.put(70, "Kamenitza");

        return difficultyMountainPeaksMap;
    }

    private static void checkLengthOfBothDeque(Deque<Integer> foodQuantityStack, Deque<Integer> dailyStaminaQueue) {
        if (foodQuantityStack.size() != 7 || dailyStaminaQueue.size() != 7)
            throw new IllegalArgumentException("Food and Stamina must begin with 7 elements!");
    }

    private static String getOutput(Map<Integer, String> difficultyMountainPeaksMap, Set<String> conqueredPeaks) {
        // Билдва изходните данни
        StringBuilder output = new StringBuilder();

        if (difficultyMountainPeaksMap.isEmpty())
            output.append("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        else
            output.append("Alex failed! He has to organize his journey better next time -> @PIRINWINS");

        if (!conqueredPeaks.isEmpty()) {

            output.append(System.lineSeparator());
            output.append("Conquered peaks:");
            output.append(System.lineSeparator());

            int index = 0;
            for (String peak : conqueredPeaks) {
                output.append(peak);

                if (index != conqueredPeaks.size() - 1)
                    output.append(System.lineSeparator());

                index++;
            }

        }

        return output.toString();
    }

}
