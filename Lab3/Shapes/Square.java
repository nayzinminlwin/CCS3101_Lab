package Lab3.Shapes;

public class Square extends Quadrilateral{

    Square(Line lineA, Line lineB, Line lineC, Line lineD)
    {
        super(lineA, lineB, lineC, lineD);
    }

    @Override
    public String toString()
    {
        return "Square : ";
    }
}
