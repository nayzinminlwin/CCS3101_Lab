package Test2_Prac.Polymorphism_Practicing;

class Parent {
    public void display(int x) {
        System.out.println("Parent.display(int): " + x);
    }

    public void display(Object o) {
        System.out.println("Parent.display(Object): " + o);
    }

    public static void print() {
        System.out.println("Parent.print()");
    }
}

class Child extends Parent {
    @Override
    public void display(int x) {
        System.out.println("Child.display(int): " + x);
    }

    public void display(String s) {
        System.out.println("Child.display(String): " + s);
    }

    public static void print() {
        System.out.println("Child.print()");
    }
}

public class TestOverloadOverride {
    public static void main(String[] args) {
        Parent p1 = new Child();
        p1.display(10);
        p1.display("Hello");

        Child c1 = new Child();
        c1.display(20);
        c1.display("World");

        Parent p2 = new Parent();
        p2.display("Test");

        // Static method calls
        p1.print();
        Child.print();
        ((Parent) new Child()).print();
    }
}
