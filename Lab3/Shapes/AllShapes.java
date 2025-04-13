package Lab3.Shapes;

public class AllShapes {
    public static void main(String[] args) {
        Point pointA = new Point('a');
        Point pointB = new Point('b');
        Line lineA = new Line(pointA, pointB, 10);
        // Quadrilateral q1 = new Quadrilateral(lineA,lineB, lineC, lineD, 15);
        Square s1 = new Square(lineA);

        System.out.println(s1);
    }
}
