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
        return String.format("(%d,%d)---(%d,%d) \n",this.pointA.getX(),this.pointA.getY(), this.pointB.getX(),this.pointB.getY());
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

    // calculating line length function
    public double getLength()
    {
        return Math.sqrt(Math.pow((this.getPointB().getX() - this.getPointA().getX()),2) + Math.pow((this.getPointB().getY()-this.getPointA().getY()), 2));
    }

    // calculating slope function
    public double getSlope()
    {
        return (this.getPointB().getY()-this.getPointA().getY())/(this.getPointB().getX() - this.getPointA().getX());
    }

    // Checking perpendicular function
    public static boolean isPerpendicular(Line A, Line B)
    {
        double vectorA_x_vectorB = (A.getPointB().getX() - A.getPointA().getX())*(B.getPointB().getX() - A.getPointB().getX())+((A.getPointB().getY()-A.getPointA().getY())*(B.getPointB().getY() - A.getPointB().getY()));
        
        if(vectorA_x_vectorB==0)
            return true;
        else
            return false;
    }

    // function to acqure x1,y1 and x2,y2
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
