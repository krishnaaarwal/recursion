package Practice.HeapsPractice;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(pq.size() < k){
               pq.add(nums[i]);
            } else if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
