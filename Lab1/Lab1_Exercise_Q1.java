package Lab1;

public class Lab1_Exercise_Q1
{
    public static void main(String[] args)
    {
        Rectangle r1 = new Rectangle();
        System.out.printf("The area of rectangle is %.2f.\n",r1.getArea());

        r1 = new Rectangle(4,40);
        System.out.printf("The area of rectangle with width %.2f x height %.2f is %.2f.\n",r1.getWidth(),r1.getHeight(),r1.getArea());
        System.out.printf("The perimeter of the rectangle is %.2f.\n",r1.getPerimeter());

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

    Rectangle(){
        width = 1;
        height = 1;
    }

    Rectangle(double width, double height)
    {
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height)
    {
        if (height >= 0) {
            this.height = height;
        }
    }
    public double getHeight() {
        return height;
    }

    public void setWidth(double width)
    {
        if (width >= 0) {
            this.width = width;
        }
    }
    public double getWidth() {
        return width;
    }

    public double getArea()
    {
        return this.height*this.width;
    }
    public double getPerimeter()
    {
        return 2.0*(this.height + this.width);
    }
}