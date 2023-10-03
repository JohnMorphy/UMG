package Gameplay;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory implements Iterable<Item> {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getSize() {
        return items.size();
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

}


