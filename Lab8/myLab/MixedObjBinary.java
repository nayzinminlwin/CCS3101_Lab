package Lab8.myLab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;

public class MixedObjBinary {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 7, 1, 2, 3 };
        double db = 11.5;
        LocalTime currentTime = LocalTime.now();
        String greeting = "Hello World!";

        String path = "Lab8/myLab/";
        File outputfile = new File(path, "mixedObjectsBinary.dat");

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputfile));
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(outputfile))) {

            // data storing
            output.writeObject(arr);
            output.writeDouble(db);
            output.writeObject(currentTime);
            output.writeChars(greeting);

            output.close();

            // data fetching
            int[] myArr = (int[]) input.readObject();
            double myDb = input.readDouble();
            LocalTime myTime = (LocalTime) input.readObject();
            String myGreeting = input.readLine();

            // printing
            System.out.print("arr : [");
            for (int i : myArr) {
                System.out.print(i + ",");
            }
            System.out.printf("\b]\ndb : %.2f\nTime : %s\nGreeting : %s\n", myDb, myTime.toString(), myGreeting);

            input.close();

        } catch (FileNotFoundException fnfEx) {
            System.out.println("404 : file not found!");
        } catch (IOException ioEx) {
            System.out.println("IO problem!");
        } catch (ClassNotFoundException cnfEx) {
            System.out.println(cnfEx.getStackTrace());
        }

    }
}