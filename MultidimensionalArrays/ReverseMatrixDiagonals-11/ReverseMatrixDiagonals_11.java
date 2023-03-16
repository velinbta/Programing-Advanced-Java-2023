package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsArr = readArray(scanner);
        int rowsMatrix = dimensionsArr[0]; // <- Броя на масивите в матрицата
        int colsMatrix = dimensionsArr[1]; // <- Дължината на всеки един масив в матрицата

        int[][] matrix = fillInMatrix(scanner, rowsMatrix, colsMatrix); // <- Прочита матрица от конзолата

        // Съхранявам в списък от списъци диагоналите на матрицата
        List<List<Integer>> diagonalsList = getListOfDiagonalArrays(matrix);

        diagonalsList.forEach(list -> {
            list.forEach(e -> System.out.print(e + " "));
            System.out.println();
        });

    }

    private static int[] readArray(Scanner scanner) {
        // Прочита масив от конзолата
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
    }

    private static int[][] fillInMatrix(Scanner scanner, int rows, int cols) {
        // Прочита матрица от конзолата
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = readArray(scanner);

        return matrix;
    }

    private static List<List<Integer>> getListOfDiagonalArrays(int[][] matrix) {
        // Създава нов списък от списъци и взима диаголани на последен ред и диагонали първа колона
        List<List<Integer>> diagonalsList = new ArrayList<>();

        getLastRowDiagonalsInMatrixReversed(matrix, diagonalsList); // <- Последен ред диагонали
        getFirstColumnDiagonalsInMatrixReversed(matrix, diagonalsList); // <- Първа колона диагонали

        return diagonalsList;
    }

    private static void getLastRowDiagonalsInMatrixReversed(int[][] matrix,
                                                            List<List<Integer>> diagonalsList) {
        // Взима диагонали на последен ред от матрицата - дясно
        int lastColLength = matrix[matrix.length - 1].length - 1;

        for (int col = lastColLength; col >= 0; col--) {

            // Добавям нов списък и в него съхранявам текущия елемент и оставащите диагонали
            int currentElement = matrix[matrix.length - 1][col];
            diagonalsList.add(new ArrayList<>());
            diagonalsList.get(diagonalsList.size() - 1).add(currentElement);

            int diagonalRow = matrix.length - 2;
            int diagonalCol = col + 1;

            while (isIndexInBounds(matrix, diagonalRow, diagonalCol)) { // <- Докато са валидни, добавям

                diagonalsList.get(diagonalsList.size() - 1).add(matrix[diagonalRow][diagonalCol]);
                diagonalRow--;
                diagonalCol++;

            }

        }
    }

    private static void getFirstColumnDiagonalsInMatrixReversed(int[][] matrix,
                                                                List<List<Integer>> diagonalsList) {
        // Взима диагонали на първа колона от матрицата - дясно
        for (int row = matrix.length - 2; row >= 0; row--) {

            // Добавям нов списък и в него съхранявам текущия елемент и оставащите диагонали
            int currentElement = matrix[row][0];
            diagonalsList.add(new ArrayList<>());
            diagonalsList.get(diagonalsList.size() - 1).add(currentElement);

            int diagonalRow = row - 1;
            int diagonalCol = 1;

            while (isIndexInBounds(matrix, diagonalRow, diagonalCol)) { // <- Докато са валидни, добавям

                diagonalsList.get(diagonalsList.size() - 1).add(matrix[diagonalRow][diagonalCol]);
                diagonalRow--;
                diagonalCol++;

            }

        }
    }

    private static boolean isIndexInBounds(int[][] matrix, int row, int col) {
        // Проверява дали индексът е в границите на матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;

    }

}
