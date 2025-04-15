package Lab3.University;

public class mainClass{
    public static void main(String[] args) {
        // Create a Person object and call the walk method
        Person NZML = new Person();
        NZML.walk();
        System.out.println(NZML);

        // Student instantiation
        Student NZ = new Student("Nay Zin Min Lwin", "Serdang", "009", "nzml@gmail.com","freshman");
        System.out.println(NZ);

        // Employee instantiation
        Employee e1 = new Employee("Alex","Seri Kembagan","001","alex@gmail.com","office 1",1000, new java.util.Date());
        System.out.println(e1);

        // Staff and Faculty instantiation
        Staff s1 = new Staff("Mr.Nur","Petaling Jaya", "005","nur@gmail.com","office 2",2000, new java.util.Date(),"Manager");
        System.out.println(s1);

        Faculty f1 = new Faculty("Dr.Nil", "Kaula Lumpur","009","nil@gmail.com","office 3",3000, new java.util.Date(),"Professor", 10);
        System.out.println(f1);
    }
}