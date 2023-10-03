import java.time.LocalDate;

public abstract class Abstract <Element> {

    LocalDate thisMoment = LocalDate.now();
    String letters = "ABCD";

    public abstract void add(Element x);
    public abstract boolean exists(Element x);

}
