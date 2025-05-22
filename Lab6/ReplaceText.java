package Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 4) {
            System.out.println("Usage : java ReplaceText sourcefile.txt targetfile.txt oldString newString");
            System.exit(0);
        }
        String sourceFileName = "Lab6/" + args[0];
        String newFileName = "Lab6/" + args[1];
        String searchVal = args[2];
        String newString = args[3];

        // System.out.println(sourceFileName + newFileName + searchVal + newString);

        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + sourceFileName + " dont exist.");
            System.exit(1);
        }

        Scanner sc = new Scanner(sourceFile);
        PrintWriter output = new PrintWriter(newFileName);
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();

            // this is not need, replaceAll function will do the job!!
            // if (currentLine.indexOf(searchVal) > -1) {
            // currentLine = currentLine.replace(searchVal, newString);
            // }

            currentLine = currentLine.replaceAll(searchVal, newString);
            output.println(currentLine);
        }

        sc.close();
        output.close();

    }
}