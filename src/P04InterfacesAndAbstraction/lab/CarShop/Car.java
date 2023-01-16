package P04InterfacesAndAbstraction.lab.CarShop;

public interface Car {
    int TIRES = 4;
    //+getModel(): String
    String getModel();
    //+getColor(): String
    String getColor();
    //+getHorsePower(): Integer
    int getHorsePower();
    //+countryProduced(): String
    String countryProduced();

}
