package Test2_Prac.Day1.Ultimate_Poly_n_Exceptions;

// File: TestShapeIO.java

import java.io.*;
import java.util.*;

// Custom checked exception when a shape definition is invalid
class InvalidShapeException extends Exception {
    public InvalidShapeException(String msg) {
        super(msg);
    }
}

// Base abstract Shape
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // Calculate area (may throw InvalidShapeException)
    public abstract double area() throws InvalidShapeException;

    public String getName() {
        return name;
    }
}

// Circle subclass
class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws InvalidShapeException {
        super("Circle");
        if (radius <= 0) {
            throw new InvalidShapeException("Circle radius must be positive");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        // No exception here since constructor ensures positive radius
        return Math.PI * radius * radius;
    }
}

// Rectangle subclass
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) throws InvalidShapeException {
        super("Rectangle");
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException("Rectangle sides must be positive");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Factory to create shapes from a line of text
class ShapeFactory {
    // Format: "Circle,5.0" or "Rectangle,4.0,3.0"
    public static Shape createShape(String line) throws InvalidShapeException {
        String[] parts = line.split(",");
        String type = parts[0].trim();
        try {
            if (type.equalsIgnoreCase("Circle")) {
                double r = Double.parseDouble(parts[1].trim());
                return new Circle(r);
            } else if (type.equalsIgnoreCase("Rectangle")) {
                double w = Double.parseDouble(parts[1].trim());
                double h = Double.parseDouble(parts[2].trim());
                return new Rectangle(w, h);
            } else {
                throw new InvalidShapeException("Unknown shape type: " + type);
            }
        } catch (NumberFormatException nfe) {
            throw new InvalidShapeException("Invalid number format in: " + line);
        } catch (ArrayIndexOutOfBoundsException aioob) {
            throw new InvalidShapeException("Missing dimensions in: " + line);
        }
    }
}

public class TestShapeIO {
    public static void main(String[] args) {
        String inputFile = "shapes.txt";
        String outputFile = "areas_report.txt";
        String errorFile = "shapes_errors.log";

        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                BufferedWriter errorLog = new BufferedWriter(new FileWriter(errorFile))) {

            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                try {
                    System.out.println("Reading line " + lineNum + ": " + line);
                    Shape s = ShapeFactory.createShape(line);
                    shapes.add(s);
                    System.out.println("Created " + s.getName());
                } catch (InvalidShapeException ise) {
                    // Log and continue
                    errorLog.write("Line " + lineNum + ": " + ise.getMessage());
                    errorLog.newLine();
                    System.out.println("Error: " + ise.getMessage());
                }
                lineNum++;
            }

            // After reading all lines, compute areas
            for (Shape s : shapes) {
                try {
                    double a = s.area();
                    writer.write(s.getName() + " area = " + a);
                    writer.newLine();
                    System.out.println("Wrote area for " + s.getName());
                } catch (InvalidShapeException ise) {
                    // Shouldn’t happen for Circle/Rectangle here, but guard anyway
                    errorLog.write("Area error for " + s.getName() + ": " + ise.getMessage());
                    errorLog.newLine();
                    System.out.println("Area error: " + ise.getMessage());
                }
            }

            System.out.println("Processing complete. Check " + outputFile + " and " + errorFile);

        } catch (FileNotFoundException fnfe) {
            System.out.println("Input file not found: " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }
}
