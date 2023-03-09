package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessMatrix = fillInCharChessMatrixWithoutWhitespaces(scanner); // <- Чар матрица

        for (int row = 0; row < chessMatrix.length; row++) {

            for (int col = 0; col < chessMatrix[row].length; col++) {

                char currentSymbol = chessMatrix[row][col];

                if (currentSymbol == 'q') { // <- Когато намеря кралица - започвам серия от проверки

                    // Умишлено разпръснати проверки, за да се пропускат редове при открита поне 1 кралица
                    if (horizontalContainsOtherQ(chessMatrix, row, col)) { // <- Хоризонтал
                        break;
                    }

                    if (verticalContainsOtherQ(chessMatrix, row, col)) { // <- Вертикал
                        break;
                    }

                    if (leftDiagonalUpContainsOtherQ(chessMatrix, row, col)) { // <- Ляв горен диагонал
                        break;
                    }

                    if (leftDiagonalDownContainsOtherQ(chessMatrix, row, col)) { // <- Ляв долен диагонал
                        break;
                    }

                    if (rightDiagonalUpContainsOtherQ(chessMatrix, row, col)) { // <- Десен горен диагонал
                        break;
                    }

                    if (rightDiagonalDownContainsOtherQ(chessMatrix, row, col)) { // <- Десен долен диагонал
                        break;
                    }

                    // Ако мине всички проверки съм открил, принтирам позицията и напускам програмата
                    System.out.println(row + " " + col);
                    return;

                }

            }

        }

    }

    private static char[][] fillInCharChessMatrixWithoutWhitespaces(Scanner scanner) {
        // Прочита от конзолата шах матрица - 8 на 8
        char[][] chessMatrix = new char[8][8];

        for (int row = 0; row < chessMatrix.length; row++)

            chessMatrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

        return chessMatrix;
    }

    private static boolean horizontalContainsOtherQ(char[][] matrix, int matrixRow, int matrixColumn) {
        // Проверявам хоризонтално за други кралици
        for (int row = 0; row < matrix[matrixRow].length; row++) {

            if (row == matrixColumn) { // <- Пропускам където съм открил текущата
                continue;
            }
            char symbol = matrix[matrixRow][row];

            if (symbol == 'q')
                return true;

        }

        return false;
    }

    private static boolean verticalContainsOtherQ(char[][] matrix, int matrixRow, int matrixColumn) {
        // Проверявам вертикално за други кралици
        for (int row = 0; row < matrix.length; row++) {

            if (row == matrixRow) { // <- Пропускам където съм открил текущата
                continue;
            }
            char symbol = matrix[row][matrixColumn];

            if (symbol == 'q')
                return true;

        }

        return false;
    }

    private static boolean leftDiagonalUpContainsOtherQ(char[][] matrix, int matrixRow, int matrixColumn) {
        // Проверявам ляв горен диагонал за други кралици
        int currentCol = matrixColumn - 1;
        int currentRow = matrixRow - 1;

        while (currentCol >= 0 && currentRow >= 0) {

            char symbol = matrix[currentRow][currentCol];
            currentCol--;
            currentRow--;

            if (symbol == 'q')
                return true;

        }

        return false;
    }

    private static boolean leftDiagonalDownContainsOtherQ(char[][] matrix, int matrixRow, int matrixColumn) {
        // Проверявам ляв долен диагонал за други кралици
        int currentCol = matrixColumn - 1;
        int currentRow = matrixRow + 1;

        while (currentCol >= 0 && currentRow <= 7) {

            char symbol = matrix[currentRow][currentCol];
            currentCol--;
            currentRow++;

            if (symbol == 'q')
                return true;

        }

        return false;
    }

    private static boolean rightDiagonalUpContainsOtherQ(char[][] matrix, int matrixRow, int matrixColumn) {
        // Проверявам десен горен диагонал за други кралици
        int currentCol = matrixColumn + 1;
        int currentRow = matrixRow - 1;

        while (currentCol <= 7 && currentRow >= 0) {

            char symbol = matrix[currentRow][currentCol];
            currentCol++;
            currentRow--;

            if (symbol == 'q')
                return true;

        }

        return false;
    }

    private static boolean rightDiagonalDownContainsOtherQ(char[][] matrix, int matrixRow, int matrixColumn) {
        // Проверявам десен долен диагонал за други кралици
        int currentCol = matrixColumn + 1;
        int currentRow = matrixRow + 1;

        while (currentCol <= 7 && currentRow <= 7) {

            char symbol = matrix[currentRow][currentCol];
            currentCol++;
            currentRow++;

            if (symbol == 'q')
                return true;

        }

        return false;
    }

}
