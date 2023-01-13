package P01Abstraction.Exercise.P01CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Ranks:");
        CardRank[] cardRankArr = CardRank.values();

        for (CardRank cardRank:cardRankArr) {
            System.out.printf("Ordinal value: %d; ",cardRank.ordinal());
            System.out.printf("Name value: %s%n",cardRank.name());
        }

    }
}
