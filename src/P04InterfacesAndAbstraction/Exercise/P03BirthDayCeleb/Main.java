package P04InterfacesAndAbstraction.Exercise.P03BirthDayCeleb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(" ");
        List<Birthable> list = new ArrayList<>();

        while (!inputArr[0].equals("End")){

            if (inputArr.length==5){
                 //{name} {age} {id} {birthdate
                String name = inputArr[1];
                int age = Integer.parseInt(inputArr[2]);
                String id = inputArr[3];
                String birthDate = inputArr[4];
                Citizen citizen = new Citizen(name,age,id,birthDate);
                list.add(citizen);
                
            } else if (inputArr.length==3 && inputArr[0].equals("Robot")) {
                //Robot {model} {id}"
                String model = inputArr[1];
                String id = inputArr[2];

                Robot robot = new Robot(id,model);

            }else {
                //name} {birthdate}"
                String name = inputArr[1];
                String birthDate = inputArr[2];
                Pet pet = new Pet(name,birthDate);
                list.add(pet);

            }


            inputArr = scanner.nextLine().split(" ");
        }

        String yearWanted = scanner.nextLine();
        list.forEach(birthable -> {
            if (birthable.getBirthDate().endsWith(yearWanted)){
                System.out.println(birthable.getBirthDate());
            }
        });



    }
}
