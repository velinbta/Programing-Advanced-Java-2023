package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine().replaceAll("\\D", "")); // <- Градуси
        String matrixLines = scanner.nextLine();
        List<String> matrixList = new ArrayList<>(); // <- Запълвам списък, от който ще направя матрица

        while (!matrixLines.equals("END")) {
            matrixList.add(matrixLines);
            matrixLines = scanner.nextLine();
        }

        int sizeMax = getLongestLengthElementInList(matrixList); // <- Взимам най-дългата дума в списъка
        // Запълвам матрица от чарове
        char[][] matrix = getRectangleCharMatrixFromStringList(matrixList, sizeMax);

        int rotationRepetitions = rotation / 90;
        while (rotationRepetitions > 0) { // <- Всеки път деля на 90

            matrix = getMatrixRotated(matrix); // <- Обръщам матрицата с по 90 градуса

            rotationRepetitions--; // <- Намалям обръщанията
        }

        printRotatedMatrix(matrix); // <- Принтирам крайната матрица

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
        int size = 0;

        for (String current : matrixList)

            if (current.length() > size)
                size = current.length();

        return size;
    }

    private static char[][] getMatrixRotated(char[][] matrix) {
        // Извеждам минималната и максимална дължина
        int minLength = Math.min(matrix.length, matrix[0].length);
        int maxLength = Math.max(matrix.length, matrix[0].length);

        if (matrix.length > matrix[0].length) { // <- Ако редът е по-дълъг от колоната

            char[][] rotatedMatrix = new char[minLength][maxLength]; // <- Обърната дължина на матрица

            int rowRotation = maxLength - 1;

            for (int row = 0; row < matrix.length; row++, rowRotation--)

                for (int col = 0; col < matrix[row].length; col++) {

                    char currentElement = matrix[row][col];

                    rotatedMatrix[col][rowRotation] = currentElement; // <- Презаписвам елементите на новата матрица

                }

            return rotatedMatrix; // <- Връщам новата матрица

        } else { // <- Ако колоната е по-дълга от реда

            char[][] rotatedMatrix = new char[maxLength][minLength]; // <- Обърната дължина на матрица

            int rowRotation = minLength - 1;

            for (int row = 0; row < matrix.length; row++, rowRotation--)

                for (int col = 0; col < matrix[row].length; col++) {

                    char currentElement = matrix[row][col];

                    rotatedMatrix[col][rowRotation] = currentElement; // <- Презаписвам елементите на новата матрица

                }

            return rotatedMatrix; // <- Връщам новата матрица
        }

    }

    private static void printRotatedMatrix(char[][] matrix) {
        // Принтира крайната матрица - след завъртанията
        for (char[] arr : matrix) {

            for (char symbol : arr) {

                System.out.print(symbol);

            }
            System.out.println();
        }
    }

}
