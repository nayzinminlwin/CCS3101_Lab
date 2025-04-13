package Lab3.Shapes;

public class Square extends Quadrilateral{

    private final int degreeAB;
    private final int degreeBC;

    Square(Line lineA)
    {
        super(lineA, Line.CopyLine(lineA), Line.CopyLine(lineA), Line.CopyLine(lineA),lineA.getLength());

        super.parallelAC = true;
        super.parallelBD = true;

        this.degreeAB = 90;
        this.degreeBC = 90;
    }
}
