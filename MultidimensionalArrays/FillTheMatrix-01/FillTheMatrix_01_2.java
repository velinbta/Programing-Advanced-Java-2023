package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix_01_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(",\\s+");

        int size = Integer.parseInt(inputArr[0]); // <- N x N
        String pattern = inputArr[1];

        int[][] matrix = pattern.equals("A")
                ? fillInMatrixPatternA(size) // <- При тип A
                : fillInMatrixPatternB(size); // <- При тип B

        Arrays.stream(matrix).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

    }

    private static int[][] fillInMatrixPatternA(int size) {
        // Запълва матрица от тип A
        int[][] matrix = new int[size][size];

        int value = 1;

        for (int row = 0; row < matrix.length; row++)

            for (int col = 0; col < matrix[row].length; col++, value++)

                matrix[col][row] = value;

        return matrix;
    }

    private static int[][] fillInMatrixPatternB(int size) {
        // Запълва матрица от тип B
        int[][] matrix = new int[size][size];

        int value = 1;

        for (int row = 0; row < matrix.length; row++)

            if (row % 2 == 0) // <- Четен ред

                for (int col = 0; col < matrix[row].length; col++, value++)

                    matrix[col][row] = value;

            else // <- Нечетен ред

                for (int col = matrix.length - 1; col >= 0; col--, value++)

                    matrix[col][row] = value;

        return matrix;
    }

}
