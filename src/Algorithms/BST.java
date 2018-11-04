package Algorithms;

import java.util.Queue;

@SuppressWarnings("unused")
public class BST<K extends Comparable<K>, D> implements ST<K, D> {
    private Node root;

    private class Node {
        K key;
        D value;
        int N;
        Node Left;
        Node Right;

        private Node(K key, D value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public BST() {
    }

    @Override
    public void put(K key, D value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, D value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.Left = put(x.Left, key, value);
        if (cmp > 0) x.Right = put(x.Right, key, value);
        else x.value = value;
        x.N = size(x.Left) + size(x.Right) + 1;
        return x;
    }

    @Override
    public D get(K key) throws NoSuchElementException {
        D o = get(root, key);
        if (o == null) throw new NoSuchElementException();
        else return o;
    }

    private D get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.Left, key);
        else if (cmp > 0) return get(x.Right, key);
        else return x.value;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(K key) {
        try {
            get(key);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.Left == null) return x;
        else return min(x.Left);
    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if (x.Left == null) return x.Right;
        else x.Left = delMin(x.Left);
        x.N = size(x.Left) + size(x.Right) + 1;
        return x;
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.Right == null) return x;
        else return max(x.Right);
    }

    public void delMax() {
        root = delMax(root);
    }

    private Node delMax(Node x) {
        if (x.Right == null) return x.Left;
        else x.Right = delMax(x.Right);
        x.N = size(x.Left) + size(x.Right) + 1;
        return x;
    }

    @Override
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.Right = delete(x.Right, key);
        if (cmp < 0) x.Left = delete(x.Left, key);
        else {
            if (x.Left == null) return x.Right;
            if (x.Right == null) return x.Left;
            Node t = x;
            x = min(t.Right);
            x.Right = delMin(t.Right);
            x.Left = t.Left;
        }
        x.N = size(x.Left) + size(x.Right) + 1;
        return x;
    }

    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node x, K key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.Left, key);
        if (cmp > 0) return 1 + size(x.Left) + rank(x.Right, key);
        else return size(x.Left);
    }

    public K select(int r) {
        return select(root, r).key;
    }

    private Node select(Node x, int r) {
        if (x == null) return null;
        int d = size(x.Left);
        if (d > r) return select(x.Left, r);
        if (d < r) return select(x.Right, r - d - 1);
        else return x;
    }

    public K floor(K Key) {
        return floor(root, Key).key;
    }

    private Node floor(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.Left, key);
        else {
            Node t = floor(x.Right, key);
            if (t == null) return x;
            else return t;
        }
    }

    public K ceiling(K key) {
        return ceiling(root, key).key;
    }

    private Node ceiling(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.Right, key);
        else {
            Node t = ceiling(x.Left, key);
            if (t == null) return x;
            else return t;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    @Override
    public Iterable<K> gets() {
        return gets(min(), max());
    }

    @Override
    public Iterable<K> gets(K lo, K hi) {
        return null;
    }

    private void gets(Queue queue, Node x, K lo, K hi) {
        if (x == null) return;
        int cmpL = lo.compareTo(x.key);
        int cmpH = hi.compareTo(x.key);
        if      (cmpH < 0)                  gets(queue, x.Left, lo, hi);
        else if (cmpL > 0)                  gets(queue, x.Right, lo, hi);
        else if (cmpH >= 0 && cmpL <= 0)    queue.add(x);
    }

    public static void main(String[] args) throws NoSuchElementException {
        BST<Integer, Integer> a = new BST<>();
        a.put(2, 2);
        a.put(1, 2);
        System.out.println(a.get(2));
    }
}
