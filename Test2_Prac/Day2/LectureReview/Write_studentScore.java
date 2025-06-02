package Test2_Prac.Day2.LectureReview;

import java.util.*;
import java.io.*;

public class Write_studentScore {
    public static void main(String[] args) {
        String studentName;
        int matricNum;
        int firstTest, secondTest, labTest, finalTest;
        int studentCount = 10;
        String parentPath = "Test2_Prac/Day2/LectureReview";
        File f1 = new File(parentPath, "StudentRecords.txt");
        if (f1.exists()) {
            System.out.println("File already exist.");
            f1.delete();
            System.exit(0);
        }

        try (PrintWriter output = new PrintWriter(f1)) {
            for (int i = 1; i < studentCount; i++) {
                studentName = "Student" + i;
                matricNum = 230000 + i;
                firstTest = (int) Math.round(Math.random() * 20);
                secondTest = (int) Math.round(Math.random() * 20);
                labTest = (int) Math.round(Math.random() * 20);
                finalTest = (int) Math.round(Math.random() * 40);
                // totalScore = firstTest + secondTest + labTest + finalTest;

                output.println(studentName);
                output.printf("%d,%d,%d,%d,%d\n", matricNum, firstTest, secondTest, labTest, finalTest);

            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found exception!!");
        }
    }
}
