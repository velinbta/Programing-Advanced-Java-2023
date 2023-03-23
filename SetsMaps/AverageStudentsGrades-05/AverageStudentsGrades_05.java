package SetsMaps;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> namesGradesMap = new TreeMap<>(); // <- По азбучен ред

        while (lines-- > 0) {

            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            double grade = Double.parseDouble(inputArr[1]);

            // Добавям името на студента и оценките му
            namesGradesMap.putIfAbsent(name, new ArrayList<>());
            namesGradesMap.get(name).add(grade);

        }

        namesGradesMap.entrySet().forEach(entry -> {

            double averageGrade = getAverageGrade(entry.getValue()); // <- Намирам средната оценка
            System.out.printf("%s -> ", entry.getKey());
            entry.getValue().forEach(n -> System.out.printf("%.2f ", n));
            System.out.printf("(avg: %.2f)\n", averageGrade);

        });

    }

    private static double getAverageGrade(List<Double> gradesList) {
        // Намира средно аритметичната оценка
        double sum = 0;
        for (double num : gradesList)
            sum += num;

        return sum / gradesList.size();

    }

}
