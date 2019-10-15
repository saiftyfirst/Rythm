package com.saiftyfirst.models.heaps;

import java.util.function.BiFunction;

public class MaxHeap<T extends Comparable<? super T>> extends AbstractHeap<T> {

    public MaxHeap() {
        super((t1, t2) -> t1.compareTo(t2) > 0);
    }
}
