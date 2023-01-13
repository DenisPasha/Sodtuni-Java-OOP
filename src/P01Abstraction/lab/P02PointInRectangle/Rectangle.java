package P01Abstraction.lab.P02PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point bottomRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = bottomRight;
    }


    public boolean contains(Point point){
        if (point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()){
            if (point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY()){
                return true;
            }
        }return false;
    }
}
