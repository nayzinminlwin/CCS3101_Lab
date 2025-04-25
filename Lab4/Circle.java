package Lab4;

public class Circle {
    private int radius;
    private boolean filled;

    // Null Constructor
    Circle()
    {
        this.radius = 1;
        this.filled = false;
    }

    // Single parameter Constructor
    Circle(int d)
    {
        this.radius = d;
        this.filled = false;
    }

    // Full parameter Constructor
    Circle(int d,boolean f)
    {
        this.radius = d;
        this.filled = f;
    }

    // Area calculation function
    public double calcuateArea()
    {
        return Math.PI*(Math.pow(radius, 2));
    }

    @Override
    public String toString()
    {
        String filledOrNot = this.filled ? "filled" : "unfilled";
        String rString = String.format("This is %s Circle Object with area: %.2fcm^2.", filledOrNot,this.calcuateArea());
        return rString;
    }
}
