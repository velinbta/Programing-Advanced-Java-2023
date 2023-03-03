package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstDimensionsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray(); // <- Редове и колони на първа матрица

        int firstRows = firstDimensionsArr[0];
        int firstColumns = firstDimensionsArr[1];

        int[][] firstMatrix = new int[firstRows][firstColumns];

        for (int i = 0; i < firstRows; i++) { // <- Запълвам матрицата

            firstMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        }

        int[] secondDimensionsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray(); // <- Редове и колони на втора матрица

        int secondRows = secondDimensionsArr[0];
        int secondColumns = secondDimensionsArr[1];

        int[][] secondMatrix = new int[secondRows][secondColumns];

        for (int i = 0; i < secondRows; i++) { // <- Запълвам матрицата

            secondMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        }

        // Ако са различни дължината на колоните и редовете не са еднакви
        boolean haveEqualRowsAndColumns = firstRows == secondRows && firstColumns == secondColumns;

        if (!haveEqualRowsAndColumns) {

            System.out.println("not equal");

        } else {

            if (haveEqualElements(firstMatrix, secondMatrix)) { // <- Ако имат еднакви елементи

                System.out.println("equal");

            } else {

                System.out.println("not equal");

            }

        }

    }

    private static boolean haveEqualElements(int[][] firstMatrix, int[][] secondMatrix) {

        // Проверявам дали матриците съдържат еднакви елементи
        for (int i = 0; i < firstMatrix.length; i++) {

            for (int j = 0; j < firstMatrix[i].length; j++) {

                int firstElement = firstMatrix[i][j];
                int secondElement = secondMatrix[i][j];

                if (firstElement != secondElement) {
                    return false;
                }

            }

        }

        return true;
    }

}
