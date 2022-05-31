package com.company;

import java.util.Iterator;

public class Graph {
    private int V;  // node
    private int E;  // edge
    public Bag[] neighbours;
    public int[] edgeTo;
    public boolean[] marked;

    public Graph(int V)
    {
        this.V=V;
        this.E=0;

        edgeTo = new int[V];
        marked = new boolean[V];
        neighbours = (Bag<Integer>[]) new Bag[V];

        for(int v=0; v<V; v++)
        {
            neighbours[v] = new Bag<Integer>();
        }
    }

    public void addEdge (int v, int w){
        neighbours[v].addItem(w);
        neighbours[v].addItem(v);
        E++;
    }

    private int s=0;
    private void depthFirstSearch(Graph g, int v) {
        marked[v]=true;
        for(int w : g.neighbours[v]) {
            if(!marked[w]){
                System.out.println("cheching dfs " + w);
                edgeTo[w]=v;
                depthFirstSearch(g,w);
            }
        }
    }

    public boolean existsPathTo(int v) {return marked[v];}
    public Iterable<Integer> pathTo(int v){
        if(!existsPathTo(v)) return null;
        Bag<Integer> path = new Bag<>();
        for(int x=v; x!=s; x=edgeTo[x]) path.addItem(x);
        path.addItem(s);
        return path;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge (3, 5);
        graph.addEdge (4, 5);
        graph.addEdge (3, 6);
        graph.addEdge (4, 7);
        graph.addEdge (7, 6);
        graph.addEdge (1, 2);
        graph.addEdge (2, 8);
        graph.addEdge (1, 5);

        for (Integer i: graph.neighbours[0])
        {
            System.out.println(" " + i);
        }
        Iterator<Integer> it;
        for(int i=0; i<graph.neighbours.length; i++)
        {
            it=graph.neighbours[i].iterator();
            System.out.println("Next nodes of "+i+" ");
            while(it.hasNext()) System.out.println(it.next() + " ");
            System.out.println();
        }
    }
}

