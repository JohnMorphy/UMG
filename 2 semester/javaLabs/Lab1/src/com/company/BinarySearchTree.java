package com.company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class BinarySearchTree <K1, K2> {
    private Node root;
    class Node {
        K1 key;
        K2 value;
        Node left;
        Node right;
        int treeSize;
        public Node(K1 a, K2 b, int N) {
            this.key = a;
            this.value = b;
            this.treeSize = N;
        }
        public String toString(){
            String text=String.format("%-11s %-11s %02d",key,value,treeSize);
            return text;
        }
    }

    Collator c = Collator.getInstance(new Locale("pl", "PL"));

    Comparator <K1> compS = new Comparator<K1>(){
        @Override
        public int compare(K1 s1, K1 s2) {
            if (s1.getClass().getName().endsWith("Integer"))
                return (int)Math.signum((int)s1-(int)s2);
            if (s1.getClass().getName().endsWith("Character"))
                return c.compare(String.valueOf(s1), String.valueOf(s2));
            return c.compare(s1,s2);
        }
    };

    Node FindKey_Recursive(K1 key, Node next){
        int compare=compS.compare(key,next.key);
        if(compare==0) return next;
        if(next.left==null && next.right==null) return null;
        if(compare<0) {return FindKey_Recursive(key, next.left);}
        else {return FindKey_Recursive(key, next.right);}
    }

    Node MinimalKey_Recursive(Node next) {
        if (next.left == null) return next;
        else return MinimalKey_Recursive(next.left);
    }

    Node MaximalKey_Recursive(Node next) {
        if (next.right == null) return next;
        else return MaximalKey_Recursive(next.right);
    }

    public Node MinimalKey() {
        Node r=root;
        while(r.left!=null){
            r=r.left;
        }
        return r;
    }

    public Node MaximalKey() {
        Node r=root;
        while(r.right!=null){
            r=r.right;
        }
        return r;
    }

    /*
    public Node FindPlace(K1 key, K2 element) {
        Node r=root, rA=null;
        Node value = new Node (key,element,1);;
        String direction = "";

        while(r!=null){
            rA=r;
            int compare=compS.compare(key,r.key);
            if(compare<0) {direction="left"; r=r.left;}
            else if(compare>0) {direction="right"; r=r.right;}
            else {direction="that"; break;}
        }
        if (root==null){
            root = new Node(key, element, 1);
        }
        else {
            if(direction=="left")
        }
        return value;
    }
    */

    public int size(Node x){
        if(x==null) return 0;
        else return x.treeSize;
    }

    public void FindPlace_Recursive(K1 key, K2 value) {
        root = FindPlace_Recursive(root, key, value);
    }

    private Node FindPlace_Recursive(Node next, K1 key, K2 value){
        if(next==null) return new Node(key, value,1);
        int compare=compS.compare(key,next.key);
        if(compare<0) next.left = FindPlace_Recursive(next.left, key, value);
        else if(compare>0) next.right = FindPlace_Recursive(next.right, key, value);
        else {next.value=value; /*next.ile++;*/}
        next.treeSize=size(next.right) + size(next.left) + 1;
        return next;
    }

    public ArrayList<Node> kolejka = new ArrayList<>();

    public void printList () {
        for(int i=0; i< kolejka.size(); i++)
        {
            System.out.println(kolejka.get(i));
        }
    }

    public void searchRange (Node next, K1 bottom, K1 top){
        if (next==null) return;
        int bottomWithData = compS.compare(bottom, next.key);
        int topWithData = compS.compare(top, next.key);
        if (bottomWithData<0) searchRange(next.left, bottom, top);
        if (bottomWithData<=0 && topWithData >=0) kolejka.add(next);
        if (topWithData>0) searchRange(next.right, bottom, top);
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

    public static void main(String[] args) {
        BinarySearchTree<String,String> tree = new BinarySearchTree<String,String>();

        tree.FindPlace_Recursive("Alabama", "2000-4-14");
        tree.FindPlace_Recursive("Arizona", "2020-11-28");
        tree.FindPlace_Recursive("By", "2014-11-28");
        tree.FindPlace_Recursive("California", "2017-11-28");
        tree.FindPlace_Recursive("Determine", "2021-11-28");
        tree.FindPlace_Recursive("Doberman", "2021-11-28");
        tree.FindPlace_Recursive("England", "2021-11-28");
        tree.FindPlace_Recursive("Falklands", "2021-11-28");
        tree.FindPlace_Recursive("Georgetown", "2021-11-28");
        tree.FindPlace_Recursive("Zambia", "2002-11-11");
        tree.searchRange(tree.root, "a", "Ź");
        //tree.printList();

        System.out.println(tree.returnDepth("Georgetown"));

        /*
        System.out.println(tree.root);
        System.out.println(tree.root.left);
        System.out.println(tree.root.right);
        System.out.println();
        System.out.println(tree.MaximalKey_Recursive(tree.root));
        System.out.println(tree.MinimalKey());
        System.out.println();
        System.out.println(tree.FindKey_Recursive("Texas", tree.root));
        System.out.println(tree.FindKey_Recursive("B", tree.root));
        System.out.println();
        System.out.println();
        */
   }
}
