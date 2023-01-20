package P07ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class P1NumberinRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rangeArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int fromNumber = rangeArr[0];
        int toNumber = rangeArr[1];

        System.out.printf("Range: [%d...%d]%n",fromNumber,toNumber);



       int validNum = validateNumber(scanner,fromNumber,toNumber);



        System.out.printf("Valid number: %d%n",validNum);


    }

    private static int validateNumber(Scanner scanner, int fromNumber, int toNumber) {
        while (true){
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= fromNumber && number <= toNumber){
                    return number;
                }
            }catch (NumberFormatException e){

            }
            System.out.printf("Invalid number: %s%n",input);
        }
    }
}
