package Q1;

import java.util.ArrayList;
import java.util.List;

// nameable entities
interface Named {
    String getName();
}

// abstract animal
abstract class Animal implements Named {
    protected String name;

    public Animal(String name) {
        System.out.println("Animal::<init> " + name);
        this.name = name;
    }

    @Override
    public String getName() {
        System.out.println("Animal::getName on " + name);
        return name;
    }

    public abstract String speak();
}

// pets can play
interface Pet {
    void play();
}

// a dog
class Dog extends Animal implements Pet {
    public Dog(String name) {
        super(name);
        System.out.println("Dog::<init> " + name);
    }

    @Override
    public String speak() {
        System.out.println("Dog::speak on " + name);
        return "Woof!";
    }

    @Override
    public void play() {
        System.out.println(name + " wags tail");
    }
}

// a cat
class Cat extends Animal implements Pet {
    public Cat(String name) {
        super(name);
        System.out.println("Cat::<init> " + name);
    }

    @Override
    public String speak() {
        System.out.println("Cat::speak on " + name);
        return "Meow?";
    }

    @Override
    public void play() {
        System.out.println(name + " pounces");
    }
}

// a wild bird (not a Pet)
class Bird extends Animal {
    public Bird(String name) {
        super(name);
        System.out.println("Bird::<init> " + name);
    }

    @Override
    public String speak() {
        System.out.println("Bird::speak on " + name);
        return "Tweet-tweet";
    }
}

// generic container for any Named thing
class Sanctuary<T extends Named> {
    private List<T> inhabitants = new ArrayList<>();

    public void add(T x) {
        System.out.println("Sanctuary add: " + x.getName());
        inhabitants.add(x);
    }

    public void listAll() {
        System.out.println("Sanctuary listing:");
        for (T x : inhabitants) {
            System.out.println("- " + x.getName());
        }
    }
}

public class Q1_Tracing_2 {
    // generic polymorphic speak‑printer
    public static <T extends Animal & Named> void makeThemSpeak(List<T> list) {
        System.out.println("makeThemSpeak start");
        for (Animal a : list) {
            System.out.println(a.getName() + " says " + a.speak());
        }
        System.out.println("makeThemSpeak end");
    }

    public static void main(String[] args) {
        // build mixed animals
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Dog("Rex"));
        zoo.add(new Cat("Luna"));
        zoo.add(new Bird("Sky"));
        makeThemSpeak(zoo);

        // use Sanctuary for pets
        Sanctuary<Animal> petHouse = new Sanctuary<>();
        petHouse.add(new Dog("Max"));
        petHouse.add(new Cat("Misty"));
        petHouse.listAll();
        petHouse.add(new Dog("Bolt"));
        petHouse.listAll();
    }
}
