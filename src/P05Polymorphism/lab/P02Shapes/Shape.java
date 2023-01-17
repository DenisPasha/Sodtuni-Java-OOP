package P05Polymorphism.lab.P02Shapes;

public abstract class Shape {

    private double perimeter;
    private double area;

    public double getArea() {
        calculateArea();
        return area;
    }

    public double getPerimeter() {
        calculatePerimeter();
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public abstract void  calculatePerimeter();
    public abstract void calculateArea();
}
