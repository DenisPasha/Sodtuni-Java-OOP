package P07ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P3EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rangeStart = 1;
        int rangeEnd = 100;
        List<Integer> numberList = new ArrayList<>();

        String num = scanner.nextLine();

        while (numberList.size() < 10){
            try {
                int number = Integer.parseInt(num);
                if (number > rangeStart && number < rangeEnd){
                    numberList.add(number);
                    rangeStart = number;
                }else {
                    System.out.printf("Your number is not in range %d - 100!%n",rangeStart);
                }

            }catch (NumberFormatException e){
                System.out.println("Invalid Number!");
            }
            num = scanner.nextLine();
        }

        List<String> numbersStringList = new ArrayList<>();
        numberList.stream().forEach(number -> numbersStringList.add(String.valueOf(number)));

        System.out.println(String.join(", ",numbersStringList));

    }
}
