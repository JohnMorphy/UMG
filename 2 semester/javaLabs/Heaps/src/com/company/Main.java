package com.company;

public class Main {

    public static void main(String[] args) {

        Heap<Person> heaps1 =new Heap<>();
        heaps1.add(new Person());
        heaps1.add(new Person("Nowak", "Kazimierz", "1998-3-11"));
        heaps1.add(new Person("Żabiński", "Mateusz", "1992-11-1"));
        heaps1.add(new Person("Angielska", "Anna", "1990-11-1"));
        heaps1.add(new Person("Wyczliński", "Krzysztof", "2002-1-1"));
        heaps1.print();

        Heap<Float> heap = new Heap<>();
        float[] random = new float[10];
        Heap.randomize(random, 0, 100);

        for (float v : random) {
            heap.add(v);
        }

        System.out.println("heap " + heap.isHeap());
        heap.print();
        heap.createHeap();
        heap.print();
        System.out.println("heap " + heap.isHeap());
        heap.sort();
        heap.print();



        Heap<String> heap1 = new Heap<>();
        String list[] = {"", "Zbigniew", "Adam", "Daniel", "Celina", "Zosia"};
        Heap<Integer> heap2 = new Heap<>();
        Integer list2[] = {0, 32, 15, 2, 45, 67, 65, 45, 78, 76};
        for(String s:list) heap1.add(s);
        System.out.println("heap1 " + heap1.isHeap());
        heap1.createHeap();
        heap1.print();
        System.out.println("heap1 " + heap1.isHeap());

        for(int i=0; i<list2.length; i++)
        {
            heap2.add(list2[i]);
        }

        System.out.println("heap1 " + heap1.isHeap());
        heap2.createHeap();
        heap2.print();
        System.out.println("heap2 " + heap2.isHeap());    }
}
