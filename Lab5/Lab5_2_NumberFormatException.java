import java.util.Scanner;

public class Lab5_2_NumberFormatException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a hexadecimal number : ");
            String hexaString = sc.nextLine();
            System.out.println("Your decimal number by parseInt is : " + hex2Dec(hexaString));
            System.out.println("\nYour decimal number by myAlgo is : " + hex2Dec_Algorithm(hexaString));
        } catch (NumberFormatException nbfEx) {
            System.out.println("User must enter a Hexadecimal String!");
        }
        sc.close();
    }

    // java built-in function ParseInt
    public static int hex2Dec(String hexaString) throws NumberFormatException {
        int decimalNum;

        try {
            // the parseInt function with respective parameter will do the job
            // ultimately!!!!
            decimalNum = Integer.parseInt(hexaString, 16);
        } catch (NumberFormatException nbfEx) {
            throw nbfEx;
        }

        return decimalNum;
    }

    // My Algorithm
    public static String hex2Dec_Algorithm(String hexString) throws NumberFormatException {
        int decimalNum = 0;

        // Checking the string is signed or not.
        boolean hasSign = hexString.charAt(0) == '+' || hexString.charAt(0) == '-';
        String hexString0 = hasSign ? hexString.substring(1).toUpperCase() : hexString.toUpperCase();

        // Processing
        for (int i = 0; i < hexString0.length(); i++) {
            char c = hexString0.charAt(i);

            if ((c < 'A' || c > 'F') && (c < '0' || c > '9'))
                throw new NumberFormatException(hexString);

            // Formula : a2 x 16^2 + a1 x 16^1 + a0 x 16^0
            else {
                if (c >= '0' && c <= '9') // 0 to 9
                {
                    System.out.printf(" + (%d x 16^%d)", (c - '0'), (hexString0.length() - 1 - i));
                    decimalNum = decimalNum + ((c - '0') * (int) Math.pow(16, (hexString0.length() - 1 - i)));
                } else // a to f
                {
                    // System.out.println(c-'0'-7);
                    // System.out.println(10+(c-'A'));
                    System.out.printf(" + (%d x 16^%d)", (10 + (c - 'A')), (hexString0.length() - 1 - i));
                    decimalNum = decimalNum + ((10 + (c - 'A')) * (int) Math.pow(16, (hexString0.length() - 1 - i)));
                }
            }
        }

        // if signed, return with sign
        if (hasSign)
            return hexString.charAt(0) + "" + decimalNum;
        return "" + decimalNum;
    }
}