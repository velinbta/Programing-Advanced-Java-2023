package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsMatrix = Integer.parseInt(scanner.nextLine()); // <- Броя на масивите в матрицата

        int[][] matrix = fillInMatrix(scanner, rowsMatrix);
        List<int[]> correctValueList = new ArrayList<>(); // <- Стойности (Ред, колона, вярна стойност)

        // Взимам на кой ред и колона се намира грешната стойност
        int[] wrongValueArr = readArray(scanner);
        int rowValue = wrongValueArr[0];
        int colValue = wrongValueArr[1];

        if (isValueInBounds(matrix, rowValue, colValue)) {

            int incorrectValue = matrix[rowValue][colValue]; // <- Грешна стойност

            for (int row = 0; row < matrix.length; row++) {

                for (int col = 0; col < matrix[row].length; col++) {

                    int currentValue = matrix[row][col];

                    if (currentValue == incorrectValue) {

                        // Общ сбор на достъпните числа (горе, долу, ляво, дясно)
                        int sumNearbyElements = getNearbyElementsSum(matrix, row, col, incorrectValue);

                        correctValueList.add(new int[]{row, col, sumNearbyElements});

                    }

                }

            }

        } else { // <- Ако са грешни входните данни - принтирам първоначалната матрица

            printMatrix(matrix);

        }

        if (isValueInBounds(matrix, rowValue, colValue)) {
            // Замествам грешните стойности от списъка, и принтирам матрицата
            for (int[] correctValues : correctValueList) {

                int row = correctValues[0];
                int col = correctValues[1];
                int value = correctValues[2];

                matrix[row][col] = value;

            }

            printMatrix(matrix);
        }

    }

    private static int[][] fillInMatrix(Scanner scanner, int rows) {
        // Прочита матрица от конзолата
        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = readArray(scanner);

        return matrix;
    }

    private static int[] readArray(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
    }

    private static boolean isValueInBounds(int[][] matrix, int row, int col) {
        // Проверява въведените индекси - дали са в рамките на матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;

    }

    private static int getNearbyElementsSum(int[][] matrix, int row, int col, int incorrectValue) {

        int sum = 0;

        // Ако елементите са в границите на матрицата и са различни от грешната стойност ги събира
        if (isValueInBounds(matrix, row - 1, col) && matrix[row - 1][col] != incorrectValue)
            sum += matrix[row - 1][col]; // <- Горе

        if (isValueInBounds(matrix, row + 1, col) && matrix[row + 1][col] != incorrectValue)
            sum += matrix[row + 1][col]; // <- Долу

        if (isValueInBounds(matrix, row, col + 1) && matrix[row][col + 1] != incorrectValue)
            sum += matrix[row][col + 1]; // <- Дясно

        if (isValueInBounds(matrix, row, col - 1) && matrix[row][col - 1] != incorrectValue)
            sum += matrix[row][col - 1]; // <- Ляво

        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        // Принтира матрица
        Arrays.stream(matrix).forEach(arr ->
                System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

    }

}
