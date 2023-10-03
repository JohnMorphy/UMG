import java.util.ArrayList;

public class Collection implements WorkOnCollections<Person> {

    public static ArrayList<Person> objectList = new ArrayList();

    @Override
    public void add(Person x) {
        objectList.add(x);
    }

    @Override
    public boolean belongsTo(Person x) {
        for(Person i : objectList) {
            if(i.equals(x))
                return true;
        }
        return false;
    }

    @Override
    public int giveNumber() {
        return 0;
    }

    @Override
    public void print() {
        for (Person i : objectList) {
            System.out.println(i);
        }
    }
}
