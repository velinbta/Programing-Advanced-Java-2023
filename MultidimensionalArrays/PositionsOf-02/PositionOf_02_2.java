package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraysInMatrix = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Брой масиви в матрицата

        int[][] matrix = fillInMatrix(scanner, arraysInMatrix); // <- Запълвам матрицата

        int numberToFind = Integer.parseInt(scanner.nextLine());

        String output = searchNumberInMatrixGetNumberPosition(matrix, numberToFind); // <- Търся числото в матрицата

        System.out.print(output.isEmpty() ? "not found" : output);

    }

    private static int[][] fillInMatrix(Scanner scanner, int rows) { // <- Запълвам матрицата

        int matrix[][] = new int[rows][];

        for (int i = 0; i < rows; i++)
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

    private static String searchNumberInMatrixGetNumberPosition(int[][] matrix, int numberToFind) {

        // Ако намеря числото, го слагам в StringBuilder и го връщам като String променлива
        StringBuilder outputBuild = new StringBuilder();
        for (int rows = 0; rows < matrix.length; rows++) {

            for (int cols = 0; cols < matrix[rows].length; cols++) {

                int currentNumber = matrix[rows][cols];

                if (currentNumber == numberToFind) {
                    outputBuild.append(String.format("%s %s\n", rows, cols));
                }

            }

        }
        return outputBuild.toString();
    }

}
