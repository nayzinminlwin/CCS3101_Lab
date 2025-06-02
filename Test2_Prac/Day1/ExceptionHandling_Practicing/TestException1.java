package Test2_Prac.Day1.ExceptionHandling_Practicing;

class Base {
    void process() throws Exception {
        throw new Exception("Base Exception");
    }
}

class Derived extends Base {
    @Override
    void process() /* note: no throws */ {
        throw new RuntimeException("Derived Runtime");
    }
}

public class TestException1 {
    public static void main(String[] args) {
        Base b = new Derived();
        try {
            b.process();
            System.out.println("No exception");
        } catch (RuntimeException re) {
            System.out.println("Caught runtime: " + re.getMessage());
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block");
        }
        System.out.println("After try-catch");
    }
}
