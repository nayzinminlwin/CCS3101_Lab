package Test2_Prac.Day2.LectureReview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_studentScore {
    public static void main(String[] args) {
        String parentPath = "Test2_Prac/Day2/LectureReview";
        File f1 = new File(parentPath, "StudentRecords.txt");
        try (Scanner sc = new Scanner(f1);) {
            while (sc.hasNextLine()) {
                String studentName = sc.nextLine();
                String[] studentMarks = sc.nextLine().split(",");
                String matricNum = studentMarks[0];
                int totalMark = 0;
                for (int i = 1; i < studentMarks.length; i++) {
                    totalMark += Integer.parseInt(studentMarks[i]);
                }
                System.out.printf("Student : %s (%s)\n", studentName, matricNum);
                System.out.printf("Total Mark : %d\n", totalMark);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("404 : File Not Found Exception!!");
        }

    }

}
