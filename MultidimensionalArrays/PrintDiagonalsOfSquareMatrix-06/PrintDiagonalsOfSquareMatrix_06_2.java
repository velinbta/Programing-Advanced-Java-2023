package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int squareMatrixRows = Integer.parseInt(scanner.nextLine()); // <- Броя на масивите в матрицата

        int[][] squareMatrix = fillInSquareMatrix(scanner, squareMatrixRows); // <- Винаги квадрат

        StringBuilder diagonalsOutput = getTopDiagonalInSquareMatrix(squareMatrix); // <- Горен диагонал
        diagonalsOutput = getBottomDiagonalsInSquareMatrix(squareMatrix, diagonalsOutput); // <- Долен диагонал

        System.out.print(diagonalsOutput);

    }

    private static int[][] fillInSquareMatrix(Scanner scanner, int rows) {
        // Прочита квадратна матрица
        int[][] squareMatrix = new int[rows][rows];

        for (int row = 0; row < squareMatrix.length; row++)
            squareMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return squareMatrix;
    }

    private static StringBuilder getTopDiagonalInSquareMatrix(int[][] squareMatrix) {
        // От ляво надясно, от горе надолу - диагонал
        StringBuilder topDiagonalBuild = new StringBuilder();
        for (int row = 0; row < squareMatrix.length; row++) {

            int element = squareMatrix[row][row];

            topDiagonalBuild = row != squareMatrix.length - 1
                    ? topDiagonalBuild.append(element).append(" ")
                    : topDiagonalBuild.append(element);

        }

        topDiagonalBuild.append(System.lineSeparator());

        return topDiagonalBuild;
    }

    private static StringBuilder getBottomDiagonalsInSquareMatrix
            (int[][] squareMatrix, StringBuilder topDiagonals) {
        // От ляво надясно, от долу нагоре - диагонал
        int frontPosition = 0;
        for (int row = squareMatrix.length - 1; row >= 0; row--, frontPosition++) {

            int element = squareMatrix[row][frontPosition];
            topDiagonals = row != 0
                    ? topDiagonals.append(element).append(" ")
                    : topDiagonals.append(element);

        }

        return topDiagonals;
    }

}
