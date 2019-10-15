package com.saiftyfirst.models.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public abstract class AbstractHeap<T> implements Heap<T> {

    private ArrayList<T> heap;
    private final BiFunction<T, T, Boolean> comparator;

    AbstractHeap(final BiFunction<T, T, Boolean> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    private int getParentIndex(final int idx) { return (idx - 1) / 2; }
    private int getLeftChildIndex(final int idx) { return idx * 2 + 1; }
    private int getRightChildIndex(final int idx) { return idx * 2 + 2; }

    private boolean hasParent(final int idx) { return getParentIndex(idx) >= 0; }
    private boolean hasLeftChild(final int idx) { return getLeftChildIndex(idx) < this.heap.size(); }
    private boolean hasRightChild(final int idx) { return getRightChildIndex(idx) < this.heap.size(); }

    private T getParent(final int idx) { return this.heap.get(getParentIndex(idx)); }
    private T getLeftChild(final int idx) { return this.heap.get(getLeftChildIndex(idx)); }
    private T getRightChild(final int idx) { return this.heap.get(getRightChildIndex(idx)); }

    private void swap(final int idxUno, final int idxDos) {
        T temp = this.heap.get(idxUno);
        this.heap.set(idxUno, this.heap.get(idxDos));
        this.heap.set(idxDos, temp);
    }

    private void rise() {
        int parentIdx;
        int idx = this.heap.size() - 1;
        while (this.hasParent(idx)) {
            parentIdx = getParentIndex(idx);
            if (this.comparator.apply(this.heap.get(idx), this.heap.get(parentIdx))) {
                swap(idx, parentIdx);
                idx = parentIdx;
            } else {
                break;
            }
        }
    }

    private void sink() {
        int childIdx;
        int idx = 0;
        while (this.hasLeftChild(idx)) {
            childIdx = this.comparator.apply(this.getRightChild(idx), this.getLeftChild(idx)) ?
                    this.getRightChildIndex(idx) : this.getLeftChildIndex(idx);
            if (this.comparator.apply(this.heap.get(childIdx), this.heap.get(idx))) {
                this.swap(idx, childIdx);
                idx = childIdx;
            } else {
                break;
            }
        }
    }

    @Override
    public void insert(T item) {
        this.heap.add(item);
        this.rise();
    }

    @Override
    public T pop() {
        if (this.heap.size() == 0) throw new IllegalStateException();
        T item =  this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.sink();
        return item;
    }

    @Override
    public T peek() {
        if (this.heap.size() == 0) throw new IllegalStateException();
        return this.heap.get(0);
    }

    @Override
    public void printHeap() {
        System.out.println(this.heap.toString());
    }
}
