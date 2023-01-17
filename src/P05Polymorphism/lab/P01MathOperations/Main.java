package P05Polymorphism.lab.P01MathOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperation mathOperation = new MathOperation();
        mathOperation.add(1,2);
        mathOperation.add(1,2,3);
        mathOperation.add(1,2,3,4);
    }
}
