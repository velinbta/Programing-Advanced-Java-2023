package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine()); // <- Броя на масивите в матрицата

        int[][] wrongMeasureMatrix = fillInMatrix(scanner, rows); // <- Матрица с "грешни" стойности

        int[] wrongValueArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        // Взимам на кой ред и колона се намира грешната стойност
        int correctionRow = wrongValueArr[0];
        int correctionColumn = wrongValueArr[1];

        // Проверявам дали входните данни са в рамките на матрицата
        boolean isInputCorrect = isInputValuesCorrect(correctionRow, correctionColumn, wrongMeasureMatrix);

        if (isInputCorrect) {
            // Правя нова матрица
            int[][] correctMeasureMatrix = allocateSameLengthMatrix(wrongMeasureMatrix);
            int incorrectValue = wrongMeasureMatrix[correctionRow][correctionColumn]; // <- Грешна стойност

            for (int row = 0; row < wrongMeasureMatrix.length; row++) {

                for (int col = 0; col < wrongMeasureMatrix[row].length; col++) {

                    int currentValue = wrongMeasureMatrix[row][col]; // <- Текуща стойност

                    if (currentValue == incorrectValue) {

                        int totalValue = 0; // <- Общ сбор на числа (горе, долу, ляво, дясно)

                        // Проверявам всяка една посока, дали такъв индекс съществува и мога да го прибавя в сбора
                        boolean isUpDirectionCorrect = row != 0
                                && wrongMeasureMatrix[row - 1].length <= wrongMeasureMatrix[row].length
                                && wrongMeasureMatrix[row - 1][col] != incorrectValue;

                        if (isUpDirectionCorrect) { // <- Горе
                            totalValue += wrongMeasureMatrix[row - 1][col];
                        }

                        boolean isDownDirectionCorrect = row + 1 <= wrongMeasureMatrix.length - 1
                                && wrongMeasureMatrix[row + 1].length <= wrongMeasureMatrix[row].length
                                && wrongMeasureMatrix[row + 1][col] != incorrectValue;

                        if (isDownDirectionCorrect) { // <- Долу
                            totalValue += wrongMeasureMatrix[row + 1][col];
                        }

                        boolean isLeftDirectionCorrect = col - 1 >= 0
                                && wrongMeasureMatrix[row][col - 1] != incorrectValue;

                        if (isLeftDirectionCorrect) { // <- Ляво
                            totalValue += wrongMeasureMatrix[row][col - 1];
                        }

                        boolean isRightDirectionCorrect = col + 1 <= wrongMeasureMatrix[row].length - 1
                                && wrongMeasureMatrix[row][col + 1] != incorrectValue;

                        if (isRightDirectionCorrect) { // <- Дясно
                            totalValue += wrongMeasureMatrix[row][col + 1];
                        }

                        correctMeasureMatrix[row][col] = totalValue;

                    } else { // <- Ако стойността не е "грешна"

                        correctMeasureMatrix[row][col] = wrongMeasureMatrix[row][col];

                    }

                }

            }

            Arrays.stream(correctMeasureMatrix).forEach(arr -> // <- Новата матрица
                    System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

        } else { // <- Ако са грешни входните данни - принтирам първоначалната матрица

            Arrays.stream(wrongMeasureMatrix).forEach(arr ->
                    System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

        }

    }

    private static int[][] fillInMatrix(Scanner scanner, int rows) {
        // Прочита матрица от конзолата
        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        return matrix;
    }

    private static boolean isInputValuesCorrect(int row, int column, int[][] matrix) {
        // Проверява въведените индекси - дали са в рамките на матрицата
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length;

    }

    private static int[][] allocateSameLengthMatrix(int[][] matrix) {
        // Прави същата дължина на матрицата с първоначални нулеви стойности
        int[][] newMatrix = new int[matrix.length][];

        for (int row = 0; row < matrix.length; row++)

            for (int col = 0; col < matrix[row].length; col++)

                newMatrix[row] = new int[matrix[row].length];

        return newMatrix;
    }

}
