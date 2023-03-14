package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Редове

        int[][] rectangleMatrix = fillInMatrixWithWhitespaceDelimiter(scanner, rows);

        int totalSum = 0; // <- Най-висока сума на матрица 3 на 3
        int startingOfMaximalRow = 0; // <- Стартов индекс на ред на матрица 3 на 3
        int startingOfMaximalCol = 0; // <- Стартов индекс на колона на матрица 3 на 3

        for (int row = 0; row < rectangleMatrix.length - 2; row++) { // <- Без последните два реда

            for (int col = 0; col < rectangleMatrix[row].length - 2; col++) { // <- Без последните две колони

                int currentSum = 0;
                // Обхождам следващите два елемента на реда и колоната и ги събирам
                for (int currentRow = row; currentRow < row + 3; currentRow++) {

                    for (int currentCol = col; currentCol < col + 3; currentCol++) {

                        currentSum += rectangleMatrix[currentRow][currentCol];

                    }

                }

                // Презаписвам стойностите при вярност на условието
                if (currentSum > totalSum) {

                    totalSum = currentSum;
                    startingOfMaximalRow = row;
                    startingOfMaximalCol = col;

                }

            }

        }

        System.out.printf("Sum = %d\n", totalSum);
        // Принтирам матрицата 3 на 3 с най-висока сума на елементите
        printMaximalMatrix3x3(rectangleMatrix, startingOfMaximalRow, startingOfMaximalCol);

    }

    private static int[][] fillInMatrixWithWhitespaceDelimiter(Scanner scanner, int rows) {
        // Прочита матрица от конзолата
        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

    private static void printMaximalMatrix3x3(int[][] matrix, int startRow, int startCol) {
        // Принтира матрица 3 на 3 с най-високата сума на елементите
        for (int row = startRow; row < startRow + 3; row++) {

            for (int col = startCol; col < startCol + 3; col++) {

                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();

        }

    }

}


