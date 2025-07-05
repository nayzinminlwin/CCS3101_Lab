package Lab8.Lectures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class IOTesting {
    public static void main(String[] args) throws IOException {
        FileOutputStream fOut = new FileOutputStream("myTestingFile.dat");
        fOut.write(201);

        FileInputStream fIn = new FileInputStream("myTestingFile.dat");
        System.out.println(fIn.read());

        File hehe = new File("newFileHehe.txt");
        // hehe.delete();
        PrintWriter pw = new PrintWriter(hehe);

    }
}