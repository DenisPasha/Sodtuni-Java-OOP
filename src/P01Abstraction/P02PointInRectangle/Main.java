package P01Abstraction.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //initialising coordinates of a rectangle
        int[] coordinatesOfRectangleArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bottomLeftX = coordinatesOfRectangleArr[0];
        int bottomLeftY = coordinatesOfRectangleArr[1];
        int topRightX = coordinatesOfRectangleArr[2];
        int topRightY = coordinatesOfRectangleArr[3];

        Point pointLeft = new Point(bottomLeftX,bottomLeftY);
        Point pointRight = new Point(topRightX,topRightY);

        Rectangle rectangle = new Rectangle(pointLeft,pointRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {
            int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = coordinates[0];
            int y = coordinates[1];

            Point point = new Point(x,y);
            System.out.println(rectangle.contains(point));
        }

    }
}
