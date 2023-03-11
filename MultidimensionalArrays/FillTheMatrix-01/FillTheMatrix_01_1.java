package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix_01_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(",\\s+");

        int size = Integer.parseInt(inputArr[0]); // <- N x N
        String pattern = inputArr[1];

        int[][] matrix = new int[size][size];

        switch (pattern) {

            case "A": // <- При тип A

                matrix = fillInNxNMatrixPatternA(size);
                break;

            case "B": // <- При тип B

                matrix = fillInNxNMatrixPatternB(size);
                break;

        }

        for (int[] arr : matrix) {

            for (int n : arr) {
                System.out.print(n + " ");
            }

            System.out.println();
        }

    }

    private static int[][] fillInNxNMatrixPatternA(int size) {
        // Запълва матрица от тип A
        int[][] matrix = new int[size][size];

        int value = 1;

        for (int row = 0; row < matrix.length; row++)

            for (int col = 0; col < matrix[row].length; col++, value++)

                matrix[col][row] = value;

        return matrix;
    }

    private static int[][] fillInNxNMatrixPatternB(int size) {
        // Запълва матрица от тип B
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int row = 0; row < matrix.length; row++)

            if (row % 2 == 0)

                for (int col = 0; col < matrix[row].length; col++, value++)

                    matrix[col][row] = value;

            else

                for (int col = matrix[row].length - 1; col >= 0; col--, value++)

                    matrix[col][row] = value;

        return matrix;
    }

}
