package P01Abstraction.lab.P01Rhobus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        rhombusFirstHalf(n);


        rhombusSecondHalf(n);
    }

    private static void rhombusSecondHalf(int n) {
        for (int i = n -1; i >=1 ; i--) {
            printStars(n, i);
        }
    }

    private static void rhombusFirstHalf(int n) {
        for (int i = 1; i <= n; i++) {
            printStars(n, i);
        }
    }

    private static void printStars(int n, int i) {
        System.out.println();
        for (int j = 1; j <= n - i; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }
    }
}
