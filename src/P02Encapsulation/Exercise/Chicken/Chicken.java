package P02Encapsulation.Exercise.Chicken;

public class Chicken {

    private  String name;
    private int age;


    //constructor
    public Chicken(String name , int age){
        setName(name);
        setAge(age);
    }

    //setters
    public void setName(String name) {
        if (name.trim().length() > 0){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 15){
            this.age = age;
        }else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    private double calculateProductPerDay(){

        double result = 0;
        if (this.age >= 0 && this.age <= 5){
            result = 2.00;
        } else if (this.age >=6 && this.age <=11) {
            result = 1;
        } else  {
            result = 0.75;
        }

        return result;
    }

    @Override
    public String toString(){
        double result = productPerDay();
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",this.name,this.age,result);
    }
}
