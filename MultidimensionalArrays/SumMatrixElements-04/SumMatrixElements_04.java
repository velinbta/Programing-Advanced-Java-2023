package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsArr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int rowsMatrix = dimensionsArr[0]; // <- Броя на масивите в матрицата
        int columnsMatrix = dimensionsArr[1]; // <- Дължината на всеки един масив в матрицата

        int[][] matrix = fillInMatrixWithDelimiterComaAndWhitespaces(scanner, rowsMatrix);

        int totalElementsCount = countNumbersInMatrix(matrix); // <- Общия брой на числата в матрицата

        System.out.printf("%d\n%d\n%d\n", rowsMatrix, columnsMatrix, totalElementsCount);

    }

    private static int[][] fillInMatrixWithDelimiterComaAndWhitespaces(Scanner scanner, int rows) {
        // Прочита двуизмерна матрица с разделител запетая и разстояние/я
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++)
            matrix[i] = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

    private static int countNumbersInMatrix(int[][] matrix) {
        // Общия брой на числата в матрицата
        int totalElementsCount = 0;
        for (int[] arr : matrix)
            for (int n : arr)
                totalElementsCount += n;

        return totalElementsCount;
    }

}
