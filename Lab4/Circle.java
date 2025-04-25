package Lab4;

public class Circle {
    private int radius;
    private boolean filled;

    Circle()
    {
        this.radius = 1;
        this.filled = false;
    }

    Circle(int d)
    {
        this.radius = d;
        this.filled = false;
    }

    Circle(int d,boolean f)
    {
        this.radius = d;
        this.filled = f;
    }

    public double calcuateArea()
    {
        return Math.PI*(Math.pow(radius, 2));
    }

    public String toString()
    {
        String filledOrNot = this.filled ? "filled" : "unfilled";
        String rString = String.format("This is %s Circle Object with area: %.2fcm^2.", filledOrNot,this.calcuateArea());
        return rString;
    }
}
