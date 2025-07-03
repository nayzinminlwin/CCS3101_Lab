package Q2;

import java.io.*;

public class Q2_Tracing_2 {
    static void readNumbers(String filename) {
        System.out.println("ReadNumbers start: " + filename);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            int lineNum = 1;
            while ((line = br.readLine()) != null) {
                System.out.println("Line " + lineNum + ": " + line);
                int num = Integer.parseInt(line);
                System.out.println("Parsed " + num);
                lineNum++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Number format error on line");
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } finally {
            System.out.println("ReadNumbers finally: " + filename);
            try {
                if (br != null)
                    br.close();
            } catch (IOException ignored) {
            }
        }
    }

    static void writeNumbers(String filename) {
        System.out.println("WriteNumbers start: " + filename);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(filename));
            pw.println("10");
            System.out.println("Wrote text: 10");
            pw.println("X");
            System.out.println("Wrote text: X");
            pw.println("20");
            System.out.println("Wrote text: 20");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        } finally {
            System.out.println("WriteNumbers finally: " + filename);
            if (pw != null)
                pw.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("Program start");
        readNumbers("nums.txt");
        writeNumbers("nums.txt");
        readNumbers("nums.txt");
        System.out.println("Program end");
    }
}
