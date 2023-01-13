package P02Encapsulation.lab;

public class Person {

    //•	firstName: String
    //•	lastName: String
    //•	age: int
    //•	toString() - override
    private String firstName;
    private  String lastName;
    private  int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("%s %s is %d years old.",this.firstName,this.lastName,this.age);
    }
}

