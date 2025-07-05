package Q1;

import java.util.ArrayList;
import java.util.List;

interface Named_ {
    String getName();
}

abstract class Animal implements Named {
    protected String name;

    public Animal(String name) {
        System.out.println("Animal constructor: " + name);
        this.name = name;
    }

    public String getName() {
        System.out.println("getName() called on " + name);
        return name;
    }

    public abstract String speak();
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {
    public Dog(String name) {
        super(name);
        System.out.println("Dog constructor: " + name);
    }

    public String speak() {
        System.out.println("speak() in Dog: " + name);
        return "Woof";
    }

    public void play() {
        System.out.println(name + " plays fetch");
    }
}

class Cat extends Animal implements Pet {
    public Cat(String name) {
        super(name);
        System.out.println("Cat constructor: " + name);
    }

    public String speak() {
        System.out.println("speak() in Cat: " + name);
        return "Meow";
    }

    public void play() {
        System.out.println(name + " chases laser");
    }
}

class Kennel<T extends Pet> {
    private List<T> pets = new ArrayList<>();

    public void add(T pet) {
        System.out.println("Adding pet to kennel: " + ((Named) pet).getName());
        pets.add(pet);
    }

    public void allPlay() {
        System.out.println("Kennel allPlay start");
        for (T p : pets)
            p.play();
        System.out.println("Kennel allPlay end");
    }
}

public class Q1_Tracing_1 {
    public static <T extends Animal & Named> void printSpeak(List<T> animals) {
        System.out.println("printSpeak start");
        for (Animal a : animals) {
            System.out.println(a.getName() + " says " + a.speak());
        }
        System.out.println("printSpeak end");
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Rex"));
        animals.add(new Cat("Mia"));
        printSpeak(animals);

        Kennel<Pet> kennel = new Kennel<>();
        kennel.add(new Dog("Buddy"));
        kennel.add(new Cat("Shadow"));
        kennel.allPlay();
    }
}
