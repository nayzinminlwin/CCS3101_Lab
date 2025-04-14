package Lab3.Shapes;

public class Parallelogram extends Quadrilateral{

    Parallelogram(Line lineA, Line lineB, Line lineC, Line lineD)
    {
        super(lineA, lineB, lineC, lineD);

        super.parallelAC = true;
        super.parallelBD = true;
    }

    @Override
    public String toString()
    {
        return "Parallelogram : ";
    }
}
