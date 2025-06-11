package Lab7.Lectures.Lab_7;

import Lab7.Lectures.GeometricObjects.*;;

public class Square extends GeometricObject implements Colorable {
    private double side;

    Square() {
        this.side = 0;
    }

    Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(this.side, 2);
    }

    @Override
    public double getPerimeter() {
        return this.side * 4;
    }

    @Override
    public String toString() {
        return super.toString() + " Side : " + getSide();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

}
