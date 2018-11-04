package Algorithms;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private int N;
    private Node first;

    private class Node {
        T data;
        Node next;
    }

    private class itera implements Iterator<T> {
        private Node temp = first;

        public boolean hasNext() {
            return temp != null;
        }

        public T next() {
            T o = temp.data;
            temp = temp.next;
            return o;
        }

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T data) {
        Node of = first;
        first = new Node();
        first.data = data;
        first.next = of;
        N++;
    }

    public T pop() {
        T o = first.data;
        first = first.next;
        N--;
        return o;
    }

    public int getNumer()
    {
        return N;
    }

    public Iterator<T> iterator() {
        return new itera();
    }

    public static void main(String[] args) {
        Stack<Integer> a = new Stack<Integer>();
        System.out.println(a.isEmpty());
        for (int i = 0; i < 20; i++)
            a.push(i);
        for (int q : a)
            System.out.print(q + " ");
        System.out.println(a.isEmpty());
    }
}
