package Lab3.Shapes;

public class Point {
    // x and y coordinate for the point
    private final int x;
    private final int y;

    // Constructor
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // getter for x and y
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
}
