import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab5_1_ArrayIndexOutOfBoundException_Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        int[] dayCounts = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        try {
            System.out.print("Enter number from 1 to 12 : ");
            int userIndex = sc.nextInt();

            System.out.printf("Your month is %s and it has %d days.", months[userIndex -
                    1], dayCounts[userIndex - 1]);

            // while (true) {
            // int userIndex = 1 + (int) (Math.random() * 13);
            // System.out.println("\nRandom number : " + userIndex);

            // System.out.printf("Your month is %s and it has %d days.", months[userIndex -
            // 1],
            // dayCounts[userIndex - 1]);
            // }

        } catch (InputMismatchException inpEx) {
            System.out.println("Please enter only numbers.");
        } catch (ArrayIndexOutOfBoundsException arrEx) {
            System.out.println("You must enter only from 1 to 12.");
        } finally {
            sc.close();
        }
    }
}