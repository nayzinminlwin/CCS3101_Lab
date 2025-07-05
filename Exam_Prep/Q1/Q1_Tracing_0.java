package Q1;

import java.util.ArrayList;
import java.util.List;

// interface for naming
interface Named {
    String getName();
}

// abstract base class
abstract class Animal implements Named_ {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String speak();
}

// another interface
interface Pet {
    void play();
}

// concrete subclass #1
class Dog extends Animal implements Pet {
    public Dog(String name) {
        super(name);
    }

    public String speak() {
        return "Woof";
    }

    public void play() {
        System.out.println(name + " plays fetch");
    }
}

// concrete subclass #2
class Cat extends Animal implements Pet {
    public Cat(String name) {
        super(name);
    }

    public String speak() {
        return "Meow";
    }

    public void play() {
        System.out.println(name + " chases laser");
    }
}

// generic kennel for any Pet
class Kennel<T extends Pet> {
    private List<T> pets = new ArrayList<>();

    public void add(T pet) {
        pets.add(pet);
    }

    public void allPlay() {
        for (T p : pets)
            p.play();
    }
}

public class Q1_Tracing_0 {
    // generic method using inheritance & interface
    public static <T extends Animal & Named_> void printSpeak(List<T> animals) {
        for (Animal a : animals) {
            System.out.println(a.getName() + " says " + a.speak());
        }
    }

    public static void main(String[] args) {
        // 1) build and print animal sounds
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Rex"));
        animals.add(new Cat("Mia"));
        printSpeak(animals);

        // 2) use generic Kennel
        Kennel<Dog> dogKennel = new Kennel<>();
        dogKennel.add(new Dog("Buddy"));
        dogKennel.add(new Dog("Charlie"));
        dogKennel.allPlay();
    }
}
