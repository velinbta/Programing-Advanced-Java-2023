package SetsMaps;

import java.util.*;

public class HandsOfCards_07_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playerCardsMap = new LinkedHashMap<>(); // <- Играчи и уникални карти
        while (!input.equals("JOKER")) {

            String[] infoArr = input.split(":\\s+");
            String player = infoArr[0];
            String cards = infoArr[1];

            // Добавям играча, ако липсва и след това му добавям всичките дадени карти
            playerCardsMap.putIfAbsent(player, new HashSet<>());
            Collections.addAll(playerCardsMap.get(player), cards.split(",\\s+"));

            input = scanner.nextLine();

        }

        Map<String, Integer> playerPointsMap = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> playerCards : playerCardsMap.entrySet()) { // <- Обхождам играча и картите

            String player = playerCards.getKey();
            // Пресметям общите точки на всичките му уникални карти
            int points = getPointsCalculated(playerCards.getValue());
            playerPointsMap.put(player, points);

        }

        playerPointsMap.entrySet().forEach(player ->
                System.out.printf("%s: %s\n", player.getKey(), player.getValue()));

    }

    private static int getPointsCalculated(Set<String> cardsSet) {
        // Изчислява точките на играча, като преминава през всяка уникална карта
        int totalPoints = 0;
        for (String card : cardsSet) {

            String power = card.substring(0, card.length() - 1); // <- Сила, без последния символ
            String type = card.substring(card.length() - 1); // <- Последния символ на картата е тип

            int powerPoints = getPowerPointsCalculated(power);
            int typePoints = getTypePointsCalculated(type);

            totalPoints += powerPoints * typePoints; // <- За всяка карта се умножават
        }

        return totalPoints;
    }

    private static int getPowerPointsCalculated(String power) {
        // Изчислява "power points"
        try {
            return Integer.parseInt(power); // <- Ако може да го преобразува към число, го връща
        } catch (Exception e) {

            switch (power) {
                // В другите случай не е число и си има стойност:
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
                case "A":
                    return 14;
                default:
                    return 1;

            }

        }

    }

    private static int getTypePointsCalculated(String type) {
        // Изчислява "type points"
        switch (type) {

            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            default:
                return 1;

        }

    }

}
