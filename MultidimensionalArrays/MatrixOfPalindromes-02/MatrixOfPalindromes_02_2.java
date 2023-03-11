package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt(); // <- Редове
        int cols = scanner.nextInt(); // <- Колони

        String[][] palindromeMatrix = fillInPalindromeMatrix(rows, cols); // <- Запълвам матрицата

        Arrays.stream(palindromeMatrix).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

    }

    private static String[][] fillInPalindromeMatrix(int rows, int cols) {
        // Запълва матрица от дадени редове и колони (всяка String стойност по 3)
        String[][] matrix = new String[rows][cols];

        char firstAndLastLetter = 'a'; // <- Първоначален символ

        for (int row = 0; row < matrix.length; row++, firstAndLastLetter++) {

            char middleLetter = firstAndLastLetter; // <- Символ по средата
            for (int col = 0; col < matrix[row].length; col++, middleLetter++) {

                matrix[row][col] = "" + firstAndLastLetter + middleLetter + firstAndLastLetter;

            }

        }

        return matrix;
    }

}
