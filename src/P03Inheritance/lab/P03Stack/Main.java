package P03Inheritance.lab.P03Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackOfStrings stack = new StackOfStrings();
        stack.push("denis");
        stack.push("menis");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
