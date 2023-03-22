package SetsMaps;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLinePairs = Integer.parseInt(scanner.nextLine());

        Map<String, Double> nameAvgGradeMap = new TreeMap<>(); // <- По азбучен ред

        while (inputLinePairs-- > 0) {

            String name = scanner.nextLine();
            double[] gradesArr = readDoubleArrayFromConsole(scanner); // <- Всички оценки в масив
            double avg = getAverageGradeFromArray(gradesArr); // <- Изчислявам средната оценка

            nameAvgGradeMap.putIfAbsent(name, avg);

        }

        nameAvgGradeMap.entrySet().forEach(student ->
                System.out.printf("%s is graduated with %s\n", student.getKey(), student.getValue()));

    }

    private static double[] readDoubleArrayFromConsole(Scanner scanner) {
        // Прочита double[]
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(n -> Double.parseDouble(n)).toArray();
    }

    private static double getAverageGradeFromArray(double[] gradesArr) {
        // Изчислява средната оценка
        double gradesSum = 0;

        for (double grade : gradesArr)
            gradesSum += grade;

        return gradesSum / gradesArr.length;
    }

}
