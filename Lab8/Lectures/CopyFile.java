package Lab8.Lectures;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        // myAlgo();
        try {
            Lecture_Algo(new String[] { "temp.dat", "newTemp.dat" });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void myAlgo() {
        File oldFile = new File("temp.dat");
        File newFile = new File("newTemp.dat");

        if (newFile.exists()) {
            System.out.println("Target file " + newFile.getName() + " already exist!!");
            newFile.delete();
            System.exit(1);
        }

        try (DataInputStream dip = new DataInputStream(new FileInputStream(oldFile));
                DataOutputStream dop = new DataOutputStream(new FileOutputStream(newFile))) {

            byte[] readBytes = dip.readAllBytes();
            System.out.printf("The File %s has %d bytes.\n", oldFile.getName(), readBytes.length);

            dop.write(readBytes);
            dip.close();
            dop.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void Lecture_Algo(String[] args) throws IOException {
        // Check command-line parameter usage
        if (args.length != 2) {
            System.out.println(
                    "Usage: java Copy sourceFile targetfile");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0]
                    + " does not exist");
            System.exit(2);
        }

        // Check if target file exists
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1]
                    + " already exists");
            System.exit(3);
        }

        try (
                // Create an input stream
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));

                // Create an output stream
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));) {
            // Continuously read a byte from input and write it to output
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) {
                output.write((byte) r);
                numberOfBytesCopied++;
            }

            // Display the file size
            System.out.println(numberOfBytesCopied + " bytes copied");
        }
    }
}