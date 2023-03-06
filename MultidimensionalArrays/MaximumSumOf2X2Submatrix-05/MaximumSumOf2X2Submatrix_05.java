package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsMatrix = Integer.parseInt(scanner.nextLine().split(",\\s+")[0]); // <- Броя на масивите в матрицата

        int[][] matrix = fillInMatrixComaAndSpaceDelimiter(scanner, rowsMatrix);

        int[][] subMatrix = new int[2][2]; // <- Подматрица 2 на 2

        for (int rows = 0; rows < matrix.length - 1; rows++) { // <- Без последния ред

            for (int cols = 0; cols < matrix[rows].length - 1; cols++) { // <- Без последната колона

                int firstElement = matrix[rows][cols];
                int secondElement = matrix[rows][cols + 1];
                int thirdElement = matrix[rows + 1][cols];
                int forthElement = matrix[rows + 1][cols + 1];

                // Сравнявам четирите елемента и презаписвам тези с по-голям сбор
                int currentElementsCount = firstElement + secondElement + thirdElement + forthElement;
                int submatrixElementsCount = count2x2ElementsInSubmatrix(subMatrix); // <- Сбор на елементи в подматрицата

                if (currentElementsCount > submatrixElementsCount) {
                    subMatrix[0][0] = firstElement;
                    subMatrix[0][1] = secondElement;
                    subMatrix[1][0] = thirdElement;
                    subMatrix[1][1] = forthElement;
                }

            }

        }

        // Принтирам подматрицата и нейната сума
        Arrays.stream(subMatrix).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

        int totalElementsCount = count2x2ElementsInSubmatrix(subMatrix);
        System.out.print(totalElementsCount);

    }

    private static int[][] fillInMatrixComaAndSpaceDelimiter(Scanner scanner, int rows) {
        // Прочита матрица с разделител запетая и разстояние/я
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++)
            matrix[i] = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

    private static int count2x2ElementsInSubmatrix(int[][] matrix) {
        // Намира текущия сбор на елементите в матрица две на две
        int firstElement = matrix[0][0];
        int secondElement = matrix[0][1];
        int thirdElement = matrix[1][0];
        int forthElement = matrix[1][1];

        return firstElement + secondElement + thirdElement + forthElement;
    }

}
