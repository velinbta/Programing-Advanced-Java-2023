package ExamsAdvanced;

import java.util.Arrays;
import java.util.Scanner;

public class RallyRacing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfSquareMatrix = Integer.parseInt(scanner.nextLine()); // <- Квадратна матрица
        String carNumber = scanner.nextLine();

        char[][] routeMatrix = fillInSquareCharMatrix(scanner, sizeOfSquareMatrix); // <- Прочитам я от конзолата

        String direction = scanner.nextLine();

        int distance = 0;

        int carCurrentRow = 0; // <- Текущ ред на автомобила
        int carCurrentCol = 0; // <- Текуща колона на автомобила

        int[] firstTunnelArr = findFirstTunnel(routeMatrix); // <- Намирам първия тунел - [0]Ред, [1]Колона
        int[] secondTunnelArr = findSecondTunnel(routeMatrix); // <- Намирам втория тунел - [0]Ред, [1]Колона

        boolean isFinished = false;

        label:
        while (!direction.equals("End")) {

            switch (direction) { // <- Местя положението на автомобила според посоката

                case "left": // <- Ляво

                    if (isIndexInBounds(routeMatrix, carCurrentRow, carCurrentCol - 1)) {
                        carCurrentCol -= 1;
                    }
                    break;

                case "right": // <- Дясно

                    if (isIndexInBounds(routeMatrix, carCurrentRow, carCurrentCol + 1)) {
                        carCurrentCol += 1;
                    }
                    break;

                case "up": // <- Горе

                    if (isIndexInBounds(routeMatrix, carCurrentRow - 1, carCurrentCol)) {
                        carCurrentRow -= 1;
                    }
                    break;

                case "down": // <- Долу

                    if (isIndexInBounds(routeMatrix, carCurrentRow + 1, carCurrentCol)) {
                        carCurrentRow += 1;
                    }
                    break;
            }

            char currentCarPosition = routeMatrix[carCurrentRow][carCurrentCol];

            // Ако в матрицата автомобила се намира на:
            switch (currentCarPosition) {

                case '.':
                    distance += 10;
                    break;

                case 'T':
                    // Ако попадне на един от тунелите, се премества в другия и двата тунела се закриват
                    if (carCurrentRow == firstTunnelArr[0] && carCurrentCol == firstTunnelArr[1]) { // <- Първи тунел

                        // Отива във втори
                        carCurrentRow = secondTunnelArr[0];
                        carCurrentCol = secondTunnelArr[1];

                    } else { // <- Втори тунел

                        // Отива в първи
                        carCurrentRow = firstTunnelArr[0];
                        carCurrentCol = firstTunnelArr[1];

                    }

                    routeMatrix[firstTunnelArr[0]][firstTunnelArr[1]] = '.';
                    routeMatrix[secondTunnelArr[0]][secondTunnelArr[1]] = '.';

                    distance += 30;
                    break;

                case 'F':
                    // Ако попадне на финал
                    distance += 10;
                    isFinished = true;
                    break label; // <- Прекратявам цикъла

            }

            direction = scanner.nextLine();
        }

        routeMatrix[carCurrentRow][carCurrentCol] = 'C'; // <- Поставям местоположението на автомобила в матрицата

        printOutput(routeMatrix, isFinished, carNumber, distance); // <- Принтирам изходните данни

    }

    private static char[][] fillInSquareCharMatrix(Scanner scanner, int size) {
        // Прочита квадратна чар матрица
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++)

            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

        return matrix;
    }

    private static boolean isIndexInBounds(char[][] matrix, int row, int col) {
        // Проверява дали ред и колона са в границите на матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] findFirstTunnel(char[][] matrix) {
        // Намира първи тунел
        int[] firstTunnel = new int[2];

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)

                if (matrix[row][col] == 'T') {

                    firstTunnel[0] = row;
                    firstTunnel[1] = col;
                    return firstTunnel;
                }

        return firstTunnel;
    }

    private static int[] findSecondTunnel(char[][] matrix) {
        // Намира втори тунел
        int[] secondTunnel = new int[2];

        for (int row = matrix.length - 1; row >= 0; row--)
            for (int col = matrix[row].length - 1; col >= 0; col--)

                if (matrix[row][col] == 'T') {

                    secondTunnel[0] = row;
                    secondTunnel[1] = col;
                    return secondTunnel;
                }

        return secondTunnel;
    }

    private static void printOutput(char[][] matrix, boolean isFinished, String carNumber, int distance) {
        // Принтира изходните данни
        String output = isFinished
                ? String.format("Racing car %s finished the stage!\n", carNumber)
                : String.format("Racing car %s DNF.\n", carNumber);

        System.out.print(output);

        System.out.printf("Distance covered %d km.\n", distance);

        Arrays.stream(matrix).forEach(arr -> {

            for (char current : arr) {
                System.out.print(current);
            }
            System.out.println();

        });

    }

}
