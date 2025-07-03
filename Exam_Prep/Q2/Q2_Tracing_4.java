package Q2;

import java.io.*;
// import java.util.*;

public class Q2_Tracing_4 {
    static void readScores(String filename) {
        System.out.println("ReadScores start: " + filename);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Line: " + line);
                for (String tok : line.split(" ")) {
                    System.out.println("Token: " + tok);
                    if (tok.equals("ERR"))
                        throw new IOException("Bad token");
                    int v = Integer.parseInt(tok);
                    System.out.println("Int: " + v);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File missing: " + filename);
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number error: " + e.getMessage());
        } finally {
            System.out.println("ReadScores finally: " + filename);
            try {
                if (br != null)
                    br.close();
            } catch (IOException ignored) {
            }
        }
    }

    static void writeScores(String filename) {
        System.out.println("WriteScores start: " + filename);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(filename));
            pw.println("3 5");
            System.out.println("Wrote: 3 5");
            pw.println("ERR 7");
            System.out.println("Wrote: ERR 7");
            pw.println("9 2");
            System.out.println("Wrote: 9 2");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        } finally {
            System.out.println("WriteScores finally: " + filename);
            if (pw != null)
                pw.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("Program start");
        readScores("scores.txt");
        writeScores("scores.txt");
        readScores("scores.txt");
        System.out.println("Program end");
    }
}
