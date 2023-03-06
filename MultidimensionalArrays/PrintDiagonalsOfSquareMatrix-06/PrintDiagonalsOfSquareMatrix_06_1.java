package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int squareMatrixRows = Integer.parseInt(scanner.nextLine()); // <- Броя на масивите в матрицата

        int[][] squareMatrix = fillInSquareMatrix(scanner, squareMatrixRows); // <- Винаги квадрат

        int[][] subMatrix = new int[2][squareMatrixRows]; // <- Подматрица с диагоналните стойности

        // От ляво надясно, от горе надолу - диагонал
        for (int row = 0; row < squareMatrix.length; row++) {

            int element = squareMatrix[row][row];
            subMatrix[0][row] = element;

        }

        int frontPosition = 0;
        // От ляво надясно, от долу нагоре - диагонал
        for (int row = squareMatrix.length - 1; row >= 0; row--, frontPosition++) {

            int element = squareMatrix[row][frontPosition];
            subMatrix[1][frontPosition] = element;

        }

        // Принтирам подматрицата с диагоналните стойности
        Arrays.stream(subMatrix).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

    }

    private static int[][] fillInSquareMatrix(Scanner scanner, int rows) {
        // Протича квадратна матрица
        int[][] squareMatrix = new int[rows][rows];
        for (int i = 0; i < squareMatrix.length; i++)
            squareMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return squareMatrix;
    }

}
