package Lab9;

public class Pair<E> {
    private E firstObj;
    private E secondObj;

    Pair(E e0, E e1) {
        this.firstObj = e0;
        this.secondObj = e1;
    }

    public E getFirst() {
        return this.firstObj;
    }

    public void setFirst(E newE) {
        this.firstObj = newE;
    }

    public E getSecond() {
        return this.secondObj;
    }

    public void setSecond(E newE) {
        this.secondObj = newE;
    }

    public static Number wildCard_min(Pair<? extends Number> p) {
        Number n1 = p.getFirst();
        Number n2 = p.getSecond();

        return n1.doubleValue() < n2.doubleValue() ? n1 : n2;
    }

    public static <U extends Number> U min(Pair<U> p) {
        U firstElem = p.getFirst();
        U secondElem = p.getSecond();

        return firstElem.doubleValue() < secondElem.doubleValue() ? firstElem : secondElem;
    }

}
