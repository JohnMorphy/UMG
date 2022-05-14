package com.company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class CountingLetters <K1> {
    private Node root;
    class Node {
        K1 key;
        int value;
        Node left;
        Node right;
        int treeSize;
        public Node(K1 a, int N) {
            this.key = a;
            this.value = 1;
            this.treeSize = N;
        }
        public String toString(){
            String text=String.format("%-11s %02d %03d",key,value,treeSize);
            return text;
        }
    }

    Collator c = Collator.getInstance(new Locale("pl", "PL"));

    Comparator<K1> compS = new Comparator<K1>(){
        @Override
        public int compare(K1 s1, K1 s2) {
            if (s1.getClass().getName().endsWith("Integer"))
                return (int)Math.signum((int)s1-(int)s2);
            if (s1.getClass().getName().endsWith("Character"))
                return c.compare(String.valueOf(s1), String.valueOf(s2));
            return c.compare(s1,s2);
        }
    };

    Node MinimalKey_Recursive(Node next) {
        if (next.left == null) return next;
        else return MinimalKey_Recursive(next.left);
    }

    Node MaximalKey_Recursive(Node next) {
        if (next.right == null) return next;
        else return MaximalKey_Recursive(next.right);
    }

    public int size(Node x){
        if(x==null) return 0;
        else return x.treeSize;
    }

    public ArrayList<Node> kolejka = new ArrayList<>();

    public void printList () {
        System.out.println(kolejka.toString());
    }

    public void searchRange (Node next, K1 bottom, K1 top){
        if (next==null) return;
        int bottomWithData = compS.compare(bottom, next.key);
        int topWithData = compS.compare(top, next.key);
        if (bottomWithData<0) searchRange(next.left, bottom, top);
        if (bottomWithData<=0 && topWithData >=0) kolejka.add(next);
        if (topWithData>0) searchRange(next.right, bottom, top);
    }

    public void CountLetters(K1 key) {
        root = CountLetters(root, key);
    }

    private Node CountLetters(Node next, K1 key){
        if(next==null) return new Node(key, 1);
        int compare=compS.compare(key,next.key);
        if(compare<0) next.left = CountLetters(next.left, key);
        else if(compare>0) next.right = CountLetters(next.right, key);
        else {next.value++; }
        next.treeSize=size(next.right) + size(next.left) + 1;
        return next;
    }

    public static void main(String[] args) {
        String text="Struktura danych (ang. data structure) - " +
        "sposób przechowywania danych w pamięci komputera. " +
        "Na strukturach danych operują algorytmy, zzzzz";
        char[] chars = text.toCharArray();

        CountingLetters<Character> tree = new CountingLetters<Character>();
        for (int i=0; i<chars.length; i++)
        {
            tree.CountLetters(chars[i]);
        }

        /*
        System.out.println(tree.MaximalKey_Recursive(tree.root));
        System.out.println(tree.root);

        tree.searchRange(tree.root, 'a', 'E');
        tree.printList();
        */
    }
}
