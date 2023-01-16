package P04InterfacesAndAbstraction.Exercise.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Citizen> citizenListlist = new ArrayList<>();
        List<Rebel> rebelList = new ArrayList<>();
       int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=n; i++) {

            String[] inputArr = scanner.nextLine().split(" ");
            if (inputArr.length==4){
                String name = inputArr[0];
                int age = Integer.parseInt(inputArr[1]);
                String id = inputArr[2];
                String birthDate = inputArr[3];
                Citizen citizen = new Citizen(name,age,id,birthDate);
                citizenListlist.add(citizen);
            }else {
                String name = inputArr[0];
                int age = Integer.parseInt(inputArr[1]);
                String group = inputArr[2];
                Rebel rebel = new Rebel(name,age,group);
                rebelList.add(rebel);

            }
        }

        String names = scanner.nextLine();
        while (!names.equals("End")){

            String finalNames = names;
            citizenListlist.forEach(element->{
              if(element.getName().equals(finalNames)){
                  element.buyFood();
              }
          });

            rebelList.forEach(element->{
                if(element.getName().equals(finalNames)){
                    element.buyFood();
                }
            });

            names = scanner.nextLine();
        }
        System.out.println();
        int totalOfCitizens = citizenListlist.stream().mapToInt(Buyer::getFood).sum();
        int totalOfRebels = rebelList.stream().mapToInt(Buyer::getFood).sum();



        System.out.println(totalOfCitizens+totalOfRebels);

    }
}
