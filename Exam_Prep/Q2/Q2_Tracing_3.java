package Q2;

import java.io.*;
import java.util.*;

public class Q2_Tracing_3 {
    static void analyze(String fname) {
        System.out.println("Analyze start: " + fname);
        BufferedReader br = null;
        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) {
                lineNum++;
                System.out.println("Line " + lineNum + ": " + line);
                if (line.isEmpty())
                    throw new IllegalArgumentException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: missing file " + fname);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: blank line at " + lineNum);
        } catch (IOException e) {
            System.out.println("Error reading " + fname);
        } finally {
            System.out.println("Analyze finally: " + fname);
            try {
                if (br != null)
                    br.close();
            } catch (IOException ignored) {
            }
        }
    }

    static void writeDefault(String fname) {
        System.out.println("WriteDefault start: " + fname);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fname));
            pw.println("First line");
            System.out.println("Wrote: First line");
            pw.println("");
            System.out.println("Wrote: <empty line>");
            pw.println("Third line");
            System.out.println("Wrote: Third line");
        } catch (IOException e) {
            System.out.println("Error writing " + fname);
        } finally {
            System.out.println("WriteDefault finally: " + fname);
            if (pw != null)
                pw.close();
        }
    }

    static void transform(String in, String out) {
        System.out.println("Transform start: " + in + " -> " + out);
        Scanner sc = null;
        BufferedWriter bw = null;
        try {
            sc = new Scanner(new File(in));
            bw = new BufferedWriter(new FileWriter(out));
            while (sc.hasNext()) {
                String w = sc.next();
                bw.write(new StringBuilder(w).reverse().toString());
                bw.newLine();
                System.out.println("Reversed: " + w);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Transform error: input not found");
        } catch (IOException e) {
            System.out.println("Transform IO error");
        } finally {
            System.out.println("Transform finally");
            if (sc != null)
                sc.close();
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Program start");
        analyze("data.txt");
        writeDefault("data.txt");
        analyze("data.txt");
        transform("data.txt", "out.txt");
        analyze("out.txt");
        System.out.println("Program end");
    }
}
