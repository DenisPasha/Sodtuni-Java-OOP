package P04InterfacesAndAbstraction.Exercise.FoodShortage;

public class Robot implements Identifiable {
    //-	id: String
    //-	model: String
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }


    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
