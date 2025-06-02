package Test2_Prac.Day1.Polymorphism_Practicing;

abstract class Shape {
    abstract double area();

    void printArea() {
        System.out.println("Area = " + area());
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        this.radius = r;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

public class TestPolymorph2 {
    public static void main(String[] args) {
        Shape s = new Circle(2.0);
        s.printArea();
        // What if we do this?
        Shape s2 = new Shape() {
            double area() {
                return 10;
            }
        };
        s2.printArea();
    }
}
