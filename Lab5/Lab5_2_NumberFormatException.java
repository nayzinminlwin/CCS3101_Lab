import java.util.Scanner;

public class Lab5_2_NumberFormatException
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter a hexadecimal number : ");
            String hexaString = sc.nextLine();
            System.out.println("Your decimal number is : "+hex2Dec(hexaString));
        }
        catch(NumberFormatException nbfEx){
            System.out.println("User must enter a Hexadecimal String!");
        }
        sc.close();
    }

    public static int hex2Dec(String hexaString) throws NumberFormatException
    {
        int decimalNum;

        try{
            decimalNum = Integer.parseInt(hexaString,16);
        }
        catch(NumberFormatException nbfEx){
            throw nbfEx;
        }

        return decimalNum;
    }
}