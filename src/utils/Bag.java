package utils;

import java.util.Iterator;

@SuppressWarnings("unused")
public class Bag<T> implements Iterable<T>{
    private int N;
    private Node root;

    private class Node{

        T data;
        Node next;
    }

    private class it implements Iterator<T> {

        private Node now = root;
        @Override
        public boolean hasNext() {
            return root.next == null;
        }

        @Override
        public T next() {
            T data = now.data;
            now=now.next;
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new it();
    }

    public void put(T data){
        Node ne = new Node();
        ne.data = data;
        if(root == null)
            root = ne;
        else
            ne.next = root;
        root = ne;
    }

    public T get(){
        T data = root.data;
        root = root.next;
        return data;
    }

    public int size() {
        return N;
    }
}
