package ExamsAdvanced;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Bee_02 {
    // Статични променливи за цветята и дали пчелата е в матрицата
    private static int flowers = 0;
    private static boolean isInTerritory = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner); // <- Прочита матрица

        int[] beePosition = findBeeInMatrix(matrix); // <- Намира пчелата

        String command = scanner.nextLine();

        label:
        while (!command.equals("End")) {

            int currentRow = beePosition[0];
            int currentCol = beePosition[1];
            clearCurrentMatrixPosition(matrix, currentRow, currentCol); // <- Текущата позиция = "."

            switch (command) {

                case "up":

                    if (isInBounds(matrix, currentRow - 1, currentCol)) { // <- Ако е в границите на матрицата

                        String letter = matrix[currentRow - 1][currentCol];

                        // Ако е бонус "O"
                        if (isBonus(letter) && isInBounds(matrix, currentRow - 2, currentCol)) {

                            clearCurrentMatrixPosition(matrix, currentRow - 1, currentCol);

                            // Ако е бонус, премества пчелата още една позиция
                            incrementIfLetterIsFlower(matrix[currentRow - 2][currentCol]);
                            moveBee(matrix, beePosition, currentRow - 2, currentCol);

                        } else {

                            incrementIfLetterIsFlower(letter);

                        }

                        if (!isBonus(letter)) {

                            moveBee(matrix, beePosition, currentRow - 1, currentCol);

                        }

                    } else { // <- Ако не е в границите на матрицата

                        isInTerritory = false;
                        break label;

                    }

                    break;

                case "down":

                    if (isInBounds(matrix, currentRow + 1, currentCol)) { // <- Ако е в границите на матрицата

                        String letter = matrix[currentRow + 1][currentCol];

                        // Ако е бонус "O"
                        if (isBonus(letter) && isInBounds(matrix, currentRow + 2, currentCol)) {

                            clearCurrentMatrixPosition(matrix, currentRow + 1, currentCol);

                            // Ако е бонус, премества пчелата още една позиция
                            incrementIfLetterIsFlower(matrix[currentRow + 2][currentCol]);
                            moveBee(matrix, beePosition, currentRow + 2, currentCol);

                        } else {

                            incrementIfLetterIsFlower(letter);

                        }

                        if (!isBonus(letter)) {

                            moveBee(matrix, beePosition, currentRow + 1, currentCol);

                        }

                    } else { // <- Ако не е в границите на матрицата

                        isInTerritory = false;
                        break label;

                    }

                    break;

                case "left":

                    if (isInBounds(matrix, currentRow, currentCol - 1)) { // <- Ако е в границите на матрицата

                        String letter = matrix[currentRow][currentCol - 1];

                        if (isBonus(letter) && isInBounds(matrix, currentRow, currentCol - 2)) {

                            clearCurrentMatrixPosition(matrix, currentRow, currentCol - 1);

                            // Ако е бонус, премества пчелата още една позиция
                            incrementIfLetterIsFlower(matrix[currentRow][currentCol - 2]);
                            moveBee(matrix, beePosition, currentRow, currentCol - 2);

                        } else {

                            incrementIfLetterIsFlower(letter);

                        }

                        if (!isBonus(letter)) {

                            moveBee(matrix, beePosition, currentRow, currentCol - 1);

                        }

                    } else { // <- Ако не е в границите на матрицата

                        isInTerritory = false;
                        break label;

                    }

                    break;

                case "right":

                    if (isInBounds(matrix, currentRow, currentCol + 1)) { // <- Ако е в границите на матрицата

                        String letter = matrix[currentRow][currentCol + 1];

                        if (isBonus(letter) && isInBounds(matrix, currentRow, currentCol + 2)) {

                            clearCurrentMatrixPosition(matrix, currentRow, currentCol + 1);

                            // Ако е бонус, премества пчелата още една позиция
                            incrementIfLetterIsFlower(matrix[currentRow][currentCol + 2]);
                            moveBee(matrix, beePosition, currentRow, currentCol + 2);

                        } else {

                            incrementIfLetterIsFlower(letter);

                        }

                        if (!isBonus(letter)) {

                            moveBee(matrix, beePosition, currentRow, currentCol + 1);

                        }


                    } else { // <- Ако не е в границите на матрицата

                        isInTerritory = false;
                        break label;

                    }

                    break;

            }

            command = scanner.nextLine();

        }

        String output = getOutput(matrix);
        System.out.println(output);

    }

    private static void clearCurrentMatrixPosition(String[][] matrix, int row, int col) {
        // "Чисти" текущата позиция в матрицата
        matrix[row][col] = ".";
    }

    private static void moveBee(String[][] matrix, int[] beePosition, int neededRow, int neededCol) {
        // Премества пчелата
        beePosition[0] = neededRow;
        beePosition[1] = neededCol;

        matrix[neededRow][neededCol] = "B";

    }

    private static String[][] readMatrix(Scanner scanner) {
        // Прочита квадратна матрица
        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeMatrix][];

        IntStream.range(0, matrix.length).forEach(row ->
                matrix[row] = scanner.nextLine().split(""));

        return matrix;
    }

    private static int[] findBeeInMatrix(String[][] matrix) {
        // Намира пчелата в матрицата
        int[] beePosition = new int[2];

        for (int row = 0; row < matrix.length; row++)

            for (int col = 0; col < matrix[row].length; col++)

                if (matrix[row][col].equals("B")) {
                    beePosition[0] = row;
                    beePosition[1] = col;
                    return beePosition;
                }

        return beePosition;
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        // Проверява, дали пчелата остава в полето
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static String getOutput(String[][] matrix) {
        // Билдва изходните данни
        StringBuilder output = new StringBuilder();

        if (!getIsInTerritory()) {
            output.append("The bee got lost!");
            output.append(System.lineSeparator());
        }

        if (getFlowers() > 4) {
            output.append(String.format("Great job, the bee manage to pollinate %d flowers!", getFlowers()));
            output.append(System.lineSeparator());
        } else {
            output.append(String.format("The bee couldn't pollinate the flowers, she needed %d flowers more",
                    Math.abs(getFlowers() - 5)));
            output.append(System.lineSeparator());
        }

        IntStream.range(0, matrix.length).forEach(row -> {
            IntStream.range(0, matrix[row].length).forEach(col -> output.append(matrix[row][col]));
            if (row != matrix.length - 1) {
                output.append(System.lineSeparator());
            }
        });

        return output.toString();
    }

    private static boolean isFlower(String letter) {
        return letter.equals("f");
    }

    private static boolean isBonus(String letter) {
        return letter.equals("O");
    }

    private static void incrementIfLetterIsFlower(String letter) {
        // Увеличава броя на цветята
        if (isFlower(letter))
            flowers++;
    }

    private static int getFlowers() {
        // Връща броя на цветята
        return flowers;
    }

    private static boolean getIsInTerritory() {
        return isInTerritory;
    }

}
