package P05Polymorphism.lab.P02Shapes;

public class Circle extends Shape{


    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public  final double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        double result  = Math.PI * this.radius * this.radius;
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        double result = 2*Math.PI * this.radius;
        super.setArea(result);
    }
}
