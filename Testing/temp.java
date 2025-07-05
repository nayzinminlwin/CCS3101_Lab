package Testing;

import java.util.Scanner;

public class temp {

    public static void main(String[] args) {

        int[] temps = { 41, 44, 42, 40, 38, 43, 41, 40, 42, 45, 47, 48 };
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter starting hour : ");
        int startHour = sc.nextInt();

        System.out.print("Please enter ending hour : ");
        int endHour = sc.nextInt();

        double totalTemp = 0;
        for (int i = startHour - 1; i < endHour; i++) {
            // System.out.println("Curr deg : " + temps[i]);
            totalTemp += temps[i];
        }
        double avgTemp = totalTemp / (endHour - startHour + 1);

        System.out.printf("Average temperature from %d to %d is %.2f", startHour, endHour, avgTemp);
    }

}
