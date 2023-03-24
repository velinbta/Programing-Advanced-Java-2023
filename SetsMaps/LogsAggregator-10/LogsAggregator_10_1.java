package SetsMaps;

import java.util.*;

public class LogsAggregator_10_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> usersDurationMap = new TreeMap<>(); // <- Потребители/продължителност
        Map<String, Set<String>> usersIpMap = new TreeMap<>(); // <- Потребители/уникални IP адреси

        for (int i = 0; i < lines; i++) {
            // Извеждам информацията
            String[] infoArr = scanner.nextLine().split("\\s+");
            String user = infoArr[1];
            String ip = infoArr[0];
            int duration = Integer.parseInt(infoArr[2]);

            // Смятам и добавям на момента продължителността за потребителя
            usersDurationMap.putIfAbsent(user, 0);
            usersDurationMap.put(user, usersDurationMap.get(user) + duration);

            // Добавям същия потребител с уникални негови IP адреси
            usersIpMap.putIfAbsent(user, new TreeSet<>());
            usersIpMap.get(user).add(ip);

        }
        // Форматирам си изходните данни и ги принтирам
        String[] formattedOutputArr = getUsernameInformationFormatted(usersDurationMap, usersIpMap);
        Arrays.stream(formattedOutputArr).forEach(user -> System.out.println(user));

    }

    private static String[] getUsernameInformationFormatted(Map<String, Integer> usersDurationMap,
                                                            Map<String, Set<String>> usersIpMap) {
        // Създава масив с форматираните изходни данни
        String[] formattedArr = new String[usersDurationMap.size()];

        int position = 0;
        for (Map.Entry<String, Integer> entry : usersDurationMap.entrySet()) {

            String format = String.format("%s: %d %s",
                    entry.getKey(), entry.getValue(), usersIpMap.get(entry.getKey()).toString());
            formattedArr[position] = format;

            position++;
        }

        return formattedArr;
    }

}