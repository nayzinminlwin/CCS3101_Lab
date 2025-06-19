package Lab8.myLab;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class GenerateRandIntFile {
    public static void main(String[] args) {
        Random myRand = new Random();
        int lineCount = myRand.nextInt(80) + 70;
        // System.out.println(lineCount);

        String path = "Lab8/myLab/";
        File intDat = new File(path, "integer.dat");

        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(intDat));) {

            int sum = 0;
            for (int i = 0; i < lineCount; i++) {
                int currentRand = myRand.nextInt(150);
                sum += currentRand;
                output.write(currentRand);
            }

            System.out.println("Sum is : " + sum);
            output.close();

        } catch (FileNotFoundException fnfEx) {
            System.out.println("404 : File not found!");
        } catch (IOException ioEx) {
            System.out.println("IO problem!");
        }
    }
}