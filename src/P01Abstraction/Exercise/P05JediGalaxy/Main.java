package P01Abstraction.Exercise.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        fillMAtrix(rows, cols, matrix, value);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowOfEvil = evilCoordinates[0];
            int colOFEvil = evilCoordinates[1];

            moveEvil(matrix, rowOfEvil, colOFEvil);

            int rowOfHero = heroCoordinates[0];
            int colOfHero = heroCoordinates[1];

            sum = getSum(matrix, sum, rowOfHero, colOfHero);

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static void moveEvil(int[][] matrix, int rowOfEvil, int colOFEvil) {
        while (rowOfEvil >= 0 && colOFEvil >= 0) {
            if (rowOfEvil < matrix.length && colOFEvil < matrix[0].length) {
                matrix[rowOfEvil][colOFEvil] = 0;
            }
            rowOfEvil--;
            colOFEvil--;
        }
    }

    private static long getSum(int[][] matrix, long sum, int rowOfHero, int colOfHero) {
        while (rowOfHero >= 0 && colOfHero < matrix[1].length) {
            if (rowOfHero < matrix.length && colOfHero >= 0 && colOfHero < matrix[0].length) {
                sum += matrix[rowOfHero][colOfHero];
            }

            colOfHero++;
            rowOfHero--;
        }
        return sum;
    }

    private static void fillMAtrix(int rows, int cols, int[][] matrix, int value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
