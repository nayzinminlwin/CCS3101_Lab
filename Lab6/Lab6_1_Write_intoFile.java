package Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab6_1_Write_intoFile {

    public static void main(String[] args) {

        // an array and a two dimentional array Mimicing the Key : Value Pair Mapping
        // rank names
        String[] ranks = { "assistant", "associate", "full" };
        // min salary and max salary for each rank
        int[][] salaries = { { 50000, 80000 }, { 60000, 110000 }, { 75000, 130000 } };

        // Creating file and writing
        File myFile = new File("Lab6/Salary.txt");
        try (PrintWriter output = new PrintWriter(myFile);) {

            for (int i = 0; i < 1000; i++) {
                String fName = "FirstName" + (i + 1);
                String lName = "LastName" + (i + 1);
                int rankIndex = (int) Math.round(Math.random() * 2);
                String rank = ranks[rankIndex];
                double salary = (Math.random() * (salaries[rankIndex][1] - salaries[rankIndex][0]))
                        + salaries[rankIndex][0];

                // Now line to be printed is ready
                String line = String.format("%s %s %s %.2f", fName, lName, rank, salary);
                output.println(line); // printed into file
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

}
