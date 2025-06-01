package Test2_Prac;

class Fruit {
    Fruit getColor() {
        System.out.println("Unknown Color");
        return this;
    }
}

class Apple extends Fruit {
    @Override
    Apple getColor() {
        System.out.println("Apple.getColor() returning an Apple reference");
        return this;
    }

    void showType() {
        System.out.println("This is an Apple");
    }
}

class Banana extends Fruit {
    @Override
    Banana getColor() {
        System.out.println("Banana.getColor() returning a Banana reference");
        return this;
    }

    void peel() {
        System.out.println("Peeling Banana");
    }
}

public class TestCovariant {
    public static void main(String[] args) {
        Fruit f1 = new Apple();
        Fruit f2 = new Banana();

        Fruit result1 = f1.getColor();
        // result1 has compile-time type Fruit, but runtime object is Apple
        // to call showType(), need a cast
        ((Apple) result1).showType();

        Fruit result2 = f2.getColor();
        ((Banana) result2).peel();

        // What if we try wrong cast?
        try {
            ((Banana) f1.getColor()).peel();
        } catch (ClassCastException e) {
            System.out.println("Caught a ClassCastException");
        }
    }
}
