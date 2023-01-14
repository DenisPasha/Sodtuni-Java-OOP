package P02Encapsulation.Exercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    //+ 	Piza (String, int numberOfToppings)
    public Pizza(String name, int numberOfToppings){
        setName(name);
    }

    //-	setToppings(int) : void
    private void setToppings(int numberOfToppings){
        if (numberOfToppings >= 0 && numberOfToppings <= 10){
            this.toppings = new ArrayList<>(numberOfToppings);
        }else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }
    //-	setName(String) : void
    private void setName(String name){
        if (!name.trim().isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }
    //+	setDough(Dough) : void
    public void setDough(Dough dough){
        this.dough = dough;
    }
    //+	getName(): String

    public String getName() {
        return name;
    }

    //+	addTopping (Topping) : void
    public void addTopping(Topping topping){
        this.toppings.add(topping);

    }
    //+	getOverallCalories () : double
    public double getOverallCalories(){
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(value -> value.calculateCalories()).sum();
    }
}
