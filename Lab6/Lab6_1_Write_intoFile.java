package Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab6_1_Write_intoFile {

    public static void main(String[] args) {
        String[] ranks = { "assistant", "associate", "full" };
        int[][] salaries = { { 50000, 80000 }, { 60000, 110000 }, { 75000, 130000 } };

        File myFile = new File("Lab6/Salary.txt");
        try (PrintWriter output = new PrintWriter(myFile);) {

            for (int i = 0; i < 1000; i++) {
                String fName = "FirstName" + (i + 1);
                String lName = "LastName" + (i + 1);
                int randRank = (int) Math.round(Math.random() * 2);
                String rank = ranks[randRank];
                double salary = (Math.random() * (salaries[randRank][1] - salaries[randRank][0]))
                        + salaries[randRank][0];
                String line = String.format("%s %s %s %.2f", fName, lName, rank, salary);
                output.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

}
