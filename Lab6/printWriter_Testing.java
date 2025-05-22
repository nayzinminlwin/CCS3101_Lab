package Lab6;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class printWriter_Testing {

    public static void main(String[] args) throws Exception {
        String fileName = "Lab6/Addresses.txt";
        File myFile = new File(fileName);
        Scanner sc = new Scanner(System.in);
        if (myFile.exists()) {
            System.out.println("File '" + fileName + "' already exist!!");
            System.out.print("Wanna delete ? (Y/N) : ");
            char del = sc.nextLine().charAt(0);
            if (del == 'Y') {
                myFile.delete();
                System.out.println("Deleted!");
            }
            System.exit(0);

        }
        PrintWriter output = new PrintWriter(myFile);
        output.printf("Name : %s, PhoneNum : %s\n", "Alex", "999");
        output.printf("Name : %s, PhoneNum : %s\n", "NZ", "111");
        output.printf("Name : %s, PhoneNum : %s\n", "NZML", "999");

        output.close();
        sc.close();
    }

}
