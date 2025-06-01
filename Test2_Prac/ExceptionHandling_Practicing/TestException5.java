package Test2_Prac.ExceptionHandling_Practicing;

import java.io.IOException;

class InvalidDataException extends RuntimeException {
    public InvalidDataException(String msg) {
        super(msg);
    }
}

public class TestException5 {
    static void parseData(String data) throws IOException {
        try {
            if (data == null) {
                throw new IOException("Data is null");
            }
            int val = Integer.parseInt(data);
            if (val < 0) {
                throw new InvalidDataException("Negative not allowed");
            }
            System.out.println("Parsed value: " + val);
        } catch (NumberFormatException nfe) {
            System.out.println("Caught NumberFormatException: " + nfe.getMessage());
            throw new IOException("Wrapped NumberFormatException");
        } finally {
            System.out.println("parseData finally");
        }
    }

    public static void main(String[] args) {
        String[] inputs = { "42", null, "-7", "abc" };
        for (String s : inputs) {
            try {
                System.out.println("---- Processing: " + s + " ----");
                parseData(s);
                System.out.println("parseData succeeded");
            } catch (InvalidDataException ide) {
                System.out.println("Caught InvalidDataException in main: " + ide.getMessage());
            } catch (IOException ioe) {
                System.out.println("Caught IOException in main: " + ioe.getMessage());
            } finally {
                System.out.println("main finally for input: " + s);
                System.out.println();
            }
        }
        System.out.println("Loop complete");
    }
}
