package Test2_Prac.Poly_n_Exceptions;

// File: TestOperations.java

// Define a checked exception for division errors
class DivisionException extends Exception {
    public DivisionException(String msg) {
        super(msg);
    }
}

// Define a checked exception for modulus errors
class ModulusException extends Exception {
    public ModulusException(String msg) {
        super(msg);
    }
}

// Base class for arithmetic operations
class Operation {
    protected int x, y;

    public Operation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // perform() may throw a generic Exception
    public int perform() throws Exception {
        System.out.println("Operation.perform()");
        return x + y;
    }
}

// Subclass: Division operation
class Division extends Operation {
    public Division(int x, int y) {
        super(x, y);
    }

    // Override perform() to throw a more specific checked exception
    @Override
    public int perform() throws DivisionException {
        System.out.println("Division.perform()");
        if (y == 0) {
            throw new DivisionException("Cannot divide by zero");
        }
        return x / y;
    }
}

// Subclass: Modulus operation
class Modulus extends Operation {
    public Modulus(int x, int y) {
        super(x, y);
    }

    // Override perform() to throw a more specific checked exception
    @Override
    public int perform() throws ModulusException {
        System.out.println("Modulus.perform()");
        if (y == 0) {
            throw new ModulusException("Cannot modulus by zero");
        }
        return x % y;
    }
}

// Subclass: Special operation that throws at runtime
class FaultyOperation extends Operation {
    public FaultyOperation(int x, int y) {
        super(x, y);
    }

    @Override
    public int perform() {
        System.out.println("FaultyOperation.perform()");
        throw new RuntimeException("Fault inside FaultyOperation");
    }
}

public class TestOperations {
    // Helper method to invoke perform() polymorphically and handle exceptions
    public static void execute(Operation op) {
        try {
            int result = op.perform();
            System.out.println("Result: " + result);
        } catch (DivisionException de) {
            System.out.println("Caught DivisionException: " + de.getMessage());
        } catch (ModulusException me) {
            System.out.println("Caught ModulusException: " + me.getMessage());
        } catch (RuntimeException re) {
            System.out.println("Caught RuntimeException: " + re.getMessage());
        } catch (Exception e) {
            System.out.println("Caught generic Exception: " + e.getMessage());
        } finally {
            System.out.println("execute() finally block for " + op.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Operation[] ops = new Operation[] {
                new Operation(10, 5), // base class: perform() → addition
                new Division(10, 2), // division with y ≠ 0
                new Division(10, 0), // division by zero
                new Modulus(10, 3), // modulus, y ≠ 0
                new Modulus(10, 0), // modulus by zero
                new FaultyOperation(1, 1) // always throws RuntimeException
        };

        for (Operation op : ops) {
            System.out.println("---- Executing " + op.getClass().getSimpleName() + " ----");
            execute(op);
            System.out.println();
        }
    }
}
