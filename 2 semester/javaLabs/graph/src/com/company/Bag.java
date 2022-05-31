package com.company;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private class Node{
        Item item;
        Node next;
    }

    public void addItem(Item a) {
        Node popFirst = first;
        first = new Node ();
        first.item=a;
        first.next=popFirst;
    }
    public Iterator<Item> iterator()
    {
        return new LIterator();
    }

    public class LIterator implements Iterator<Item>
    {
        private Node current=first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
