package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsMatrix = Integer.parseInt(scanner.nextLine()); // <- Броя на масивите в матрицата
        int columnsMatrix = Integer.parseInt(scanner.nextLine()); // <- Дължината на всеки един масив в матрицата

        char[][] firstMatrix = fillInCharMatrixWithoutWhitespaces(scanner, rowsMatrix);
        char[][] secondMatrix = fillInCharMatrixWithoutWhitespaces(scanner, rowsMatrix);

        char[][] thirdMatrix = new char[rowsMatrix][columnsMatrix];

        for (int rows = 0; rows < thirdMatrix.length; rows++) {

            for (int cols = 0; cols < thirdMatrix[rows].length; cols++) {

                char firstElement = firstMatrix[rows][cols];
                char secondElement = secondMatrix[rows][cols];

                // Ако елемента от първата матрица съвпада с елемента от втората матрица,
                // ако не задавам '*'
                thirdMatrix[rows][cols] = firstElement == secondElement
                        ? firstElement : '*';

            }

        }

        Arrays.stream(thirdMatrix).forEach(arr -> { // <- Принтирам третата матрица
            for (char current : arr) {
                System.out.print(current + " ");
            }
            System.out.println();
        });

    }

    private static char[][] fillInCharMatrixWithoutWhitespaces(Scanner scanner, int rows) {
        // Прочита двуизмерна матрица, без разстояния между символите
        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        return matrix;
    }

}
