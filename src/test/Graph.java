package test;

import utils.Queue;

import java.util.Scanner;

@SuppressWarnings({"unused", "WeakerAccess","unchecked"})
public class Graph {
    private int E;
    private final int V;
    private Queue<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Queue<Integer>[]) new Queue[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Queue<>();
    }

    public Graph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

