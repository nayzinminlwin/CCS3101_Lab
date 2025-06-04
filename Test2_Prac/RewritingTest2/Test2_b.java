package Test2_Prac.RewritingTest2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Test2_b {
    public static void main(String[] args) {
        String parentPath = "Test2_Prac/RewritingTest2";
        File f1 = new File(parentPath, "input.txt");
        // 2918 200 3 2 1 8 9 2 0
        // 2928 130 5 8 5 6 5 9 6
        File f2 = new File(parentPath, "output.txt");
        try (Scanner sc = new Scanner(f1); PrintWriter pw = new PrintWriter(f2);) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(" ");
                int[] eData = new int[data.length];
                for (int i = 0; i < data.length; i++)
                    eData[i] = Integer.parseInt(data[i]);
                int eID = eData[0];
                int eWage = eData[1];
                int[] eOT = Arrays.copyOfRange(eData, 2, 9);
                Employee ee = new Employee(eID, eWage, eOT);
                String outputLine = ee.getID() + " " + ee.getTotalSalary();
                pw.println(outputLine);
            }
        } catch (FileNotFoundException fnfEx) {
            System.out.println("404: File nout found!");
        } catch (NumberFormatException nfEx) {
            System.out.println("Wrong number format in input file.");
        } catch (Exception ex) {
            System.out.println("Unknown exception!!");
        }
    }
}

class Employee {
    private int employeeID;
    private int employeeWage;
    private int[] overtimeHour;
    private double totalSalary;

    Employee(int eID, int eWage, int[] OT) {
        this.employeeID = eID;
        this.employeeWage = eWage;
        this.overtimeHour = OT;
        this.totalSalary = calcSalary();
    }

    public double calcSalary() {
        int totalOT = 0;
        double totalSalary;
        int eWage = this.employeeWage;
        int[] OT = this.overtimeHour;
        for (int i = 0; i < OT.length; i++) {
            totalOT += OT[i];
        }
        totalSalary = eWage + (totalOT * 15);
        return totalSalary;
    }

    public int getID() {
        return this.employeeID;
    }

    public int getWage() {
        return this.employeeWage;
    }

    public int[] getOT() {
        return this.overtimeHour;
    }

    public double getTotalSalary() {
        return this.totalSalary;
    }

    public void setWage(int newWage) {
        this.employeeWage = newWage;
    }

    public void setOT(int day, int OThr) {
        this.overtimeHour[day - 1] = OThr;
    }
}