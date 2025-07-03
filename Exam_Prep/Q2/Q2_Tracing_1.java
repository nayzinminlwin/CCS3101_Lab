package Q2;

import java.io.*;
import java.util.*;

public class Q2_Tracing_1 {
    // Text file read/write with Scanner and PrintWriter
    static void textDemo(String filename) {
        System.out.println("TextDemo start: " + filename);
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
            System.out.println("FirstLine: " + sc.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Text read error: " + filename);
        } finally {
            System.out.println("TextDemo read finally: " + filename);
            if (sc != null)
                sc.close();
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(filename));
            pw.println("HelloWorld");
            System.out.println("Text write: HelloWorld");
        } catch (IOException e) {
            System.out.println("Text write error: " + e.getMessage());
        } finally {
            System.out.println("TextDemo write finally: " + filename);
            if (pw != null)
                pw.close();
        }
    }

    // Binary file write/read with Data streams
    static void binaryDemo(String filename) {
        System.out.println("BinaryDemo start: " + filename);
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            out = new DataOutputStream(new FileOutputStream(filename));
            out.writeInt(1);
            System.out.println("Wrote int: 1");
            in = new DataInputStream(new FileInputStream(filename));
            System.out.println("Read int: " + in.readInt());
            System.out.println("Read extra: " + in.readInt());
        } catch (EOFException e) {
            System.out.println("EOF in binary read: " + filename);
        } catch (IOException e) {
            System.out.println("Binary IO error: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("BinaryDemo finally: " + filename);
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Program start");

        // First textDemo on missing file
        textDemo("file1.txt");
        // Second textDemo on now-existing file
        textDemo("file1.txt");

        // First binaryDemo on nonexistent/new file
        binaryDemo("file1.bin");
        // Second binaryDemo on now-existing file
        binaryDemo("file1.bin");

        System.out.println("Program end");
    }
}
