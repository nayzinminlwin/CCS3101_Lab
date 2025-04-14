package Lab3.Shapes;

public class ShapeFactory {
    public static Quadrilateral createShape(Line lineA,Line lineB, Line lineC, Line lineD)
    {
        if(Line.isPerpendicular(lineA, lineB) && Line.isPerpendicular(lineB, lineC) && Line.isPerpendicular(lineC, lineD))
        {
            if(lineA.getLength()== lineB.getLength())
                return new Square(lineA, lineB, lineC, lineD);
            else
                return new Rectangle(lineA, lineB, lineC, lineD);
        }
        else
        {
            if(lineA.getSlope()==lineC.getSlope() && lineB.getSlope()==lineD.getSlope())
                return new Parallelogram(lineA, lineB, lineC, lineD);

            else if(lineA.getSlope()==lineC.getSlope() || lineB.getSlope()==lineD.getSlope())
                return new Trapezoid(lineA, lineB, lineC, lineD);

            else
                return new Quadrilateral(lineA, lineB, lineC, lineD);
        }
    }
}
