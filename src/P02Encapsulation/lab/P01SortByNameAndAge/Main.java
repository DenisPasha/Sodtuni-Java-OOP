package P02Encapsulation.lab.P01SortByNameAndAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int personsCount = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < personsCount; i++) {
            String[] input = scanner.nextLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }

        Collections.sort(people, (firstPerson, secondPerson) -> {
            int result = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (result == 0){
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
          return result;
        });

        for (Person person : people) {
            System.out.println(person.toString());

        }
    }


}
