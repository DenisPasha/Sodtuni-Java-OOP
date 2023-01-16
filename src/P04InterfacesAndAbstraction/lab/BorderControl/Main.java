package P04InterfacesAndAbstraction.lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        List<Identifiable> list = new ArrayList<>();

        while (!inputArr[0].equals("End")) {

            if (inputArr.length == 2) {
                String id = inputArr[0];
                String model = inputArr[1];
                Robot robot = new Robot(id, model);
                list.add(robot);
            } else {
                String name = inputArr[0];
                int age = Integer.parseInt(inputArr[1]);
                String id = inputArr[2];
                Citizen citizen = new Citizen(name, age, id);
                list.add(citizen);

            }

            inputArr = scanner.nextLine().split(" ");
        }

        String wantedId = scanner.nextLine();
        for (Identifiable thing: list) {
           String id = thing.getId();
            if (thing.getId().endsWith(wantedId)){
                System.out.println(thing.getId());
            }
        }
    }
}
