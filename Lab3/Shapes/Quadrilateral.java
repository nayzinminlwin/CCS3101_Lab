package Lab3.Shapes;

public class Quadrilateral {
    private final Line lineA;
    private final Line lineB;
    private final Line lineC;
    private final Line lineD;

    private int height;
 
    protected boolean parallelAC;
    protected boolean parallelBD;

    // final int degreeAB;
    // final int degreeBC;
    // final int degreeCD;
    // final int degreeAD;

    Quadrilateral(Line lineA, Line lineB, Line lineC, Line lineD,int height)
    {
        this.lineA = lineA;
        this.lineB = lineB;
        this.lineC = lineC;
        this.lineD = lineD;
        this.height = height;

        this.lineA.Connect(this.lineA.getPointB(),this.lineB.getPointA());
        this.lineB.Connect(this.lineB.getPointB(), this.lineC.getPointA());
        this.lineC.Connect(this.lineC.getPointB(), this.lineD.getPointA());
        this.lineD.Connect(this.lineD.getPointB(), this.lineA.getPointA());

        this.parallelAC = false;
        this.parallelBD = false;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int CalculateArea()
    {
        int result =0;
        return result;
    }
}
