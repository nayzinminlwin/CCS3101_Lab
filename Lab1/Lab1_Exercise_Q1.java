package Lab1;

public class Lab1_Exercise_Q1
{
    public static void main(String[] args)
    {
        // creating an empty rectangle, invoking null constructor
        Rectangle r1 = new Rectangle();
        System.out.printf("The area of rectangle is %.2f.\n",r1.getArea());

        // creating a normal rectangle, invoking the regular constructor
        r1 = new Rectangle(4,40);
        System.out.printf("The area of rectangle with width %.2f x height %.2f is %.2f.\n",r1.getWidth(),r1.getHeight(),r1.getArea());
        System.out.printf("The perimeter of the rectangle is %.2f.\n",r1.getPerimeter());

        // same with second rectangle, but with decimal numbers
        // r1.height = 5;
        r1.setWidth(3.5);
        r1.setHeight(35.9);
        System.out.printf("The area of new rectangle with width %.2f x height %.2f is %.2f.\n",r1.getWidth(),r1.getHeight(),r1.getArea());
        System.out.printf("The perimeter of the rectangle is %.2f.\n",r1.getPerimeter());
    }
}
class Rectangle{
    private double width;
    private double height;

    // Null constructor
    Rectangle(){
        width = 1;
        height = 1;
    }

    // Full attribute constructor
    Rectangle(double width, double height)
    {
        this.height = height;
        this.width = width;
    }

    // Getter & Setter for Height
    public double getHeight() {
        return height;
    }
    public void setHeight(double height)
    {
        if (height >= 0) {
            this.height = height;
        }
    }

    // Getter & Setter for Width
    public double getWidth() {
        return width;
    }
    public void setWidth(double width)
    {
        if (width >= 0) {
            this.width = width;
        }
    }

    // Area calculation function
    public double getArea()
    {
        return this.height*this.width;
    }

    // Perimeter calculation function
    public double getPerimeter()
    {
        return 2.0*(this.height + this.width);
    }
}