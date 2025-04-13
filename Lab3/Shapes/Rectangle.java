package Lab3.Shapes;

public class Rectangle extends Quadrilateral{

    private final int degreeAB;
    private final int degreeBC;

    Rectangle(Line lineA, Line lineB)
    {
        super(lineA, lineB, Line.CopyLine(lineA), Line.CopyLine(lineB),lineA.getLength());

        super.parallelAC = true;
        super.parallelBD = true;

        this.degreeAB = 90;
        this.degreeBC = 90;
    }
}
