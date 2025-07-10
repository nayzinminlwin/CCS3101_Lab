package Q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// A banking application requires a Java program that reads an integer N from the console followed
// by N transaction records (each record consists of an account-number string, a UTF-8 transaction-type string
// (“DEPOSIT” or “WITHDRAWAL”), and a double amount), writes all transactions in sequence to
// transactions.dat using DataOutputStream, then reads them back with DataInputStream, computes the
// resulting balance for each account (starting from zero), and finally prints two lists: one showing all accounts
// with a negative balance and one showing all accounts whose balance exceeds 10,000.00.

public class Q5_Prac_BankTransaction {
    public static void main(String[] args) {
        // Writing binary into .dat file
        WriteBinaryFile();

        // Reading the .dat file
        HashMap<String, Double> processedData = ReadBinaryFile();

        // Reporting
        Report(processedData);
    }

    public static void WriteBinaryFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many transcations ? : ");
        int transCount = sc.nextInt();

        try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream("Transactsions.dat"))) {
            String accNo;
            String transType;
            double amount;

            for (int i = 0; i < transCount; i++) {
                int accountNumber = ((int) (Math.random() * 9));
                accNo = String.format("A%06d", accountNumber);
                // System.out.println("Account Number : " + accNo);

                transType = (int) (Math.random() * 2) == 0 ? "WITHDRAWAL" : "DEPOSIT";
                amount = Math.random() * 100000;

                dOut.writeUTF(accNo);
                dOut.writeUTF(transType);
                dOut.writeDouble(amount);

                System.out.printf("Completed Transaction : %s, %s, %.2fRM\n", accNo, transType, amount);
            }
            dOut.close();

        } catch (IOException ioEx) {
            // System.out.println();
            ioEx.printStackTrace();
        }
    }

    public static HashMap<String, Double> ReadBinaryFile() {

        HashMap<String, Double> accounts = new HashMap<>();

        try (DataInputStream dIn = new DataInputStream(new FileInputStream("Transactsions.dat"))) {
            while (dIn.available() != 0) {
                String accNo = dIn.readUTF();
                String tType = dIn.readUTF();
                double amount = dIn.readDouble();

                if (tType.equals("WITHDRAWAL")) {
                    // amount = amount - (amount * 2);
                    amount = -amount; // wowwww
                }
                if (accounts.containsKey(accNo)) {
                    double newBaki = amount + accounts.get(accNo);
                    accounts.put(accNo, newBaki);
                } else {
                    accounts.put(accNo, amount);
                }

            }
            dIn.close();

        } catch (IOException ioEx) {
            ioEx.getStackTrace();
        }

        return accounts;
    }

    public static void Report(HashMap<String, Double> accounts) {

        System.out.println("\nAccounts with negative balance!");
        accounts.forEach((key, value) -> {
            if (value < 0)
                System.out.printf("%s : %.2fRM\n", key, value);
        });

        System.out.println("\nAccounts with riches!!");
        accounts.forEach((key, value) -> {
            if (value > 10000)
                System.out.printf("%s : %.2fRM\n", key, value);
        });
    }
}