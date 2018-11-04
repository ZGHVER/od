package utils;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private int N=0;
    private Node head;
    private Node now;

    private class Node {
        T data;
        Node next;
    }

    private class itera implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T o = current.data;
            current = current.next;
            return o;
        }

    }

    public void enqueue(T data) {
        Node old = now;
        now = new Node();
        now.data = data;
        now.next = null;
        if (head == null)
            head = now;
        else
            old.next = now;
        N++;
    }

    public T dequeue() {
        T o = head.data;
        head = head.next;
        if (isEmpty())
            now = null;
        N--;
        return o;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size()
    {
        return N;
    }
    @Override

    public Iterator<T> iterator() {
        return new itera();
    }

    public static void main(String[] args) {
        Queue<Integer> a = new Queue<>();
        System.out.println(a.isEmpty());
        for (int i = 0; i < 20; i++)
            a.enqueue(i);
        for (int q : a)
            System.out.println(q);
        a.enqueue(4);
        System.out.println(a.isEmpty());
    }
}