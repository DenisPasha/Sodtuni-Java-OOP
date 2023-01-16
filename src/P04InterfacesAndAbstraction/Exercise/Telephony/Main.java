package P04InterfacesAndAbstraction.Exercise.Telephony;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        List<String> numbersList = List.of(numbers);
        String[] urls = scanner.nextLine().split(" ");
        List<String>urlsList = List.of(urls);
        System.out.println();

        Smartphone smartPhone = new Smartphone(numbersList,urlsList);

        System.out.println(smartPhone.toString());

    }
}
