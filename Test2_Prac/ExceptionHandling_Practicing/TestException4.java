package Test2_Prac.ExceptionHandling_Practicing;

import java.io.*;
import java.sql.*;

public class TestException4 {
    static void methodA() throws Exception {
        try {
            // Simulate either I/O or SQL error:
            if (System.currentTimeMillis() % 2 == 0) {
                throw new FileNotFoundException("config.txt not found");
            } else {
                throw new SQLException("Database unreachable");
            }
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("Caught in methodA: " + e.getClass().getSimpleName());
            throw e; // rethrow the same exception
        } finally {
            System.out.println("methodA finally block");
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
            System.out.println("methodA returned normally");
        } catch (IOException ioe) {
            System.out.println("Caught IOException in main: " + ioe.getMessage());
        } catch (SQLException se) {
            System.out.println("Caught SQLException in main: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Caught generic Exception in main: " + e.getMessage());
        } finally {
            System.out.println("main finally block");
        }
        System.out.println("End of main");
    }
}
