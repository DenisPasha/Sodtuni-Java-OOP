package P01Abstraction.Exercise.P01CardSuites;

public class Main {
    public static void main(String[] args) {

       CardSuitss [] suites = CardSuitss.values();
        System.out.println("Card Suits:");
        for (CardSuitss suit: suites) {
            System.out.printf("Ordinal value: %d; ",suit.ordinal());
            System.out.printf("Name value: %s%n",suit);
        }
    }
}
