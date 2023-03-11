package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsMatrix = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Редове

        String[][] matrix = fillInMatrixWithWhitespaceDelimiter(scanner, rowsMatrix);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] commandArr = input.split("\\s+");
            String command = commandArr[0]; // <- Команда

            if (command.equals("swap") && commandArr.length == 5) { // <- Валидна команда

                // Извеждам редовете и колоните и проверявам дали са в рамките на матрицата
                int firstCellRow = Integer.parseInt(commandArr[1]);
                int firstCellCol = Integer.parseInt(commandArr[2]);
                int secondCellRow = Integer.parseInt(commandArr[3]);
                int secondCellCol = Integer.parseInt(commandArr[4]);
                boolean isValid = isCoordinatesValid(matrix, firstCellRow, firstCellCol,
                        secondCellRow, secondCellCol);

                if (isValid) { // <- Валидни цифри

                    // Разменям първи и втори елемент от матрицата
                    String firstElement = matrix[firstCellRow][firstCellCol];
                    String secondElement = matrix[secondCellRow][secondCellCol];

                    matrix[firstCellRow][firstCellCol] = secondElement;
                    matrix[secondCellRow][secondCellCol] = firstElement;

                    Arrays.stream(matrix).forEach(arr ->
                            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")));

                } else { // <- Цифри извън рамките на матрицата

                    System.out.println("Invalid input!");

                }

            } else { // <- Невалидна команда

                System.out.println("Invalid input!");

            }

            input = scanner.nextLine();

        }

    }

    private static String[][] fillInMatrixWithWhitespaceDelimiter(Scanner scanner, int rows) {
        // Прочита матрица от конзолата
        String[][] matrix = new String[rows][];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = scanner.nextLine().split("\\s+");

        return matrix;
    }

    private static boolean isCoordinatesValid(String[][] matrix, int firstRow,
                                              int firstCol, int secondRow, int secondCol) {
        // Проверява дали въведените цифри след командата са в рамките на матрицата
        return firstRow >= 0 && firstRow < matrix.length
                && firstCol >= 0 && firstCol < matrix[firstRow].length
                && secondRow >= 0 && secondRow < matrix.length
                && secondCol >= 0 && secondCol < matrix[secondRow].length;

    }

}
