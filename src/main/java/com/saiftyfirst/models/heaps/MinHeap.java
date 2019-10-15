package com.saiftyfirst.models.heaps;

public class MinHeap<T extends Comparable<? super T>> extends AbstractHeap<T> {

    public MinHeap() {
        super((uno, dos) -> uno.compareTo(dos) < 0);
    }
}
