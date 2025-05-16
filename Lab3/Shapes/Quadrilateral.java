package Lab3.Shapes;

public class Quadrilateral {
    private Line lineA;
    private Line lineB;
    private Line lineC;
    private Line lineD;

    Quadrilateral(Line lineA, Line lineB, Line lineC, Line lineD) {
        this.lineA = lineA;
        this.lineB = lineB;
        this.lineC = lineC;
        this.lineD = lineD;

        Line.LineConnect(lineA, lineB);
        Line.LineConnect(lineB, lineC);
        Line.LineConnect(lineC, lineD);
        Line.LineConnect(lineD, lineA);
    }

    public double CalculateArea() {
        int[] lineAPoints = this.lineA.getLinePoints(); // x1 y1 x2 y2
        int[] lineBPoints = this.lineB.getLinePoints(); // x2 y2 x3 y3
        int[] lineCPoints = this.lineC.getLinePoints(); // x3 y3 x4 y4
        int S1 = (lineAPoints[0] * lineAPoints[3]) + (lineAPoints[2] * lineBPoints[3])
                + (lineCPoints[0] * lineCPoints[3]) + (lineCPoints[2] * lineAPoints[1]);
        int S2 = (lineAPoints[1] * lineAPoints[2]) + (lineAPoints[3] * lineBPoints[2])
                + (lineCPoints[1] * lineCPoints[2]) + (lineCPoints[3] * lineAPoints[0]);
        double area = (Math.abs(S1 - S2)) / 2;
        return area;
    }

    @Override
    public String toString() {
        return "Quadrilateral : ";
    }
}