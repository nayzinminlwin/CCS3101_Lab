package Test2_Prac;

import java.util.*;

class Animal {
    public String getName() {
        return "Unknown Animal";
    }
}

class Dog extends Animal {
    @Override
    public String getName() {
        return "Dog";
    }

    public void bark() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public String getName() {
        return "Cat";
    }

    public void meow() {
        System.out.println("Meow!");
    }
}

public class TestPolyArray {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Animal();

        for (Animal a : animals) {
            System.out.println(a.getName());
            // Try down-casting:
            if (a instanceof Dog) {
                ((Dog) a).bark();
            } else if (a instanceof Cat) {
                ((Cat) a).meow();
            } else {
                System.out.println("No specific sound");
            }
        }

        List<? extends Animal> list = Arrays.asList(new Dog(), new Cat());
        Animal a0 = list.get(0);
        System.out.println("list.get(0).getName(): " + a0.getName());
        // The next line would not compile if uncommented:
        // list.add(new Dog());
        System.out.println("list.get(1).getName(): " + list.get(1).getName());
    }
}
