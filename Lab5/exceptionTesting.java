import java.util.InputMismatchException;
import java.util.Scanner;

public class exceptionTesting {
    public static void main(String[] args)
    {
        // InputMismatchmatchDemo();
        mainDivision();
    }

    public static void InputMismatchmatchDemo()
    {
        Scanner sc = new Scanner(System.in);
        boolean continueLoop = false;
        do
        {
            try
            {
                System.out.print("Enter an Integer : ");
                // int anInteger = Integer.parseInt(sc.nextLine());
                int anInteger = sc.nextInt();

                System.out.println("The number entered is "+anInteger);
                continueLoop = false;
            }
            catch(InputMismatchException | NumberFormatException ex){
                System.out.println(ex+ "You must insert an integer.");
                continueLoop = true;
                sc.nextLine();
            }
        }
        while(continueLoop);
        sc.close();
    }

    public static double Division(int num1, int num2)
    {
        if(num2==0)
            throw new ArithmeticException("Cant divide by Zero.");

        return num1/num2;
    }

    public static void mainDivision()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Divident and Divisor :  ");
        int dvd = sc.nextInt();

        // System.out.print("Enter Divisor : ");
        int dvs = sc.nextInt();

        try
        {
            double result = Division(dvd, dvs);
            System.out.println("The result is "+ result);
        }
        catch(ArithmeticException ex){
            System.out.println("You are trying to divide with Zero.");
        }

        sc.close();
        System.out.println("Continue other task.");
    }
}
