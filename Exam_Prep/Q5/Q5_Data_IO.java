package Q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q5_Data_IO {
    public static void main(String[] args) {

        System.out.println("\nCreating Text file to do Binary read and Write!!");
        StudentRecord.createTxtFile();

        System.out.println("\nWriting Binary File!!");
        StudentRecord.Binary_fileWrite();

        System.out.println("\nReading Binary File!!");
        StudentRecord.Binary_fileRead();
    }
}

class StudentRecord {
    static String filePath = "Exam_Prep/Q5/";
    static File f0 = new File(filePath, "studentRecords.txt");

    public static void createTxtFile() {

        try (PrintWriter pw = new PrintWriter(f0)) {
            for (int i = 0; i < 20; i++) {
                String name = "Student" + (i + 1);
                int score = (int) Math.round(Math.random() * 100);
                String printLine = name + "," + score;
                pw.write(printLine + "\n");
                System.out.println("Printed : " + printLine);
            }
        } catch (FileNotFoundException fnf_ex) {
            System.out.println("404: File Not Found!");
        }

    }

    public static void Binary_fileWrite() {
        File outputFile = new File(filePath, "studentRecords.dat");

        try (
                Scanner sc = new Scanner(f0);
                DataOutputStream data_out = new DataOutputStream(new FileOutputStream(outputFile));) {
            data_out.writeUTF("Outstanding Students\n");
            while (sc.hasNext()) {
                String[] currentStudent = sc.nextLine().split(",");
                System.out.println("Name : " + currentStudent[0]);
                System.out.println("Score : " + currentStudent[1]);
                if (Integer.parseInt(currentStudent[1]) >= 50) {
                    System.out.println(String.join(",", currentStudent));
                    data_out.writeUTF(String.join(",", currentStudent));
                    // data_out.writeUTF("");
                }
            }
        } catch (FileNotFoundException fnf_ex) {
            System.out.println("404: File not found!");
        } catch (IOException io_ex) {
            System.out.println("IO Exception!");
        }
    }

    public static void Binary_fileRead() {
        File inputBinary = new File(filePath, "studentRecords.dat");
        try (
                DataInputStream d_in = new DataInputStream(new FileInputStream(inputBinary))) {
            System.out.println();
            System.out.print(d_in.readUTF());
            while (d_in.available() != 0) {
                String thisLine = d_in.readUTF();
                String[] currentStudent = thisLine.split(",");
                System.out.println("I am outstanding Student," + currentStudent[0]);
                System.out.printf("I got %s mark.\n", currentStudent[1]);
            }
        } catch (FileNotFoundException fnf_ex) {
            System.out.println("404: File Not found!!");
        } catch (IOException io_ex) {
            System.out.println("IO Exception!");
        }
    }
}