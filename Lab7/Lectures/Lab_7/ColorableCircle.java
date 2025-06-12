package Lab7.Lectures.Lab_7;

import Lab7.Lectures.GeometricObjects.*;

public class ColorableCircle extends Circle implements Colorable {

    ColorableCircle() {
        super(0);
    }

    ColorableCircle(double radius) {
        super(radius);
    }

    @Override
    public String howToColor() {
        return "Color the whole circumference.";
    }
}