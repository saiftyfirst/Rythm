package com.saiftyfirst.models.heaps;

public interface Heap<T> {

    void insert(T item);
    T pop();
    T peek();
    int size();
    void printHeap();

}
