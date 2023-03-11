package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine()); // <- Размер, редове и колони

        int[][] squareMatrix = fillInMatrixWithWhitespacesDelimiter(scanner, sizeMatrix);

        int primaryDiagonal = 0; // <- Сума първоначален диагонал
        int secondaryDiagonal = 0; // <- Сума второстепенен диагонал

        int secondaryPosition = squareMatrix.length - 1;
        for (int row = 0; row < squareMatrix.length; row++, secondaryPosition--) {

            primaryDiagonal += squareMatrix[row][row];
            secondaryDiagonal += squareMatrix[row][secondaryPosition];

        }

        int diff = Math.abs(primaryDiagonal - secondaryDiagonal); // <- Разлика между двата диагонала
        System.out.println(diff);

    }

    private static int[][] fillInMatrixWithWhitespacesDelimiter(Scanner scanner, int size) {
        // Прочита матрица N x N размер от конзолата
        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

}
