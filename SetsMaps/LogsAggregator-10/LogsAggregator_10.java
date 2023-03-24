package SetsMaps;

import java.util.*;

public class LogsAggregator_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> usersDurationMap = new TreeMap<>(); // <- Потребители/продължителност
        Map<String, Set<String>> usersIpMap = new TreeMap<>(); // <- Потребители/уникални IP адреси

        while (lines-- > 0) {
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

        usersDurationMap.entrySet().forEach(user -> {

            System.out.printf("%s: %d ", user.getKey(), user.getValue());
            System.out.printf("%s\n", usersIpMap.get(user.getKey()).toString());

        });

    }

}
