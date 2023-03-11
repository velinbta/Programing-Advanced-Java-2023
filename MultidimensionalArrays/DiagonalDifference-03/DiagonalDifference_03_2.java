package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Размер, редове и колони

        int[][] squareMatrix = fillInMatrixWithWhitespacesDelimiter(scanner, sizeMatrix);

        int leftDiagonalSum = getLeftDiagonalSum(squareMatrix); // <- Сума ляв диагонал
        int rightDiagonalSum = getRightDiagonalSum(squareMatrix); // <- Сума десен диагонал
        int diff = Math.abs(leftDiagonalSum - rightDiagonalSum); // <- Разлика между ляв и десен диагонал

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

    private static int getLeftDiagonalSum(int[][] matrix) {
        // Намира сума на ляв диагонал
        int leftDiagonalSum = 0;

        for (int row = 0; row < matrix.length; row++)

            leftDiagonalSum += matrix[row][row];

        return leftDiagonalSum;
    }

    private static int getRightDiagonalSum(int[][] matrix) {
        // Намира сума на десен диагонал
        int rightDiagonalSum = 0;
        int col = 0;

        for (int row = matrix.length - 1; row >= 0; row--, col++)

            rightDiagonalSum += matrix[row][col];

        return rightDiagonalSum;
    }

}
