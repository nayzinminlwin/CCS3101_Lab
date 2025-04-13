package Lab3.Shapes;

public class Line {
    private final Point pointA;
    private final Point pointB;
    private int length;

    Line(Point a, Point b, int length)
    {
        this.pointA = a;
        this.pointB = b;
        this.length = length;
    }

    public String getLine()
    {
        return String.format("%c---%c \n",this.pointA.getPointName(), this.pointB.getPointName());
    }

    public Point getPointA()
    {
        return this.pointA;
    }
    public Point getPointB()
    {
        return this.pointB;
    }
    public int getLength()
    {
        return this.length;
    }

    public void Connect(Point a, Point A)
    {
        a = A;
    }

    public static Line CopyLine(Line originalLine)
    {
        return new Line(originalLine.getPointA(),originalLine.getPointB(),originalLine.getLength());
    }
}
