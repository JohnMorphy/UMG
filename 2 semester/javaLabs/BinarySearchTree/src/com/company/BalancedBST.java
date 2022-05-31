package com.company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class BalancedBST<K1, K2> {
    static final boolean RED =true;
    static final boolean BLACK =false;
    private Node root;
    class Node {
        K1 key;
        K2 value;
        Node left;
        Node right;
        int treeSize;
        boolean color;

        public Node(K1 a, K2 b, int N, boolean color) {
            this.key = a;
            this.value = b;
            this.treeSize = N;
            this.color = color;
        }

        public String toString(){
            return String.format("%-11s %-11s %02d",key,value,treeSize);
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

    public int size(Node x){
        if(x==null) return 0;
        else return x.treeSize;
    }

    public Node leftRotation(Node h) {
        //turning around node h
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        x.treeSize=h.treeSize;
        h.treeSize=1+size(h.left)+size(h.right);
        return x;
    }

    public Node rightRotation(Node h) {
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        x.treeSize=h.treeSize;
        h.treeSize=1+size(h.left)+size(h.right);
        return x;
    }

    void changeColors(Node h) {
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }

    boolean isRed(Node x){
        if(x==null) return false;
        return !x.color;
    }

    public void FindPlace_Recursive(K1 key, K2 value) {
        root = FindPlace_Recursive(root, key, value);
        root.color=BLACK;
    }

    private Node FindPlace_Recursive(Node next, K1 key, K2 value){
        if(next==null) return new Node(key, value,1, RED);
        int compare=compS.compare(key,next.key);
        if(compare<0) next.left = FindPlace_Recursive(next.left, key, value);
        else if(compare>0) next.right = FindPlace_Recursive(next.right, key, value);
        else {next.value=value;}
        if(isRed(next.right) && !isRed(next.left)) next=leftRotation(next);
        if(isRed(next.left) && isRed(next.left.left)) next=rightRotation(next);
        if(isRed(next.right) && isRed(next.left)) changeColors(next);
        next.treeSize=size(next.left) + size(next.right) + 1;
        return next;
    }

    public int returnDepth(K1 key){
        int level=0;
        Node n=root;
        while(n!=null) {
            level++;
            int comparison = compS.compare(key, n.key);
            if (comparison < 0) n = n.left;
            else if (comparison > 0) n = n.right;
            else return level;
        }
        return -1;
    }

    public int returnHeight(){
        if(Queue.isEmpty()) return -1;
        int height = 0;
        int keyLevel = 0;
        for (Node n: Queue)
        {
            keyLevel = returnDepth(n.key);
            if (height<keyLevel)
                height = keyLevel;
        }
        return height;
    }

    public void searchRange (Node next, K1 bottom, K1 top){
        if (next==null) return;
        int bottomWithData = compS.compare(bottom, next.key);
        int topWithData = compS.compare(top, next.key);
        if (bottomWithData<0) searchRange(next.left, bottom, top);
        if (bottomWithData<=0 && topWithData >=0) Queue.add(next);
        if (topWithData>0) searchRange(next.right, bottom, top);
    }

    public ArrayList<Node> Queue = new ArrayList<>();

    public void printList () {
        for(int i = 0; i< Queue.size(); i++)
        {
            System.out.println(Queue.get(i));
        }
    }

    public static void main(String[] args) {

        BalancedBST<String,String> tree = new BalancedBST<>();

        tree.FindPlace_Recursive("Alabama", "2000-4-14");
        tree.FindPlace_Recursive("Arizona", "2020-11-28");
        tree.FindPlace_Recursive("By", "2014-11-28");
        tree.FindPlace_Recursive("California", "2017-11-28");
        tree.FindPlace_Recursive("Determine", "2021-11-28");
        tree.FindPlace_Recursive("Doberman", "2021-11-28");
        tree.FindPlace_Recursive("England", "2021-11-28");
        tree.FindPlace_Recursive("Falklands", "2021-11-28");
        tree.FindPlace_Recursive("Georgetown", "2021-11-28");
        tree.searchRange(tree.root, " ", "Z");
        //tree.printList();

        System.out.println(tree.returnDepth("Georgetown"));

        System.out.println(tree.returnHeight());
    }
}