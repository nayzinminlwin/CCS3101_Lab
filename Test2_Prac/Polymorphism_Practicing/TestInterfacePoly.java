package Test2_Prac.Polymorphism_Practicing;

interface Speaker {
    default void speak() {
        System.out.println("Speaker: default speak()");
    }

    void announce(String msg);
}

class BaseSpeaker implements Speaker {
    @Override
    public void announce(String msg) {
        System.out.println("BaseSpeaker announces: " + msg);
    }
}

class AdvancedSpeaker extends BaseSpeaker {
    @Override
    public void speak() {
        System.out.println("AdvancedSpeaker: overridden speak()");
    }

    @Override
    public void announce(String msg) {
        System.out.println("AdvancedSpeaker announces loudly: " + msg.toUpperCase());
    }
}

public class TestInterfacePoly {
    public static void main(String[] args) {
        Speaker s1 = new BaseSpeaker();
        s1.speak();
        s1.announce("hello");

        Speaker s2 = new AdvancedSpeaker();
        s2.speak();
        s2.announce("hello");

        BaseSpeaker bs = new AdvancedSpeaker();
        bs.speak();
        bs.announce("bye");

        // Direct call to interface’s default (via super-call hack)
        new BaseSpeaker() {
            @Override
            public void announce(String msg) {
                super.speak();
                System.out.println("Anon announces: " + msg);
            }
        }.announce("test");
    }
}
