package Lab9;

public class PairTesting {
    public static void main(String[] args) {
        String s0 = "Hello";
        String s1 = "World";
        Pair<String> p0 = new Pair<>(s0, s1);

        double d0 = 090.0;
        double d1 = 801.1;
        Pair<Double> p1 = new Pair<>(d0, d1);

        int i0 = 22;
        int i1 = 3;
        Pair<Integer> p2 = new Pair<>(i0, i1);

        // System.out.println(Pair.wildCard_min(p0)); // error
        System.out.println(Pair.wildCard_min(p1));
        System.out.println(Pair.wildCard_min(p2));

        // System.out.println(Pair.min(p0)); // error
        System.out.println(Pair.min(p1));
        System.out.println(Pair.min(p2));

    }

}
