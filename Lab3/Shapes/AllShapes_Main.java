package Lab3.Shapes;

public class AllShapes_Main {
    public static void main(String[] args) {

        // // Square
        CalculateArea(new int[][]{{1,5},{1,1},{5,1},{5,5}});
        // Point pointA = new Point(1,5);
        // Point pointB = new Point(1,1);
        // Point pointC = new Point(5,1);
        // Point pointD = new Point(5,5);

        // Rectangle
        CalculateArea(new int[][]{{2,0},{0,4},{2,5},{4,1}});
        // Point pointA = new Point(2,0);
        // Point pointB = new Point(0,4);
        // Point pointC = new Point(2,5);
        // Point pointD = new Point(4,1);

        // // parallelogram
        CalculateArea(new int[][]{{2,2},{5,5},{9,5},{6,2}});
        // Point pointA = new Point(2,2);
        // Point pointB = new Point(5,5);
        // Point pointC = new Point(9,5);
        // Point pointD = new Point(6,2);

        // // Trapezoid
        CalculateArea(new int[][]{{2,2},{5,6},{11,6},{14,2}});
        // Point pointA = new Point(2,2);
        // Point pointB = new Point(5,6);
        // Point pointC = new Point(11,6);
        // Point pointD = new Point(14,2);

        // // Line objects intialization
        // Line lineA = new Line(pointA, pointB);
        // Line lineB = new Line(pointB, pointC);
        // Line lineC = new Line(pointC, pointD);
        // Line lineD = new Line(pointD, pointA);

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
        // Polymorphism of Child class into Parent Quadrilateral
        // Quadrilateral q0 = ShapeFactory.createShape(lineA, lineB, lineC, lineD);
        // System.out.print(q0.toString());
        // System.out.print("area "+q0.CalculateArea());
    }

    public static void CalculateArea(int[][] xy)
    {
        // point assignment according to x and y coordinates
        Point pointA = new Point(xy[0][0],xy[0][1]);
        Point pointB = new Point(xy[1][0],xy[1][1]);
        Point pointC = new Point(xy[2][0],xy[2][1]);
        Point pointD = new Point(xy[3][0],xy[3][1]);

        // Line initialization
        Line lineA = new Line(pointA, pointB);
        Line lineB = new Line(pointB, pointC);
        Line lineC = new Line(pointC, pointD);
        Line lineD = new Line(pointD, pointA);

        // Shape initialization and Output
        Quadrilateral q0 = ShapeFactory.createShape(lineA, lineB, lineC, lineD);
        System.out.print(q0.toString());
        System.out.printf("area %.0f \n",q0.CalculateArea());
    }
}
