package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageEachTurn = Double.parseDouble(scanner.nextLine());

        int[] playerPosition = new int[]{7, 7}; // <- Начална позиция на играча, ред[0], колона[1]

        int playerHp = 18500;
        double heiganHp = 3000000;

        boolean hasActiveCloudSpell = false; // <- Дали има активна Cloud магия, от предния рунд
        String lastSpell = null; // <- Последно използвана магия

        while (heiganHp > 0 && playerHp > 0) {

            if (hasActiveCloudSpell) {
                // Ако има активна Cloud магия, се изваждат -3500 и вече не е активна
                playerHp -= 3500;
                hasActiveCloudSpell = false;

            }

            heiganHp -= damageEachTurn; // <- Всеки рунд

            if (playerHp <= 0) {
                break;
            } else if (heiganHp <= 0.0) {
                break;
            }

            int[][] heigansChamber = new int[15][15]; // <- Поле за игра
            String[] spellArr = scanner.nextLine().split("\\s+");
            String spell = spellArr[0];
            lastSpell = spell.equals("Cloud")
                    ? "Plague Cloud"
                    : "Eruption";
            int row = Integer.parseInt(spellArr[1]);
            int col = Integer.parseInt(spellArr[2]);

            getChamberSpelled(heigansChamber, row, col); // <- Текущия рунд, полетата който прилага магията

            switch (spell) {

                case "Cloud": // <- Ако е Cloud

                    // Ако върху полето има магия и иргача не може да се мръдне, остава там
                    if (currentPositionIsSpelled(heigansChamber, playerPosition)) {

                        if (playerPositionCanNotBeMoved(heigansChamber, playerPosition)) {
                            hasActiveCloudSpell = true;
                            playerHp -= 3500;

                        }
                    }

                    break;

                case "Eruption": // <- Ако е Еruption

                    // Ако върху полето има магия и иргача не може да се мръдне, остава там
                    if (currentPositionIsSpelled(heigansChamber, playerPosition)) {

                        if (playerPositionCanNotBeMoved(heigansChamber, playerPosition)) {

                            playerHp -= 6000;

                        }

                    }

                    break;
            }

        }

        printOutput(playerHp, heiganHp, playerPosition, lastSpell);

    }

    private static boolean isIndexInBounds(int[][] matrix, int row, int col) {
        // Проверява границите на матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void getChamberSpelled(int[][] matrix, int currentRow, int currentCol) {
        // Омагьосаните полета на с 1, ако са в границите на матрицата
        for (int row = currentRow - 1; row <= currentRow + 1; row++)

            for (int col = currentCol - 1; col <= currentCol + 1; col++)

                if (isIndexInBounds(matrix, row, col))

                    matrix[row][col] = 1;

    }

    private static boolean currentPositionIsSpelled(int[][] matrix, int[] currentPosition) {
        // Проверява дали върху това поле има магия
        return matrix[currentPosition[0]][currentPosition[1]] == 1;
    }

    private static boolean playerPositionCanNotBeMoved(int[][] matrix, int[] currentPosition) {
        // up, right, down, left
        int row = currentPosition[0];
        int col = currentPosition[1];

        // Играча се опитва да мръдне в определена посока, ако не може - поради магия или стена,
        // остава там където е бил
        if (isIndexInBounds(matrix, row - 1, col) && matrix[row - 1][col] != 1) { // <- Up

            currentPosition[0] = row - 1;
            return false;
        } else if (isIndexInBounds(matrix, row, col + 1) && matrix[row][col + 1] != 1) { // <- Right

            currentPosition[1] = col + 1;
            return false;
        } else if (isIndexInBounds(matrix, row + 1, col) && matrix[row + 1][col] != 1) { // <- Down

            currentPosition[0] = row + 1;
            return false;
        } else if (isIndexInBounds(matrix, row, col - 1) && matrix[row][col - 1] != 1) { // <- Left

            currentPosition[1] = col - 1;
            return false;
        } else

            return true;
    }

    private static void printOutput(int playerHp, double heiganHp, int[] playerPosition, String lastSpell) {

        // Важно, е че могат да умрат в един и същ рунд!
        if (heiganHp > 0)
            System.out.printf("Heigan: %.2f\n", heiganHp);
        else
            System.out.println("Heigan: Defeated!");

        if (playerHp > 0)
            System.out.printf("Player: %d\n", playerHp);
        else
            System.out.printf("Player: Killed by %s\n", lastSpell);

        System.out.printf("Final position: %d, %d\n", playerPosition[0], playerPosition[1]);

    }

}
