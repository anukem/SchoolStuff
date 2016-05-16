// John Anukem
// jea2161
// Due April 1st

import java.util.PriorityQueue;
import java.util.*;
public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> heap;
    int k;

    public KBestCounter(int k) {
        heap = new PriorityQueue<T>(k);
        this.k = k;
    }

    public void count(T x) {
        if(heap.size() < k ) {
            heap.add(x);
        }
        else {
            if(heap.peek().compareTo(x) < 0) {
                heap.poll();
                heap.add(x);
            }
        }
    }

    public List<T> kbest() {
        LinkedList<T> returnList = new LinkedList<T>();
        int heapSize = heap.size();
        for (int i = 0 ; i < heapSize ; i++ ) {
            
            returnList.addFirst(heap.poll());
        }

        for (T element:returnList) {
                heap.add(element);
        }
        return returnList;
    }

}
