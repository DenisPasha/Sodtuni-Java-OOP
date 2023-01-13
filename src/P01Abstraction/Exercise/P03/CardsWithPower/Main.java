package P01Abstraction.Exercise.P03.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String rankOfCard = scanner.nextLine();
        String suitOfCard = scanner.nextLine();

        Card card = new Card(RankPowers.valueOf(rankOfCard),SuitPowers.valueOf(suitOfCard));
       double power = card.getPower();
        System.out.printf("Card name: %s of %s; Card power: %.0f",rankOfCard,suitOfCard,power);

    }
}
