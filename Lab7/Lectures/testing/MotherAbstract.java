package Lab7.Lectures.testing;

public abstract class MotherAbstract {
    protected String name;

    MotherAbstract() {
        this.name = "name";
    }

    public String toString() {
        return "this is mother toString funcion.";
    }

    public abstract void abstractFuntion();
}