package Practice.HeapsPractice.TopKElements;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;

        minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
