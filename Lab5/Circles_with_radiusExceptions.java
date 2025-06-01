public class Circles_with_radiusExceptions {
    public static void main(String[] args) {
        try {
            CircleWithRadiusException c0 = new CircleWithRadiusException();
            System.out.println("Circle Radius : " + c0.getRadius());

            CircleWithRadiusException c1 = new CircleWithRadiusException(5.5);
            System.out.println("Circle Radius : " + c1.getRadius());

            c1.setRadius(-5.5);

            // the followin 2lines of code will now be executed anyway!
            CircleWithRadiusException c2 = new CircleWithRadiusException(-5);
            System.out.println("Circle Radius : " + c2.getRadius());

        } catch (InvalidRadiusException inR_Ex) {
            System.out.println(inR_Ex);
        }

        System.out.printf("Circle count is %d.", CircleWithRadiusException.getCircleCount());
    }
}

class CircleWithRadiusException {
    private double radius;
    private static int circleCount;

    public CircleWithRadiusException(double radius) {
        try {
            this.setRadius(radius);
            circleCount++;
        } catch (InvalidRadiusException inR) {
            System.out.println("Got exception!!");
            inR.printStackTrace();
        }
    }

    public CircleWithRadiusException() {
        this(1.0);
    }

    public void setRadius(double radius) throws InvalidRadiusException {
        if (radius < 0)
            throw new InvalidRadiusException(radius);
        else
            this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public static int getCircleCount() {
        return CircleWithRadiusException.circleCount;
    }
}

class InvalidRadiusException extends Exception {
    private double radius;

    public InvalidRadiusException(double radius) {
        super("Radius cannot be minus value : " + radius);
        this.radius = radius;
    }
}