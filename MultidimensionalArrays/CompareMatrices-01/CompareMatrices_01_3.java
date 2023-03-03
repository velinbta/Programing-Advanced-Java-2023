package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Брой редове на първа матрица

        // Прочитам и запълвам двете матрици
        int[][] firstMatrix = fillInMatrix(scanner, rows);

        rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Брой редове на втора матрица

        int[][] secondMatrix = fillInMatrix(scanner, rows);

        boolean areEqual = Arrays.deepEquals(firstMatrix, secondMatrix); // <- Сравнявам матриците

        System.out.println(areEqual ? "equal" : "not equal");

    }

    private static int[][] fillInMatrix(Scanner scanner, int rows) {
        // Запълвам матрицата
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++)

            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

}


