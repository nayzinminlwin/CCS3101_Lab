package Lab7.Lectures.testing;

public class BabyAbstract {
    public static void main(String[] args) {
        // cannot create an instance from abstract class like below
        // MotherAbstract m1 = new MotherAbstract(); // salah

        // but this way can, by filling the blank of abstract

        String rtnS = new MotherAbstract() {
            @Override
            public void abstractFuntion() {
                System.out.println("Now i am alive");
            }
        }.toString();

        // it is called anonymous object.
        // the object got no name and cant be reuse anywhere else.

        System.out.println(rtnS);
    }
}