package Q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q5_Prac_Warehouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many items u want to add : ");
        int ProductQty = sc.nextInt();

        try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream("inventory.dat"));
                DataInputStream dIn = new DataInputStream(new FileInputStream("inventory.dat"));) {
            String SKU;
            String productName;
            double price;
            int quantity;

            for (int i = 1; i <= ProductQty; i++) {
                SKU = "P" + i;
                productName = "Product" + i;
                price = Math.random() * 200;
                quantity = (int) (Math.round(Math.random() * 50));

                String currentProduct = String.format("%s %s %.2f %d", SKU, productName, price, quantity);
                dOut.writeUTF(currentProduct);
                System.out.println("Printed : " + currentProduct);
            }
            dOut.close();
            sc.close();

            String report1 = "Products Cost more than 100RM\n";
            String report2 = "Products Qty < 10 \n";

            while (dIn.available() != 0) {
                String[] currentProduct = dIn.readUTF().split(" ");
                String currentLine = String.join(" ", currentProduct);
                if (Double.parseDouble(currentProduct[2]) > 100.00) {
                    // System.out.println("Price : " + Double.parseDouble(currentProduct[2]));
                    report1 = report1.concat(currentLine + "\n");
                }
                if (Integer.parseInt(currentProduct[3]) < 10) {
                    report2 = report2.concat(currentLine + "\n");
                }
            }
            dIn.close();

            System.out.println(report1);
            System.out.println(report2);

        } catch (IOException ioEx) {
            System.out.println("IO Exception!");
        }
    }
}