package Test2_Prac.Day2.CodingSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeProcessor {
    public static final ArrayList<String> errorLogs = new ArrayList<>();

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
            errorLogs.add(fnfEx.getMessage());
        } finally {
            logError(errorFilePath);
        }

    }

    public static void writeReport(ArrayList<Student> students, String filePath) {
        File reportFile = new File(filePath);

        try (PrintWriter output = new PrintWriter(reportFile)) {
            for (Student s : students) {
                output.printf("%s : %.2f\n", s.id, s.avg);
            }
        } catch (FileNotFoundException fnfEx) {
            errorLogs.add("Report File not found to be written");
        }

    }

    public static void logError(String filePath) {
        File errorFile = new File(filePath);

        try (PrintWriter output = new PrintWriter(errorFile)) {
            for (String erLog : errorLogs) {
                output.println(erLog);
            }

        } catch (FileNotFoundException fnfEx) {
            // errorLogs += "ErrorFile not found to be written!\n";
            // logError(errorLogs, filePath);

            // errorLogs.add("ErrorFile not found." + fnfEx.getMessage());

            System.err.println("ErrorLogs file not found!!" + fnfEx.getMessage());
        }
    }

    public static ArrayList<Student> readGrades(String filePath) throws FileNotFoundException {

        File grades = new File(filePath);
        ArrayList<Student> students = new ArrayList<>();

        try (Scanner sc = new Scanner(grades)) {
            mainWhile: while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] studentData = currentLine.split(",");
                if (studentData.length > 4) {
                    errorLogs.add("Malformed line (expected 4 columns ) : " + currentLine);
                    continue mainWhile;
                }
                String id = studentData[0].trim();
                int totalMark = 0;
                try {
                    for (int i = 1; i < studentData.length; i++)
                        totalMark += Integer.parseInt(studentData[i]);
                    double avg = totalMark / 3;
                    Student s = new Student(id, avg);
                    students.add(s);
                } catch (NumberFormatException nbfEx) {
                    errorLogs
                            .add("Detected a string instead of number at Student ID : " + id);
                }
            }

        } catch (FileNotFoundException fnfEx) {
            errorLogs.add("Grades.csv not Found!!" + fnfEx.getMessage());
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
