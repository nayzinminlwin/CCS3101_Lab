package Lab3.Shapes;

public class Parallelogram extends Quadrilateral{

    Parallelogram(Line lineA, Line lineB, int height)
    {
        super(lineA, lineB, Line.CopyLine(lineA), Line.CopyLine(lineB),height);

        super.parallelAC = true;
        super.parallelBD = true;
    }
}
