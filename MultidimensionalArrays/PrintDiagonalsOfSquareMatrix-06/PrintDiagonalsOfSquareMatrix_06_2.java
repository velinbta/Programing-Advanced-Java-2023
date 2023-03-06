package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int squareMatrixRows = Integer.parseInt(scanner.nextLine()); // <- Броя на масивите в матрицата

        int[][] squareMatrix = fillInSquareMatrix(scanner, squareMatrixRows); // <- Винаги квадрат

        int[][] subMatrix = new int[2][squareMatrixRows]; // <- Подматрица с диагоналните стойности

        int bottomRowStart = squareMatrix.length - 1; // <- Ще взема от най-долния ред
        int bottomColumnStart = 0; // <- Ще взема от най-долната колона

        for (int row = 0; row < squareMatrix.length; row++, bottomRowStart--, bottomColumnStart++) {

            int topElement = squareMatrix[row][row]; // <- Горен елемент
            int bottomElement = squareMatrix[bottomRowStart][bottomColumnStart]; // <- Долен

            // Записвам диагоналите
            subMatrix[0][row] = topElement;
            subMatrix[1][row] = bottomElement;

        }

        Arrays.stream(subMatrix).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

    }

    private static int[][] fillInSquareMatrix(Scanner scanner, int rows) {
        // Прочита квадратна матрица
        int[][] squareMatrix = new int[rows][rows];

        for (int row = 0; row < squareMatrix.length; row++)
            squareMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return squareMatrix;
    }

}
