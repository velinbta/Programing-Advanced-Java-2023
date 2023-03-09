package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(",\\s+");

        int size = Integer.parseInt(inputArr[0]);
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

        int values = 1;

        for (int row = 0; row < matrix.length; row++)

            for (int col = 0; col < matrix[row].length; col++, values++)

                matrix[col][row] = values;

        return matrix;
    }

    private static int[][] fillInMatrixPatternB(int size) {
        // Запълва матрица от тип B
        int[][] matrix = new int[size][size];

        int values = 1;

        for (int row = 0; row < matrix.length; row++)

            if (row % 2 == 0) // <- Четен ред

                for (int col = 0; col < matrix[row].length; col++, values++)

                    matrix[col][row] = values;

            else // <- Нечетен ред

                for (int col = matrix.length - 1; col >= 0; col--, values++)

                    matrix[col][row] = values;

        return matrix;
    }

}
