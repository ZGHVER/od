package Algorithms;

@SuppressWarnings("unused")
public interface ST <K,D>{

    void put(K key,D value);
    D get(K key) throws NoSuchElementException;
    boolean isEmpty();
    boolean contains(K key);
    void delete(K k);
    int size();
    Iterable<K> gets();
    Iterable<K> gets(K lo,K hi);

}
