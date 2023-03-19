package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsArr = readArray(scanner.nextLine());
        int rows = dimensionsArr[0];
        int cols = dimensionsArr[1];

        boolean[][] parkingMatrix = new boolean[rows][cols]; // <- Матрица със свободните паркоместа

        String input = scanner.nextLine();

        while (!input.equals("stop")) {

            int[] coordinatesArr = readArray(input);
            int rowOfEntrance = coordinatesArr[0]; // <- Първоначален ред на влизане на автомобила
            int rowOfDesire = coordinatesArr[1]; // <- Желан ред
            int colOfDesire = coordinatesArr[2]; // <- Желана колона

            int distance = 0;

            if (isIndexInBounds(parkingMatrix, rowOfDesire, colOfDesire)) { // <- Ако желаното място е в границите

                // Ако редът на първоначално влизане е различен от желания за паркиране
                if (rowOfEntrance != rowOfDesire) {
                    int rowDistance = Math.abs(rowOfEntrance - rowOfDesire); // <- Изминато разстояние
                    distance += rowDistance;
                }

                if (!parkingMatrix[rowOfDesire][colOfDesire]) { // <- Ако мястото е свободно - го заема

                    distance += colOfDesire + 1;
                    parkingMatrix[rowOfDesire][colOfDesire] = true;

                } else { // <- Ако не е свободно, намирам най-близкото до желаното - на същия ред

                    // Намирам най-близкото ляво и най-близкото дясно място до желаното
                    int closestLeftColumn = getFirstFreeLeftColumn(parkingMatrix, rowOfDesire, colOfDesire);
                    int closestRightColumn = getFirstFreeRightColumn(parkingMatrix, rowOfDesire, colOfDesire);

                    // Ако лявото е на еднакво разстояние от дясното - се предпочита лявото (по-близкото до входа)
                    int closestColumn = getClosestColumnToRowOfDesire(closestLeftColumn, closestRightColumn, colOfDesire);

                    if (closestColumn != -1) { // <- Ако съществува свободно, го заема
                        distance += closestColumn + 1;
                        parkingMatrix[rowOfDesire][closestColumn] = true;

                    } else {

                        // Ако местата на целия ред са заети, автомобила напуска
                        // (нулева колана, по условие свободна)
                        System.out.printf("Row %d full\n", rowOfDesire);
                        input = scanner.nextLine();
                        continue;

                    }

                }

            }

            System.out.println(distance);

            input = scanner.nextLine();
        }

    }

    private static int[] readArray(String input) {
        // Прочита масив от конзолата
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
    }

    private static boolean isIndexInBounds(boolean[][] matrix, int row, int col) {
        // Проверява границите на матрицата
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int getFirstFreeLeftColumn(boolean[][] matrix, int rowOfDesire, int colOfDesire) {
        // Намира най-близката лява свободна колона до желаната
        int leftFreeCol = -1;
        for (int col = colOfDesire - 1; col > 0; col--) { // <- Без нулева колона - тя остава свободна

            boolean currentElement = matrix[rowOfDesire][col];
            if (!currentElement) {
                leftFreeCol = col;
                return leftFreeCol;
            }
        }

        return leftFreeCol;
    }

    private static int getFirstFreeRightColumn(boolean[][] matrix, int rowOfDesire, int colOfDesire) {
        // Намира най-близката дясна свободна колона до желаната
        int rightFreeCol = -1;
        for (int col = colOfDesire + 1; col < matrix[rowOfDesire].length; col++) {

            boolean currentElement = matrix[rowOfDesire][col];
            if (!currentElement) {
                rightFreeCol = col;
                return rightFreeCol;
            }
        }

        return rightFreeCol;
    }

    private static int getClosestColumnToRowOfDesire(int closestLeftColumn, int closestRightColumn, int colOfDesire) {
        // Намира най-близката свободна колона до желаната
        if (closestLeftColumn != -1 && closestRightColumn != -1) { // <- Ако има свободни и от двете места

            // По абсолютна стойност - най-близкото разстояние
            int left = Math.abs(colOfDesire - closestLeftColumn);
            int right = Math.abs(colOfDesire - closestRightColumn);

            if (left == right) // <- Ако са равни, се предпочита лявото

                return closestLeftColumn;
            else if (left < right) // <- Ако лявото е по-късо

                return closestLeftColumn;
            else // <- В противен случай - дясното

                return closestRightColumn;

        } else if (closestLeftColumn == -1) // <- Ако няма изобщо свободни в ляво

            return closestRightColumn; // <- Остава дясното

        else

            return closestLeftColumn;

    }

}
