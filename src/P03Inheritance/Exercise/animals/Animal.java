package P03Inheritance.Exercise.animals;

public abstract class Animal {
   private String name;
   private int age;
   private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()){
            System.out.println("Invalid input!");
        }else {
            this.name = name;
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            System.out.println("Invalid input!");
        }else {
            this.age = age;
        }

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.trim().isEmpty()){
            System.out.println("Invalid input!");
        }else {
            this.gender = gender;
        }

    }

    public abstract String produceSound();

    public String toString(){
        return String.format("%s %s %s%n" +
                "%s",this.name,this.age,this.gender,produceSound());
    }
}
