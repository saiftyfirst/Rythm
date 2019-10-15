package models.heaps;

import com.saiftyfirst.models.heaps.MaxHeap;
import com.saiftyfirst.models.heaps.MinHeap;
import org.junit.Test;

public class HeapTests {

    @Test
    public void MinHeapTest() {
        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.insert(5);
        assert minHeap.size() == 1;
        assert minHeap.peek() == 5;

        minHeap.insert(3);
        assert minHeap.size() == 2;
        assert minHeap.peek() == 3;

        minHeap.insert(4);
        assert minHeap.size() == 3;
        assert minHeap.peek() == 3;

        minHeap.insert(7);
        assert minHeap.size() == 4;
        assert minHeap.peek() == 3;

        minHeap.insert(6);
        assert minHeap.size() == 5;
        assert minHeap.peek() == 3;

        assert minHeap.pop() == 3;
        assert minHeap.size() == 4;
        assert minHeap.peek() == 4;

        assert minHeap.pop() == 4;
        assert minHeap.size() == 3;
        assert minHeap.peek() == 5;

        assert minHeap.pop() == 5;
        assert minHeap.size() == 2;
        assert minHeap.peek() == 6;

        assert minHeap.pop() == 6;
        assert minHeap.size() == 1;
        assert minHeap.peek() == 7;

        assert minHeap.pop() == 7;
        assert minHeap.size() == 0;

    }

    @Test
    public void MaxHeapTest() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.insert(5);
        assert maxHeap.size() == 1;
        assert maxHeap.peek() == 5;

        maxHeap.insert(3);
        assert maxHeap.size() == 2;
        assert maxHeap.peek() == 5;

        maxHeap.insert(4);
        assert maxHeap.size() == 3;
        assert maxHeap.peek() == 5;

        maxHeap.insert(7);
        assert maxHeap.size() == 4;
        assert maxHeap.peek() == 7;

        maxHeap.insert(6);
        assert maxHeap.size() == 5;
        assert maxHeap.peek() == 7;

        assert maxHeap.pop() == 7;
        assert maxHeap.size() == 4;
        assert maxHeap.peek() == 6;

        assert maxHeap.pop() == 6;
        assert maxHeap.size() == 3;
        assert maxHeap.peek() == 5;

        assert maxHeap.pop() == 5;
        assert maxHeap.size() == 2;
        assert maxHeap.peek() == 4;

        assert maxHeap.pop() == 4;
        assert maxHeap.size() == 1;
        assert maxHeap.peek() == 3;

        assert maxHeap.pop() == 3;
        assert maxHeap.size() == 0;

    }

}
