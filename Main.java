 

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int pointsNumber = sc.nextInt();

        int sumCircle = estimatePiRecursive(pointsNumber, 0);
        double piNum = 4.0 * ((double) sumCircle / pointsNumber);

        System.out.println("Estimated Pi: " + piNum);
    }

    static int estimatePiRecursive(int points, int inside) {
        if (points == 0) {
            return inside;
        }

        Point randomPoint = pointGenerator(-1, 1, -1, 1);
        
        if (insideCircle(randomPoint, 1)) inside++;

        return estimatePiRecursive(points - 1, inside);
    }

    static Point pointGenerator(int xLeft, int xRight, int yBottom, int yTop) {
        Random random = new Random();
        double x = xLeft + (xRight - xLeft) * random.nextDouble();
        double y = yBottom + (yTop - yBottom) * random.nextDouble();
        return new Point(x, y);
    }

    static boolean insideCircle(Point point, double radius) {
        double x = point.getXValue();
        double y = point.getYValue();
        return (Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(radius, 2);
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getXValue() {
        return x;
    }
    
    public double getYValue() {
        return y;
    }
}
