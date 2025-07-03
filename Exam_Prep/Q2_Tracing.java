import java.io.*;

public class Q2_Tracing {
    // Attempts to read all ints from a file and print them
    static void readFile(String filename) {
        System.out.println("-> Opening for read: " + filename);
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            while (true) {
                int x = in.readInt();
                System.out.println("Read value: " + x);
            }
        } catch (EOFException eof) {
            System.out.println("EOF reached on: " + filename);
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found: " + filename);
        } catch (IOException ioe) {
            System.out.println("I/O error on read: " + ioe.getMessage());
        }
    }

    // Writes two ints to the given file
    static void writeFile(String filename) {
        System.out.println("-> Opening for write: " + filename);
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            out.writeInt(42);
            System.out.println("Wrote value: 42");
            out.writeInt(99);
            System.out.println("Wrote value: 99");
        } catch (IOException ioe) {
            System.out.println("I/O error on write: " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Program start");

        // 1) Try reading a missing file
        readFile("input1.bin");

        // 2) Create a file and write data
        writeFile("input2.bin");

        // 3) Read back the newly written file
        readFile("input2.bin");

        System.out.println("Program end");
    }
}
