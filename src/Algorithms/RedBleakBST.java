package Algorithms;

@SuppressWarnings("unused")
/**
 *
 */
public class RedBleakBST<K extends Comparable<K>, D> implements ST<K, D> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root;
    private Node temp;

    private class Node {
        K key;
        D value;
        int N;
        Node left;
        Node right;
        boolean color;

        public Node(K key, D value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.N = n;
        }
    }

    @Override
    public void put(K key, D value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, K key, D value) {
        if (x == null) {
            temp = new Node(key, value, 1, RED);
            return temp;
        }
        int cmp = key.compareTo(x.key);
        if      (cmp > 0)       x.right = put(x.right, key, value);
        else if (cmp < 0)       x.left = put(x.left, key, value);
        else x.value = value;

        if (isRed(x.right) && !isRed(x.left))       x = turnLeft(x);
        if (isRed(x.left) && isRed(x.left.left))    x = turnRight(x);
        if (isRed(x.right) && isRed(x.left))        flipColors(x);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public D get(K key) throws NoSuchElementException {

        if (key.equals(temp)) return temp.value;
        Node x = get(root, key);
        if (x == null)
            throw new NoSuchElementException();
        return x.value;
    }

    private Node get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x;

    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(K key) {
        try {
            final D d = get(key);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }

    public void delMin() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delMin(Node x) {
        if(x.left == null) return null;
        if(!isRed(x.left) && !isRed(x.left.left))
            x=moveRedLeft(x);
        x.left = delMin(x.left);
        return balance(x);
    }

    private Node moveRedLeft(Node x) {
            x.color = RED;
        x.left.color = x.right.color = RED;

        if (isRed(x.right.left)) {
            x.right = turnRight(x.right);
            x = turnLeft(x);
        }
        return x;
    }

    @Override
    public void delete(K k) {

    }

    private Node balance(Node x){
        if          (isRed(x.right))                x=turnLeft(x);
        if (isRed(x.right) && !isRed(x.left))       x = turnLeft(x);
        if (isRed(x.left) && isRed(x.left.left))    x = turnRight(x);
        if (isRed(x.right) && isRed(x.left))        flipColors(x);

        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return x.N;
    }

    @Override
    public Iterable<K> gets() {
        return null;
    }

    @Override
    public Iterable<K> gets(K lo, K hi) {
        return null;
    }

    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    private void flipColors(Node x) {
        x.color = RED;
        x.left.color = x.right.color = BLACK;
    }

    private Node turnLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node turnRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public static void main(String[] args) {
    }
}
