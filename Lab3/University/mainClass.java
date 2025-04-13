package Lab3.University;

public class mainClass{
    public static void main(String[] args) {
        Person NZML = new Person();
        NZML.walk();
        System.out.println(NZML);

        Student NZ = new Student();
        System.out.println(NZ);

        Employee e1 = new Employee();
        System.out.println(e1);

        Staff s1 = new Staff();
        System.out.println(s1);

        Faculty f1 = new Faculty();
        System.out.println(f1);
    }
}