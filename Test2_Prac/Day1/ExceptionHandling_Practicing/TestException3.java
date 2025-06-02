package Test2_Prac.Day1.ExceptionHandling_Practicing;

class Resource {
    Resource() throws Exception {
        System.out.println("Resource constructor start");
        if (true) {
            throw new Exception("Constructor Exception");
        }
        System.out.println("Resource constructor end");
    }

    void use() {
        System.out.println("Using resource");
    }
}

public class TestException3 {
    public static void main(String[] args) {
        Resource r = null;
        try {
            r = new Resource();
            r.use();
        } catch (Exception e) {
            System.out.println("Caught in main: " + e.getMessage());
        } finally {
            System.out.println("In finally, closing resource if not null");
            if (r != null) {
                System.out.println("Closing resource");
            } else {
                System.out.println("No resource to close");
            }
        }
        System.out.println("After try-catch-finally");
    }
}
