package Test2_Prac.Day1.ExceptionHandling_Practicing;

import java.io.*;

public class TestException2 {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }

    static void methodA() throws IOException {
        try {
            throw new FileNotFoundException("File missing");
        } catch (FileNotFoundException fnf) {
            System.out.println("Caught FNFE");
            throw new IOException("Wrapped IOException");
        } finally {
            System.out.println("methodA finally");
        }
    }
}
