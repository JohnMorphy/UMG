package com.company;

public class Stack<Element> {
    public StackObject first = null;
    private int N;

    public class StackObject {
        Element element;
        StackObject second =null;
    }

    public void push(Element add)
    {
        StackObject oldFirst= first;
        first = new StackObject();
        first.element=add;
        first.second =oldFirst;
        N++;
    }

    public Element peek()
    {
        if(isEmpty()) return null;
        return first.element;
    }

    public Element pop()
    {
        if(isEmpty()) return null;
        N--;
        StackObject buffer = first;
        first = first.second;
        return buffer.element;
    }

    public boolean isEmpty() {return N==0;}
    public int size() {return N;}

    static class Two{
        int first;
        int second;

        public Two(int first, int second)
        {
            this.first =first;
            this.second = second;
        }
        public String toString(){
            return first + " " + second;
        }
    }

    public static void main(String[] args) {
        /*
        Stos<Integer> stosI = new Stos<>();
        Random random = new Random();
        int bound=100;
        for(int i=0; i<20; i++)
        {
            stosI.push(random.nextInt(bound));
        }

        for(int i=0; i<20; i++)
        {
            System.out.print(stosI.deletePop() + " ");;
        }
         */

        /*
        Stos<String> stosI = new Stos<>();
        String[] lista = {"Kaczor", "Kaiser", "Isalov", "Janke", "Kohsin"};
        for(int i=0; i< lista.length; i++)
        {
            stosI.push(lista[i]);
        }

        for(int i=0; i<lista.length;i++)
        {
            lista[i]= stosI.deletePop();
            System.out.print(lista[i] + " ");
        }
        */

        /*
        Stos<Two> stosI = new Stos<Two>();
        Random random = new Random();
        int bound=10;
        for(int i=0; i<10; i++)
        {
            stosI.push(new Two(random.nextInt(bound), random.nextInt(bound)));
            System.out.print(stosI.pop());
            System.out.print(" ");
        }
        System.out.println();
        int sum1=0;
        int sum2=0;
        for(int i=0; i<10; i++)
        {
            Two buffer = stosI.deletePop();
            sum1+= buffer.first;
            sum2+= buffer.second;
        }
        System.out.println(sum1 + " " + sum2);
        */

        Stack<Integer> stackI = new Stack<Integer>();
        Integer[] liczby = {4,11,40,32};
    }
}
