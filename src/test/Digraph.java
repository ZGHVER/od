package test;

import utils.Queue;
@SuppressWarnings("unchecked")
public class Digraph {
    private int v;
    private int e;
    private Queue<Integer>[] adj;

    public Digraph(int v) {
        this.v = v;
        adj = (Queue<Integer>[])new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph o = new Digraph(v);
        for (int i = 0; i < v; i++) {
            for (Integer w : adj[v]) {
                o.addEdge(w,v);
            }
        }

        return o;
    }

    public int V(){
        return v;
    }

    public int E(){
        return e;
    }

}
