package com.saiftyfirst.models.heaps;

import java.util.Arrays;
import java.util.function.BiFunction;

public class AbstractHeap implements Heap {

    private int capacity = 10;
    private int size = 0;
    private int[] heap;
    private BiFunction<Integer, Integer, Boolean> comparator;

    AbstractHeap(final BiFunction<Integer, Integer, Boolean> comparator) {
        this.heap = new int[this.capacity];
        this.comparator = comparator;
    }

    private int getParentIndex(final int idx) { return (idx - 1) / 2; }
    private int getLeftChildIndex(final int idx) { return idx * 2 + 1; }
    private int getRightChildIndex(final int idx) { return idx * 2 + 2; }

    private boolean hasParent(final int idx) { return getParentIndex(idx) >= 0; }
    private boolean hasLeftChild(final int idx) { return getLeftChildIndex(idx) < this.size; }
    private boolean hasRightChild(final int idx) { return getRightChildIndex(idx) < this.size; }

    private int getParent(final int idx) { return this.heap[getParentIndex(idx)]; }
    private int getLeftChild(final int idx) { return this.heap[getLeftChildIndex(idx)]; }
    private int getRightChild(final int idx) { return this.heap[getRightChildIndex(idx)]; }

    private void swap(final int idxUno, final int idxDos) {
        int temp = this.heap[idxUno];
        this.heap[idxUno] = this.heap[idxDos];
        this.heap[idxDos] = temp;
    }

    private void checkAndExtend() {
        if (this.size == this.capacity) {
            this.heap = Arrays.copyOf(this.heap, this.capacity * 2);
            this.capacity *= 2;
        }
    }

    private void rise(final int index) {

    }

    private void sink(final int index) {

    }

    @Override
    public void insert(int item) {
        this.checkAndExtend();
        this.heap[this.size] = item;
        this.rise(this.size++);
    }

    @Override
    public void pop() {
        this.heap[0] = this.heap[size - 1];
        this.sink(0);
    }

    @Override
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return this.heap[0];
    }

}
