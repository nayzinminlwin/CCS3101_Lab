package Test2_Prac.Day2.CodingSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeProcessor {
    public static String errorLogs = "";

    public static void main(String[] args) {
        String parentPath = "Test2_Prac/Day2/CodingSession/";
        String gradesFilePath = parentPath + "grades.csv";
        String repotFilePath = parentPath + "report.txt";
        String errorFilePath = parentPath + "errors.log";
        try {
            ArrayList<Student> students = readGrades(gradesFilePath);
            for (Student s : students) {
                System.out.println(s.id + " : " + s.avg);
            }
            writeReport(students, repotFilePath);

        } catch (FileNotFoundException fnfEx) {
            errorLogs += fnfEx.getMessage() + "\n";
        } finally {
            logError(errorLogs, errorFilePath);
        }

    }

    public static void writeReport(ArrayList<Student> students, String filePath) {
        File reportFile = new File(filePath);
        if (reportFile.exists()) {
            System.out.println("Report File already exits");
            reportFile.delete();
            System.exit(0);
        }
        try (PrintWriter output = new PrintWriter(reportFile)) {
            for (Student s : students) {
                output.printf("%s : %.2f\n", s.id, s.avg);
            }
        } catch (FileNotFoundException fnfEx) {
            errorLogs += "Report File not found to be written\n";
        }

    }

    public static void logError(String errorLogs, String filePath) {
        File erroFile = new File(filePath);
        if (erroFile.exists()) {
            System.out.println("Error file already exist!!");
            erroFile.delete();
            System.exit(1);
        }
        try (PrintWriter output = new PrintWriter(erroFile)) {
            output.println(errorLogs);
        } catch (FileNotFoundException fnfEx) {
            errorLogs += "ErrorFile not found to be written!\n";
            logError(errorLogs, filePath);
        }
    }

    public static ArrayList<Student> readGrades(String filePath)
            throws FileNotFoundException, NullPointerException, NumberFormatException {

        File grades = new File(filePath);
        ArrayList<Student> students = new ArrayList<>();

        try (Scanner sc = new Scanner(grades)) {
            while (sc.hasNextLine()) {
                String[] studentData = sc.nextLine().split(",");
                String id = studentData[0];
                double totalMark = 0;
                try {
                    for (int i = 1; i < studentData.length; i++)
                        totalMark += Integer.parseInt(studentData[i]);
                    double avg = totalMark / 3;
                    Student s = new Student(id, avg);
                    students.add(s);
                } catch (NumberFormatException nbfEx) {
                    errorLogs += "detected a string instead of number." + nbfEx.getMessage() + "\n";
                } catch (NullPointerException npEx) {
                    errorLogs += "Cant access null value." + npEx.getMessage() + "\n";
                }
            }

        } catch (FileNotFoundException fnfEx) {
            throw new FileNotFoundException("Grades.csv not Found!!");
        }

        Collections.sort(students);
        return students;

    }

    static class Student implements Comparable<Student> {
        String id;
        double avg;

        Student(String id, double avg) {
            this.id = id;
            this.avg = avg;
        }

        @Override
        public int compareTo(Student s0) {
            return Double.compare(s0.avg, this.avg);
        }
    }
}
