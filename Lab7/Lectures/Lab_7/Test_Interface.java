package Lab7.Lectures.Lab_7;

import java.util.ArrayList;

import Lab7.Lectures.GeometricObjects.*;

public class Test_Interface {
    public static void main(String[] args) {
        ArrayList<GeometricObject> myGeoObjs = new ArrayList<>();

        myGeoObjs.add(new Circle());
        myGeoObjs.add(new Circle(9));
        myGeoObjs.add(new ColorableCircle());
        myGeoObjs.add(new ColorableCircle(10));

        myGeoObjs.add(new Rectangle());
        myGeoObjs.add(new Rectangle(10, 5));
        myGeoObjs.add(new NonColorableRectangle());
        myGeoObjs.add(new NonColorableRectangle(5, 3));

        myGeoObjs.add(new Square(7));

        for (GeometricObject myGeoObj : myGeoObjs) {
            System.out.println(myGeoObj.toString());
            if (myGeoObj instanceof Colorable) {
                // myGeoObj.howToColor();
                ((Colorable) myGeoObj).howToColor();
            }
            System.out.println();
        }

    }
}
