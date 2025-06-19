package Lab8.myLab;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RetrieveRandIntFile {
    public static void main(String[] args) {
        String path = "Lab8/myLab";
        File intDat = new File(path, "integer.dat");

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(intDat))) {
            int val, sum = 0;
            while (input.available() != 0) {
                val = input.read();
                System.out.print(val + " ");
                sum += val;
            }

            System.out.println("\nSum of retrieved data is : " + sum);
            input.close();

        } catch (FileNotFoundException fnfEx) {
            System.out.println("404: File not found!");
        } catch (IOException ioEx) {
            System.out.println("IO problem!");
        }
    }
}