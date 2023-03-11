package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Редове

        int[][] rectangleMatrix = fillInMatrixWithWhitespaceDelimiter(scanner, rows);

        // Подматрица 3 на 3 с най-голяма сума на елементи
        int[][] subMatrix3x3 = getMaximal3by3SubMatrix(rectangleMatrix);
        int sumSubMatrix = getSumOfAllElementsInMatrix(subMatrix3x3); // <- Сума на подматрицата

        System.out.printf("Sum = %d\n", sumSubMatrix);
        Arrays.stream(subMatrix3x3).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

    }

    private static int[][] fillInMatrixWithWhitespaceDelimiter(Scanner scanner, int rows) {

        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

    private static int[][] getMaximal3by3SubMatrix(int[][] matrix) {
        // Запълва подматрица 3 на 3 с най-голяма сума на елементите
        int[][] subMatrix = new int[3][3];

        int totalSum = 0;
        for (int row = 1; row < matrix.length - 1; row++)

            for (int col = 1; col < matrix[row].length - 1; col++) {

                // Намирам сумата на елементите на всеки от трите реда
                int firstRowElements = matrix[row - 1][col - 1]
                        + matrix[row - 1][col] + matrix[row - 1][col + 1];
                int secondRowElements = matrix[row][col - 1]
                        + matrix[row][col] + matrix[row][col + 1];
                int thirdRowElements = matrix[row + 1][col - 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                int currentSum = firstRowElements + secondRowElements + thirdRowElements;

                if (currentSum > totalSum) { // <- Презаписвам подматрицата

                    totalSum = currentSum;
                    subMatrix[0][0] = matrix[row - 1][col - 1];
                    subMatrix[0][1] = matrix[row - 1][col];
                    subMatrix[0][2] = matrix[row - 1][col + 1];
                    subMatrix[1][0] = matrix[row][col - 1];
                    subMatrix[1][1] = matrix[row][col];
                    subMatrix[1][2] = matrix[row][col + 1];
                    subMatrix[2][0] = matrix[row + 1][col - 1];
                    subMatrix[2][1] = matrix[row + 1][col];
                    subMatrix[2][2] = matrix[row + 1][col + 1];

                }

            }

        return subMatrix;
    }

    private static int getSumOfAllElementsInMatrix(int[][] matrix) {
        // Намира общата сума на елементите в матрица
        int sum = 0;
        for (int[] arr : matrix)

            sum += Arrays.stream(arr).sum();

        return sum;
    }

}
