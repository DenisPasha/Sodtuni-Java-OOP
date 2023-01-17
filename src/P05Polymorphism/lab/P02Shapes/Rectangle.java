package P05Polymorphism.lab.P02Shapes;

public class Rectangle extends Shape{

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {

      double result = this.height + getHeight() + this.width + this.width;
      super.setPerimeter(result);

    }

    @Override
    public void calculateArea() {
        double result = this.height * this.width;
        super.setArea(result);
    }
}
