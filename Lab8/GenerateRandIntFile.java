package Lab8;

import java.util.Random;

public class GenerateRandIntFile {
    public static void main(String[] args) {
        Random myRand = new Random();
        int lineCount = myRand.nextInt(80) + 70;
        System.out.println(lineCount);

        for (int i = 0; i < lineCount; i++) {
            int currentRand = myRand.nextInt(0);
        }
    }
}