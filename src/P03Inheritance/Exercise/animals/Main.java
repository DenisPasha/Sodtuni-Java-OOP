package P03Inheritance.Exercise.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!command.equals("Beast!")){

            String[] detailsArr = scanner.nextLine().split(" ");
            String name ="";
            int age = 0;
            String gender= "";
            switch (command){
                case "Dog":
                     name = detailsArr[0];
                     age = Integer.parseInt(detailsArr[1]);
                     gender = detailsArr[2];
                    Dog dog = new Dog(name,age,gender);
                    animals.add(dog);
                    break;
                case "Cat":
                    name = detailsArr[0];
                    age = Integer.parseInt(detailsArr[1]);
                    gender = detailsArr[2];
                    Cat cat = new Cat(name,age,gender);
                    animals.add(cat);
                    break;
                case "Frog":
                    name = detailsArr[0];
                    age = Integer.parseInt(detailsArr[1]);
                    gender = detailsArr[2];
                    Frog frog = new Frog(name,age,gender);
                    animals.add(frog);
                    break;
                case "Kittens":
                    name = detailsArr[0];
                    age = Integer.parseInt(detailsArr[1]);
                    gender = detailsArr[2];
                    Kitten kittens = new Kitten(name,age,gender);
                    animals.add(kittens);
                    break;
                case "Tomcat":
                    name = detailsArr[0];
                    age = Integer.parseInt(detailsArr[1]);
                    gender = detailsArr[2];
                    Tomcat tomcats = new Tomcat(name,age,gender);
                    animals.add(tomcats);
                    break;
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            System.out.println(animal.getClass().getSimpleName());
            System.out.println(animal);
        }

    }
}
