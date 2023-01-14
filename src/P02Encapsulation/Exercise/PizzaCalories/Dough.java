package P02Encapsulation.Exercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    //+ 	Dought (String, String, double)
    public Dough(String flourType, String bakingTechnique,double weight){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }
    //-	setWeight(double): void
    private void setWeight(double weight){
        if (weight >=1 && weight<=200){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    //-	setFlourType(String): void
    private void setFlourType(String flourType){
        if (flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
    //-	setBakingTechnique(String): void
    private void setBakingTechnique(String bakingTechnique){
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")){
            this.bakingTechnique = bakingTechnique;
        }else {
            throw new IllegalArgumentException("Invalid BakingTechnique.");
        }
    }
    //+	calculateCalories (): double
    public double calculateCalories(){
        double bakingTechniqueMod = 0;
        double flourMod = 0;

        if (this.bakingTechnique.equals("Crispy")){
            bakingTechniqueMod = 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            bakingTechniqueMod = 1.1;
        } else if (this.bakingTechnique.equals("Homemade")) {
            bakingTechniqueMod = 1.00;
        }

        if (this.flourType.equals("White")){
            flourMod = 1.5;
        } else if (this.flourType.equals("Wholegrain")) {
            flourMod = 1.00;
        }

        return (2 * this.weight ) * flourMod * bakingTechniqueMod;

    }



}
