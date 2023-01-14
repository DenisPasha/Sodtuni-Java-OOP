package P02Encapsulation.Exercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> productList;


    //constructor
    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.productList = new ArrayList<>();
    }

    // setters
    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.productList.add(product);
            this.money = this.money - product.getCost();
        } else {
            System.out.printf("%s can't afford %s", this.name, product.getName());
        }
    }

    public String getName() {
        return name;
    }
}
