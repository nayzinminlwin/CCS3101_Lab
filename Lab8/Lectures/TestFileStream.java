package Lab8.Lectures;

import java.io.*;

public class TestFileStream {
    public static void main(String[] args) throws IOException {
        try (
                // Create an output stream to the file
                FileOutputStream output = new FileOutputStream("temp.dat");
                DataOutputStream dop = new DataOutputStream(output)) {
            // Output values to the file
            for (int i = 1; i <= 10; i++) {
                // output.write(i);
                dop.write(i);
                dop.writeChars("a");
            }

        }

        try (
                // Create an input stream for the file
                FileInputStream input = new FileInputStream("temp.dat");
                DataInputStream dip = new DataInputStream(input)) {
            // Read values from the file
            int value;
            while (dip.available() != 0) {
                value = dip.read();
                System.out.print(value + " ");
            }
        } catch (EOFException eof) {
            System.out.println(eof.getMessage());
        }
    }
}