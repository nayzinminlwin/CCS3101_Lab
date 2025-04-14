package Lab3.Shapes;

public class AllShapes_Main {
    public static void main(String[] args) {

        // // Square
        // Point pointA = new Point(1,5);
        // Point pointB = new Point(1,1);
        // Point pointC = new Point(5,1);
        // Point pointD = new Point(5,5);

        // Rectangle
        Point pointA = new Point(2,0);
        Point pointB = new Point(0,4);
        Point pointC = new Point(2,5);
        Point pointD = new Point(4,1);

        // // parallelogram
        // Point pointA = new Point(2,2);
        // Point pointB = new Point(5,5);
        // Point pointC = new Point(9,5);
        // Point pointD = new Point(6,2);

        // // Trapezoid
        // Point pointA = new Point(2,2);
        // Point pointB = new Point(5,6);
        // Point pointC = new Point(11,6);
        // Point pointD = new Point(14,2);

        // Line objects intialization
        Line lineA = new Line(pointA, pointB);
        Line lineB = new Line(pointB, pointC);
        Line lineC = new Line(pointC, pointD);
        Line lineD = new Line(pointD, pointA);

        // Square s1 = new Square(lineA, lineB, lineC, lineD);
        // System.out.println(s1.CalculateArea());

        // Rectangle r1 = new Rectangle(lineA, lineB, lineC, lineD);
        // System.out.println(r1.CalculateArea());

        // Parallelogram p1 = new Parallelogram(lineA, lineB, lineC, lineD);
        // System.out.println(p1.CalculateArea());

        // Trapezoid t1 = new Trapezoid(lineA, lineB, lineC, lineD);
        // System.out.println(s1.CalculateArea());
        
        // System.out.println(s1);

        // Quadrilateral mainQuadrilateral = new Quadrilateral(lineA, lineB, lineC, lineD);
        Quadrilateral q0 = ShapeFactory.createShape(lineA, lineB, lineC, lineD);
        System.out.print(q0.toString());
        System.out.print("area "+q0.CalculateArea());
    }
}
