package Lab9;

public class PairTesting {
    public static void main(String[] args) {

        Pair<String> p0 = new Pair<>("Hello", "World");

        Pair<Double> p1 = new Pair<>(090.0, 801.1);

        Pair<Integer> p2 = new Pair<>(22, 3);

        // System.out.println(p0.getFirst().getClass());
        // System.out.println(Pair.wildCard_min(p0)); // compileTime error
        System.out.println(Pair.wildCard_min(p1));
        System.out.println(Pair.wildCard_min(p2));

        // System.out.println(Pair.min(p0)); // compileTime error
        System.out.println(Pair.min(p1));
        System.out.println(Pair.min(p2));

    }
}
