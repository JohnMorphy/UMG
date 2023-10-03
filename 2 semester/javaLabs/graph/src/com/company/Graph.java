package com.company;

import java.util.Queue;

public class Graph {

    private int V;
    private int E;
    public Bag<Integer>[] neighbours;
    public int[] edgeTo;
    public boolean[] marking;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        edgeTo = new int[V];
        marking = new boolean[V];
        neighbours = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) neighbours[v] = new Bag<Integer>();
    }

    public void addEdge(int v, int w)
    {
        neighbours[v].add(w);
        neighbours[w].add(v);
        E++;
    }

    private int s=0;
    private void dfs(Graph g, int v)
    {
        marking[v]=true;
        for (int w:g.neighbours[v])
        {
            if(!marking[w]){
                System.out.println("Checking dfs "+w);
                edgeTo[w]=v;
                dfs(g,w);
            }
        }
    }
    private void bfs(Graph g, int v)
    {
        Queue<Integer> queue = new Queue<Integer>();
        marking[v]= true;
        queue.add(v);
        while(!queue.isEmpty())
        {
            int vv=queue.remove();
            for(int w: g.neighbours[vv])
            {
                if(!marking[w])
                {
                    System.out.println("Checking bfs "+w);
                    edgeTo[w]=vv;
                    marking[w]=true;
                    queue.add(w);
                }
            }
        }

    }

    public boolean existsPathTo(int v)
    {
        return marking[v];
    }


    public Iterable<Integer> pathTo(int v)
    {
        if(!existsPathTo(v)) return null;

        Bag<Integer> path=new Bag<>();

        for(int x=v;x!=s;x= edgeTo[x])
        {
            path.add(x);
        }
        System.out.println(s);
        path.add(s);
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,5);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(1,2);
        graph.addEdge(0,1);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(0,2);

        /* Dla pewnego grafu i początkowego wierzchołka odpowiedz na pytanie:
        czy istnieje ścieżka od wierzchołka początkowego do wskazanego celu?
        Jeżeli drogra istnieje należy ją pokazać
         */


        for (int i = 0; i< graph.V; i++) {

            System.out.println("Dla "+i+": ");

            for (Integer j : graph.neighbours[i]) {
                System.out.print(" " + j);
            }
            System.out.println();
        }

        //graph.dfs();
        System.out.println(graph.pathTo(3));

    }
}
