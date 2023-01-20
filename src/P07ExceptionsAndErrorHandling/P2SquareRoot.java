package P07ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P2SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        try {
            int num = Integer.parseInt(number);

            if (num <= 0){
                System.out.println("Invalid");
            }else {
                System.out.printf("%.2f%n",Math.sqrt(num));
            }


        }catch (NumberFormatException e){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }



    }
}
