package Test2_Prac.Polymorphism_Practicing;

class A {
    void show() {
        System.out.println("A.show()");
    }
}

class B extends A {
    void show() {
        System.out.println("B.show()");
    }
}

public class TestPolymorph1 {
    public static void main(String[] args) {
        A a1 = new B();
        a1.show();
        ((B) a1).show();
        A a2 = new A();
        // a2 refers to A, but can we cast to B?
        B b2 = (B) a2;
        b2.show();
    }
}
