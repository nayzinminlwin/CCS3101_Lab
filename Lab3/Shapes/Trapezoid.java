package Lab3.Shapes;

public class Trapezoid extends Quadrilateral{

    Trapezoid(Line lineA, Line lineB, Line lineC, Line lineD)
    {
        super(lineA, lineB, lineC, lineD);

        super.parallelAC = false;
        super.parallelBD = true;
    }

    @Override
    public String toString()
    {
        return "Trapezoid : ";
    }
}
