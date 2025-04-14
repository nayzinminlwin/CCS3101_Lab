package Lab3.Shapes;

public class Square extends Quadrilateral{

    private final int degreeAB;
    private final int degreeBC;

    Square(Line lineA, Line lineB, Line lineC, Line lineD)
    {
        super(lineA, lineB, lineC, lineD);
        super.parallelAC = true;
        super.parallelBD = true;

        this.degreeAB = 90;
        this.degreeBC = 90;
    }
}
