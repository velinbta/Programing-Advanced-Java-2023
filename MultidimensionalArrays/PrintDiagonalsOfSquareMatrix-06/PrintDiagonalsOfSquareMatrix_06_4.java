package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine()); // <- Размер на матрицата

        int[][] squareMatrix = fillInSquareMatrix(scanner, size); // <- Квадратна матрица

        printTopDiagonalLeftToRight(squareMatrix); // <- Горен диагонал, от ляво надясно
        printBottomDiagonalLeftToRight(squareMatrix); // <- Долен диагонал, от ляво надясно

    }

    private static int[][] fillInSquareMatrix(Scanner scanner, int size) {
        // Прочита квадратна матрица
        int[][] squareMatrix = new int[size][size];

        for (int row = 0; row < squareMatrix.length; row++)
            squareMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return squareMatrix;
    }

    private static void printTopDiagonalLeftToRight(int[][] matrix) {

        int row = 0;
        int col = 0;

        while (row < matrix.length && col < matrix[row].length) {
            System.out.print(matrix[row][col] + " "); // <- Горен диагонал, от ляво надясно
            row++;
            col++;
        }

    }

    private static void printBottomDiagonalLeftToRight(int[][] matrix) {

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[row].length) {
            System.out.print(matrix[row][col] + " "); // <- Долен диагонал, от ляво надясно
            row--;
            col++;
        }

    }

}
