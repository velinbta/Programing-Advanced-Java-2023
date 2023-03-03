package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsInMatrix = Integer.parseInt(scanner.nextLine().split("\\s+")[0]); // <- Брой масиви в матрицата

        int[][] matrix = fillInMatrix(scanner, rowsInMatrix); // <- Запълвам матрицата

        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int rows = 0; rows < matrix.length; rows++) { // <- Търся числото в матрицата

            for (int columns = 0; columns < matrix[rows].length; columns++) {

                if (matrix[rows][columns] == numberToFind) {
                    isFound = true;
                    System.out.printf("%d %d\n", rows, columns);
                }

            }

        }

        if (!isFound) {

            System.out.println("not found");

        }

    }

    private static int[][] fillInMatrix(Scanner scanner, int rows) { // <- Запълвам матрицата

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }

        return matrix;
    }

}
