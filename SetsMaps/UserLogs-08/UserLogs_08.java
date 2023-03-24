package SetsMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> usersIpOccurrencesMap = new TreeMap<>();

        while (!input.equals("end")) {

            int ipIndexStart = input.indexOf("=") + 1; // <- Начална точка на IP адреса
            int ipIndexEnd = input.indexOf(" "); // <- Крайна точка на IP адреса
            int usernameIndexStart = input.lastIndexOf("=") + 1; // <- Начална точка на потребителско име

            String ip = input.substring(ipIndexStart, ipIndexEnd);
            String username = input.substring(usernameIndexStart);

            usersIpOccurrencesMap.putIfAbsent(username, new LinkedHashMap<>()); // <- Въвеждам потребител, ако липсва
            // На потребителя въвеждам IP и всеки път броя срещанията
            usersIpOccurrencesMap.get(username).putIfAbsent(ip, 0);
            usersIpOccurrencesMap.get(username).put(ip, usersIpOccurrencesMap.get(username).get(ip) + 1);

            input = scanner.nextLine();

        }

        usersIpOccurrencesMap.entrySet().forEach(username -> {
            // Принтирам изходните данни
            System.out.printf("%s:\n", username.getKey());

            printInnerMapData(username.getValue());

        });

    }

    private static void printInnerMapData(Map<String, Integer> ipOccurrencesMap) {
        // Принтира информацията от вътрешния Map
        int iterationsCount = 1;
        for (Map.Entry<String, Integer> entry : ipOccurrencesMap.entrySet()) {

            if (iterationsCount != ipOccurrencesMap.size())

                System.out.printf("%s => %d, ", entry.getKey(), entry.getValue());

            else

                System.out.printf("%s => %d.\n", entry.getKey(), entry.getValue());

            iterationsCount++;
        }

    }

}
