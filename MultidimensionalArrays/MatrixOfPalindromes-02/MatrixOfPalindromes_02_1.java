package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int rowsMatrix = dimensionArr[0]; // <- Редове
        int colsMatrix = dimensionArr[1]; // <- Колони

        String[][] matrix = fillInStringMatrix(rowsMatrix, colsMatrix); // <- Запълвам матрицата

        Arrays.stream(matrix).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));


    }

    private static String[][] fillInStringMatrix(int rows, int cols) {
        // Запълва матрица от дадени редове и колони (всяка String стойност по 3)
        String[][] matrix = new String[rows][cols];

        char valueFirstThird = 'a'; // <- Първоначален символ

        for (int row = 0; row < matrix.length; row++, valueFirstThird++) {

            char middle = valueFirstThird; // <- Символ по средата
            for (int col = 0; col < matrix[row].length; col++, middle++) {

                StringBuilder chBuild = new StringBuilder()
                        .append(valueFirstThird).append(middle).append(valueFirstThird);

                matrix[row][col] = chBuild.toString();
            }

        }

        return matrix;
    }

}
