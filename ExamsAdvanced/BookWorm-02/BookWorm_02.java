package ExamsAdvanced;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BookWorm_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = readMatrix(scanner, sizeMatrix); // <- Квадратна матрица
        int[] playerPosition = findPlayer(matrix); // <- Намира позицията на играча

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            int currentRow = playerPosition[0];
            int currentCol = playerPosition[1];

            switch (command) {
                // Проверява на всеки ход, дали е в рамките на матрицата
                // Ако буквата не е "-", конкатенира към крайния текст
                // Премества играча
                // Ако е извън полето - премахва последната буква от крайния текст
                case "up":

                    if (isInBounds(matrix, currentRow - 1, currentCol)) {

                        String letter = matrix[currentRow - 1][currentCol];

                        if (!isLetterEmpty(letter)) {
                            text = text.concat(letter);
                        }

                        movePlayer(currentRow, currentCol, playerPosition, matrix,
                                currentRow - 1, currentCol);

                    } else { // <- Извън полето

                        if (!isTextEmpty(text)) {

                            text = deleteLastLetter(text);

                        }

                    }

                    break;

                case "down":

                    if (isInBounds(matrix, currentRow + 1, currentCol)) {

                        String letter = matrix[currentRow + 1][currentCol];

                        if (!isLetterEmpty(letter)) {
                            text = text.concat(letter);
                        }

                        movePlayer(currentRow, currentCol, playerPosition, matrix,
                                currentRow + 1, currentCol);

                    } else { // <- Извън полето

                        if (!isTextEmpty(text)) {

                            text = deleteLastLetter(text);

                        }

                    }

                    break;

                case "left":

                    if (isInBounds(matrix, currentRow, currentCol - 1)) {

                        String letter = matrix[currentRow][currentCol - 1];

                        if (!isLetterEmpty(letter)) {
                            text = text.concat(letter);
                        }

                        movePlayer(currentRow, currentCol, playerPosition, matrix,
                                currentRow, currentCol - 1);

                    } else { // <- Извън полето

                        if (!isTextEmpty(text)) {

                            text = deleteLastLetter(text);

                        }

                    }

                    break;

                case "right":

                    if (isInBounds(matrix, currentRow, currentCol + 1)) {

                        String letter = matrix[currentRow][currentCol + 1];

                        if (!isLetterEmpty(letter)) {
                            text = text.concat(letter);
                        }

                        movePlayer(currentRow, currentCol, playerPosition, matrix,
                                currentRow, currentCol + 1);

                    } else { // <- Извън полето

                        if (!isTextEmpty(text)) {

                            text = deleteLastLetter(text);

                        }

                    }

                    break;

            }

            command = scanner.nextLine();
        }

        String output = getOutput(text, matrix);
        System.out.println(output);

    }

    private static void movePlayer(int currentRow, int currentCol, int[] playerPosition,
                                   String[][] matrix, int neededRow, int neededCol) {
        // Премества играча в матрицата, и в помощния масив към неговата нова позиция
        matrix[currentRow][currentCol] = "-";
        matrix[neededRow][neededCol] = "P";

        playerPosition[0] = neededRow;
        playerPosition[1] = neededCol;

    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        // Проверява рамките на матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static String[][] readMatrix(Scanner scanner, int sizeMatrix) {
        // Прочита квадратна матрица
        String[][] matrix = new String[sizeMatrix][];

        IntStream.range(0, matrix.length).forEach(row ->
                matrix[row] = scanner.nextLine().split(""));

        return matrix;
    }

    private static int[] findPlayer(String[][] matrix) {
        // Намира играча в полето на матрицата
        int[] playerPosition = new int[2];

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++)

                if (matrix[row][col].equals("P")) {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                    isFound = true;
                    break;
                }

            if (isFound)
                break;

        }

        return playerPosition;
    }

    private static String deleteLastLetter(String text) {
        // Трие последната буква на крайния текст
        return new StringBuilder(text).deleteCharAt(text.length() - 1).toString();
    }

    private static boolean isTextEmpty(String text) {
        // Проверява, дали текстът е празен
        return text.length() == 0;
    }

    private static boolean isLetterEmpty(String letter) {
        // Проверя дали буквата е "празна"
        return letter.equals("-");
    }

    private static String getOutput(String text, String[][] matrix) {
        // Билдва изходния текст
        StringBuilder output = new StringBuilder();
        output.append(text);
        output.append(System.lineSeparator());

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                output.append(matrix[row][col]);
            }

            if (row != matrix.length - 1) {
                output.append(System.lineSeparator());
            }

        }
        return output.toString();
    }

}
