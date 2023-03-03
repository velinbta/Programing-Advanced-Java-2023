package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Брой редове на първа матрица

        // Прочитам и запълвам двете матрици
        int[][] firstMatrix = fillInMatrix(scanner, rows);

        rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Брой редове на втора матрица

        int[][] secondMatrix = fillInMatrix(scanner, rows);

        String result = areTwoMatrixEqual(firstMatrix, secondMatrix) // <- Сравнявам елементите на двете матрици
                ? "equal" : "not equal";

        System.out.println(result);

    }

    private static int[][] fillInMatrix(Scanner scanner, int rows) {
        // Запълвам матрицата
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++)

            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

    private static boolean areTwoMatrixEqual(int[][] firstMatrix, int[][] secondMatrix) {
        // Сравнявам всеки от елементите на двете матрици
        if (firstMatrix.length != secondMatrix.length) // <- Дължина
            return false;

        for (int rows = 0; rows < firstMatrix.length; rows++)
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {

                if (firstMatrix[rows].length != secondMatrix[rows].length) // <- Отделните редове
                    return false;

                int firstElement = firstMatrix[rows][cols];
                int secondElement = secondMatrix[rows][cols];

                if (firstElement != secondElement)
                    return false;

            }

        return true;
    }

}


