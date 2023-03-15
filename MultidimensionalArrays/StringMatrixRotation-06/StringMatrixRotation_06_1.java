package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine().replaceAll("\\D", "")); // <- Градуси
        int rotationAngle = rotation % 360; // <- Ъгъл на завъртане

        String matrixLines = scanner.nextLine();
        List<String> matrixList = new ArrayList<>(); // <- Запълвам списък, от който ще направя матрица

        while (!matrixLines.equals("END")) {
            matrixList.add(matrixLines);
            matrixLines = scanner.nextLine();
        }

        int sizeMax = getLongestLengthElementInList(matrixList); // <- Взимам най-дългата дума в списъка
        // Запълвам матрица от чарове
        char[][] matrix = getRectangleCharMatrixFromStringList(matrixList, sizeMax);

        printMatrixByRotationAngle(matrix, rotationAngle); // <- Принтирам според ъгъла на завъртане

    }

    private static char[][] getRectangleCharMatrixFromStringList(List<String> matrixList, int sizeMax) {
        // Запълва матрица от чарове от списък <- Масиви, размер на списък, най-дълга дума - колони
        char[][] matrix = new char[matrixList.size()][sizeMax];

        for (int row = 0; row < matrix.length; row++) {

            String currentWord = matrixList.get(row); // <- Текущата дума в списъка

            for (int col = 0; col < matrix[row].length; col++)

                if (col < currentWord.length()) { // <- Пълни матрицата със символи от текущата дума в списъка

                    char currentSymbol = currentWord.charAt(col);
                    matrix[row][col] = currentSymbol;

                } else // <- Запълва празните места, до края на най-дългата дума

                    matrix[row][col] = ' ';

        }

        return matrix;
    }

    private static int getLongestLengthElementInList(List<String> matrixList) {
        // Намирам дължината на най-дългата дума в списъка
        int size = Integer.MIN_VALUE;

        for (String current : matrixList)

            if (current.length() > size)
                size = current.length();

        return size;
    }

    private static void printMatrixByRotationAngle(char[][] matrix, int rotationAngle) {
        // Принтирам според ъгъла на завъртане
        switch (rotationAngle) {

            case 0: // <- 0

                print0Degree(matrix);
                break;

            case 90: // <- 90

                print90Degrees(matrix);
                break;

            case 180: // <- 180

                print180Degrees(matrix);
                break;

            case 270: // <- 270

                print270Degrees(matrix);
                break;

        }

    }

    private static void print90Degrees(char[][] matrix) { // <- 90

        for (int col = 0; col < matrix[0].length; col++) {

            for (int row = matrix.length - 1; row >= 0; row--) {

                System.out.print(matrix[row][col]);

            }
            System.out.println();
        }

    }

    private static void print0Degree(char[][] matrix) { // <- 0

        for (char[] arr : matrix) {

            for (char symbol : arr) {

                System.out.print(symbol);

            }
            System.out.println();
        }
    }

    private static void print180Degrees(char[][] matrix) { // <- 180

        for (int row = matrix.length - 1; row >= 0; row--) {

            for (int col = matrix[row].length - 1; col >= 0; col--) {

                System.out.print(matrix[row][col]);

            }
            System.out.println();
        }
    }

    private static void print270Degrees(char[][] matrix) { // <- 270

        for (int col = matrix[0].length - 1; col >= 0; col--) {

            for (int row = 0; row < matrix.length; row++) {

                System.out.print(matrix[row][col]);

            }

            System.out.println();
        }
    }

}
