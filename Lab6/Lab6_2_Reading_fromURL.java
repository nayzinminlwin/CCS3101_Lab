package Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab6_2_Reading_fromURL {
    public static void main(String[] args) {

        // old way, with variables and if else

        // int assistantCount = 0;
        // double assistant_SalarySum = 0;

        // int associateCount = 0;
        // double associate_SalarySum = 0;

        // int fullCount = 0;
        // double full_SalarySum = 0;

        // new way with list and arrays, with indexes

        // ranks is initialized as list for IndexOf function,
        // Because arrays in java dont have indexOf function
        List<String> ranks = Arrays.asList("assistant", "associate", "full");

        // for storing count and Salary Sum for each 3 ranks
        double[][] count_n_salSum = { { 0, 0 }, { 0, 0 }, { 0, 0 } };

        try {
            // getting data from destination URL
            URL newUrl = new URL("https://liveexample.pearsoncmg.com/data/Salary.txt");
            Scanner sc = new Scanner(newUrl.openStream());

            // Starting working with the data
            while (sc.hasNextLine()) {
                // printing
                System.out.println(sc.nextLine());

                // get nextLine -> split by space -> insert to array
                String[] thisLineArr = sc.nextLine().split(" ");

                // if associate, count_n_Sal_Index -> 1;
                int count_n_Sal_Index = ranks.indexOf(thisLineArr[2]);

                // increasing repective count and adding Salary to Sum
                count_n_salSum[count_n_Sal_Index][0]++;
                count_n_salSum[count_n_Sal_Index][1] += Double.parseDouble(thisLineArr[3]);
            }
            // printing for all 3 positions
            for (int i = 0; i < ranks.size(); i++) {
                System.out.printf("Number of %s : %.0f\n", ranks.get(i), count_n_salSum[i][0]);
                System.out.printf("Total Salary : %.2f\n", count_n_salSum[i][1]);
                System.out.printf("Average Salary : %.2f\n", (count_n_salSum[i][1] / count_n_salSum[i][0]));
                System.out.println();
            }

        } catch (FileNotFoundException fnfEx) {
            System.out.println("File not found!!");
        } catch (MalformedURLException mfURLEx) {
            System.out.println("Wrong URL!!");
        } catch (IOException ioEx) {
            System.out.println("IO Exception!!");
        }
    }
}