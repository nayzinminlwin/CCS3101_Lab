package Lab3.Shapes;

public class Line {
    private Point pointA;
    private Point pointB;

    // Constructor method
    Line(Point a, Point b)
    {
        this.pointA = a;
        this.pointB = b;
    }

    // getter for the Line
    public String getLine()
    {
        return String.format("(%c,%c)---(%c,%c) \n",this.pointA.getX(),this.pointA.getY(), this.pointB.getX(),this.pointB.getY());
    }

    // getter & setter for point A
    public Point getPointA()
    {
        return this.pointA;
    }
    public void setPointA(Point A)
    {
        this.pointA = A;
    }

    // getter & setter for point B
    public Point getPointB()
    {
        return this.pointB;
    }
    public void setPointB(Point B)
    {
        this.pointB = B;
    }

    // Line Connecting function for 2 lines.
    public static void LineConnect(Line A, Line B)
    {
        A.setPointB(B.getPointA());
    }

    public int getLength(Line A)
    {
        int length=0;

        return length;
    }

    public int[] getLinePoints()
    {
        int[] linePoints = new int[4];
        linePoints[0] = this.getPointA().getX();
        linePoints[1] = this.getPointA().getY();
        linePoints[2] = this.getPointB().getX();
        linePoints[3] = this.getPointB().getY();
        return linePoints;
    }
}
