import java.util.ArrayList;

public class ImplementAbstract extends AbstractExample<Person> {

    public static ArrayList<Person> list = new ArrayList<>();

    @Override
    public void add(Person x) {
        list.add(x);
    }

    @Override
    public boolean exists(Person x) {
        for(Person i : list) {
            if(i.equals(x))
                return true;
        }
        return false;
    }
}
