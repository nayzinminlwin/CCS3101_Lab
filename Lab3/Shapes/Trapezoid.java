package Lab3.Shapes;

public class Trapezoid extends Quadrilateral{

    Trapezoid(Line lineA, Line lineB, Line lineC, Line lineD, int height)
    {
        super(lineA, lineB, lineC, lineD, height);

        super.parallelAC = false;
        super.parallelBD = true;
    }
}
