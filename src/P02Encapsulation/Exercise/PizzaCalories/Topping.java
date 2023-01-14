package P02Encapsulation.Exercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    //+ 	Topping (String, double)

    public Topping (String toppingType , double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }
    //-	setToppingType (String): void
    private void setToppingType(String toppingType){

        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")){
            this.toppingType = toppingType;
        }else {
            String message = String.format("Cannot place %s on top of your pizza.",toppingType);
            throw new IllegalArgumentException(message);
        }
    }
    //-	setWeight (double): void
    private  void setWeight(double weight){
        if (weight >=1 && weight <=50){
            this.weight = weight;
        }else {
            String message = String.format("%s weight should be in the range [1..50].",this.toppingType);
            throw new IllegalArgumentException(message);
        }
    }
    //+	calculateCalories (): double

    public double calculateCalories(){
        double toppingMod = 0;

        switch (this.toppingType){
            case "Meat":
                toppingMod = 1.2;
                break;
            case "Veggies":
                toppingMod = 0.8;
                break;
            case "Cheese":
                toppingMod = 1.1;
                break;
            case "Sauce":
                toppingMod = 0.9;
                break;
        }

        return (2 * this.weight ) * toppingMod;
    }

}
